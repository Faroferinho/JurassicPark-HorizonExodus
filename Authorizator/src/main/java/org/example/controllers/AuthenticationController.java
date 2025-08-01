package org.example.controllers;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.example.models.Authorization;
import org.example.models.LoginDTO;
import org.example.safety.Constants;
import org.example.safety.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .responseTimeout(Duration.ofMillis(5000))
            .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
            .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

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
        //TODO - Alter reference
        WebClient.RequestBodySpec bodySpec = uriSpec.uri("login/");

        //Filling body
        WebClient.RequestHeadersSpec<?> headersSpec = bodySpec.body(
                BodyInserters.fromValue(dto)
        );

        //Filling Header
        WebClient.ResponseSpec responseSpec = headersSpec.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<Boolean> response = headersSpec.retrieve().bodyToMono(Boolean.class);

        if (Boolean.TRUE.equals(response.block())){
            return ResponseEntity.ok(tokenProvider.tokenGenerator(dto.getEmail()));
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User and/or Password");
    }
}
