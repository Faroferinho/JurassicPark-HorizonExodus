package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Operations Controller",
                version = "1.0",
                description = "This API is designed to provide a comprehensive and flexible interface for managing " +
                        "listings and the tasks (operations) associated with them. It allows for the full lifecycle " +
                        "management of a listing, from its creation to the execution and completion of all necessary " +
                        "tasks. The API is built on a RESTful architecture, utilizing standard HTTP methods to perform " +
                        "actions on resources."
        )
)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}