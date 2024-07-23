package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.PeopleDTO.PeoplePropertiesDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService{
    private final WebClient webClient;
    @Value("${starwars.api.base-url}")
    protected String baseUrl;

    @Override
    public PaginatedListResponseDTO getAllPeople(int page, int size) {
        String url = String.format("%s/people?page=%d&limit=%d", baseUrl, page, size);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(PaginatedListResponseDTO.class)
                .block();
    }

    @Override
    public IdResponseDTO getPersonById(String id) {
        String url = String.format("%s/people/%s/", baseUrl, id);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<IdResponseDTO<PeoplePropertiesDTO>>() {} )
                .block();
    }

    @Override
    public SearchResponseDTO searchPeopleByName(String name) {
        String url = String.format("%s/people/?name=%s", baseUrl, name);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<PeoplePropertiesDTO>>() {} )
                .block();
    }
}
