package com.example.starwarsapp.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class PeopleControllerIntegrationTest {
   /* @Test
    @Disabled("run only when server is up")
    public void testGetPeople() {

        WebTestClient webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080")
                .build();

        webTestClient.get().uri("/people")
                        .accept(MediaType.APPLICATION_JSON)
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody()
                        .jsonPath("$.message").isEqualTo("ok")
                        .jsonPath("$.next").isEqualTo("https://www.swapi.tech/api/people?page=2&limit=10")
                        .jsonPath("$.total_records").isEqualTo(82)
                        .jsonPath("$.total_pages").isEqualTo(9)
                        .jsonPath("$.results[0].uid").isEqualTo("1")
                        .jsonPath("$.results[0].name").isEqualTo("Luke Skywalker")
                        .jsonPath("$.results[0].url").isEqualTo("https://www.swapi.tech/api/people/1")
                        .jsonPath("$.results[1].uid").isEqualTo("2")
                        .jsonPath("$.results[1].name").isEqualTo("C-3PO")
                        .jsonPath("$.results[1].url").isEqualTo("https://www.swapi.tech/api/people/2");
    }*/

}
