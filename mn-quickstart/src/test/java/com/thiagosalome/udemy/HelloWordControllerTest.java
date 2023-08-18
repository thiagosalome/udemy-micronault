package com.thiagosalome.udemy;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.jupiter.api.Assertions.assertEquals;


import jakarta.inject.Inject;

@MicronautTest
class HelloWordControllerTest {

    @Inject // Injects the application
    @Client("/")
    HttpClient client; // Injects a client to make requests to the server

    @Test
    void helloWorldEndpointRespondsWithProperContent() {
        var response = client
            .toBlocking() // Blocks the thread until the response is received
            .retrieve("/hello"); // Makes a GET request to the /hello endpoint and returns only the body
        
        assertEquals("Hello from service!", response); // Checks if the response is "Hello"
    }
    
    @Test
    void helloWorldEndpointRespondsWithStatusCodeAndContent() {
        var response = client
            .toBlocking() // Blocks the thread until the response is received
            .exchange("/hello", String.class); // Makes a GET request to the /hello endpoint and returns the whole response
        
        assertEquals("Hello from service!", response.body()); // Checks if the response is "Hello World!"
        assertEquals(HttpStatus.OK, response.status()); // Checks if the status code is 200
    }

    @Test
    void helloWorldFromConfigEndpointReturnsMessageFromConfigFile() {
        var response = client.toBlocking().retrieve("/hello/config");

        assertEquals("Hello World from config!", response);
    }
    
    @Test
    void helloFromTranslationEndpointReturnsContenteFromConfigFile() {
        var response = client.toBlocking().exchange("/hello/translation", JsonNode.class);

        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("{\"br\":\"Ol\u00E1 Mundo!\",\"en\":\"Hello World!\"}", response.getBody().get().toString());
    }
}
