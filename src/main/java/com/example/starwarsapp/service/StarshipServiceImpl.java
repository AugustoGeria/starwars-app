package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import com.example.starwarsapp.DTO.StarshipDTO.StarshipPropertiesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@RequiredArgsConstructor
@Service
public class StarshipServiceImpl implements StarshipService{

    private final WebClient webClient;
    @Value("${starwars.api.base-url}")
    protected String baseUrl;
    @Override
    public PaginatedListResponseDTO getAllStarships(int page, int size) {
        String url = String.format("%s/starships/?page=%d&limit=%d", baseUrl, page, size);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(PaginatedListResponseDTO.class)
                .block();
    }

    @Override
    public IdResponseDTO<StarshipPropertiesDTO> getStarshipById(String id) {
        String url = String.format("%s/starships/%s/", baseUrl, id);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<IdResponseDTO<StarshipPropertiesDTO>>() {} )
                .block();
    }


    @Override
    public SearchResponseDTO<StarshipPropertiesDTO> searchStarshipsByName(String name) {
        String url = String.format("%s/starships/?name=%s", baseUrl, name);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<StarshipPropertiesDTO>>() {} )
                .block();
    }

    @Override
    public SearchResponseDTO<StarshipPropertiesDTO> searchStarshipsByModel(String model) {
        String url = String.format("%s/starships/?model=%s", baseUrl, model);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<StarshipPropertiesDTO>>() {} )
                .block();
    }
}
