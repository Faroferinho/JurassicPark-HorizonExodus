package org.example.controllers;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.apache.tomcat.util.bcel.Const;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.example.documents.Operation;
import org.example.documents.dto.OperationDTO;
import org.example.safety.Constants;
import org.example.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class OperationController implements CRUDController<Operation, OperationDTO>{
    @Autowired
    private OperationService service;

    //Configuring WebClient Instance with HTTP Client
    HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
            .responseTimeout(Duration.ofMillis(1000))
            .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                    .addHandlerLast(new WriteTimeoutHandler(1000, TimeUnit.MILLISECONDS)));

    //Creating a WebClient
    WebClient client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .baseUrl(Constants.AUTHORIZATION)
            .build(); //Had to Import spring-boot-starter-webflux dependency

    @Override
    @PostMapping(Constants.OPERATION)
    public ResponseEntity<Operation> create(@RequestHeader String Authorization, @RequestBody OperationDTO dto) {
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("verify/");

        //Filling Header
        WebClient.ResponseSpec responseSpec = uri.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .header("Authorization", Authorization)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<String> response = uri.retrieve().bodyToMono(String.class);

        //TODO - After changing verifyValidity in Authorizator, change this if
        if(Objects.equals(response.block(), Authorization)){
            return ResponseEntity.ok(service.save(dto));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Authorization");
    }

    @Override
    @PutMapping(Constants.OPERATION + "{id}")
    public ResponseEntity<Operation> update(@RequestHeader String Authorization, @PathVariable String id, @RequestBody OperationDTO dto) {
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("verify/");

        //Filling Header
        WebClient.ResponseSpec responseSpec = uri.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .header("Authorization", Authorization)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<String> response = uri.retrieve().bodyToMono(String.class);

        //TODO - After changing verifyValidity in Authorizator, change this if
        if(Objects.equals(response.block(), Authorization)){
            Operation o = new Operation(dto);
            o.setId(id);

            return ResponseEntity.ok(service.change(o));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Authorization");
    }

    @Override
    @GetMapping(Constants.OPERATION)
    public ResponseEntity<List<Operation>> findAll(@RequestHeader String Authorization) {
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("verify/");

        //Filling Header
        WebClient.ResponseSpec responseSpec = uri.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .header("Authorization", Authorization)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<String> response = uri.retrieve().bodyToMono(String.class);

        //TODO - After changing verifyValidity in Authorizator, change this if
        if(Objects.equals(response.block(), Authorization)){
            return ResponseEntity.ok(service.findAll());
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Authorization");
    }

    @Override
    @GetMapping(Constants.OPERATION + "{id}")
    public ResponseEntity<Optional<Operation>> findById(@RequestHeader String Authorization, @PathVariable String id) {
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("verify/");

        //Filling Header
        WebClient.ResponseSpec responseSpec = uri.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .header("Authorization", Authorization)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<String> response = uri.retrieve().bodyToMono(String.class);

        //TODO - After changing verifyValidity in Authorizator, change this if
        if(Objects.equals(response.block(), Authorization)){
            return ResponseEntity.ok(service.findByID(id));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Authorization");
    }

    @Override
    @DeleteMapping(Constants.OPERATION + "{id}")
    public ResponseEntity<Void> deleteById(@RequestHeader String Authorization, @PathVariable String id) {
        //Defining the HTTP Method
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

        //Specifying URL
        WebClient.RequestBodySpec uri = uriSpec.uri("verify/");

        //Filling Header
        WebClient.ResponseSpec responseSpec = uri.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .header("Authorization", Authorization)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();

        Mono<String> response = uri.retrieve().bodyToMono(String.class);

        //TODO - After changing verifyValidity in Authorizator, change this if
        if(Objects.equals(response.block(), Authorization)){
            service.deleteByID(id);
            return ResponseEntity.noContent().build();
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Authorization");
    }
}
