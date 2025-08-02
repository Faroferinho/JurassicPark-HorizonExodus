package org.example.controllers;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.example.models.Authorization;
import org.example.models.LoginDTO;
import org.example.models.RegisterDTO;
import org.example.safety.Constants;
import org.example.safety.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
public class AuthenticationController {
    @Autowired
    private JWTTokenProvider tokenProvider;

    //Configuring WebClient Instance with HTTP Client
    HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
            .responseTimeout(Duration.ofMillis(1000))
            .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
            .addHandlerLast(new WriteTimeoutHandler(1000, TimeUnit.MILLISECONDS)));

    //Creating a WebClient
    WebClient client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .baseUrl(Constants.EMPLOYEES)
            .build(); //Had to Import spring-boot-starter-webflux dependency

    @PostMapping(Constants.LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginDTO dto){
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("login/");

        //Filling body
        WebClient.RequestHeadersSpec<?> bodySpec = uri.body(
                BodyInserters.fromValue(dto)
        );

        //Filling Header
        WebClient.ResponseSpec responseSpec = bodySpec.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<Boolean> response = bodySpec.retrieve().bodyToMono(Boolean.class);

        if (Boolean.TRUE.equals(response.block())){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", tokenProvider.tokenGenerator(dto.getEmail()));

            return new ResponseEntity<String>("Authorized", headers, HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User and/or Password");
    }

    @PostMapping(Constants.SIGNIN)
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto){
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("register/");

        //Filling body
        WebClient.RequestHeadersSpec<?> bodySpec = uri.body(
                BodyInserters.fromValue(dto)
        );

        //Filling Header
        WebClient.ResponseSpec responseSpec = bodySpec.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve()
                .onStatus(
                        HttpStatus.BAD_REQUEST::equals,
                        response -> {
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exits");
                        }
                );

        Mono<Boolean> response = responseSpec.bodyToMono(Boolean.class);

        if (Boolean.TRUE.equals(response.block())){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", tokenProvider.tokenGenerator(dto.getEmail()));

            return new ResponseEntity<>("Authorized", headers, HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exits");
    }

    //TODO - Add Request Header String user to improve safety!
    @GetMapping(Constants.VERIFY)
    private ResponseEntity<String> verifyValidity(@RequestHeader String Authorization){
        System.out.println("Entered verifyValidity");
        if (tokenProvider.validateToken(Authorization)){
            System.out.println("User " + tokenProvider.getUserFromToken(Authorization) + " validated!");
            return ResponseEntity.ok(Authorization);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token Invalid");
    }
}
