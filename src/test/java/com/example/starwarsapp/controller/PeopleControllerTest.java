package com.example.starwarsapp.controller;


import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PeopleControllerTest {

    @Test
    public void testGetAllPeople() {

        PaginatedListResponseDTO responseDTO = new PaginatedListResponseDTO();
        String message = "test";
        responseDTO.setMessage(message);
        responseDTO.setTotalRecords(1);
        responseDTO.setTotalPages(1);
        PeopleService service = Mockito.mock(PeopleService.class);
        when(service.getAllPeople(1, 10)).thenReturn(responseDTO);

        WebTestClient client =
                WebTestClient.bindToController(new PeopleController(service)).build();

        client.get().uri("/people")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isNotEmpty()
                .jsonPath("$.message").isEqualTo("test")
                .jsonPath("$.total_records").isEqualTo(1)
                .jsonPath("$.total_pages").isEqualTo(1);
    }
}

