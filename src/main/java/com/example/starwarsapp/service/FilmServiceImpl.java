package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.FilmDTO.FilmPropertiesDTO;
import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService{

    private final WebClient webClient;
    @Value("${starwars.api.base-url}")
    protected String baseUrl;

    @Override
    public SearchResponseDTO getAllFilms(int page, int size) {
        String url = String.format("%s/films/?page=%d&limit=%d", baseUrl, page, size);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<FilmPropertiesDTO>>() {} )
                .block();
    }

    @Override
    public IdResponseDTO getFilmById(String id) {
        String url = String.format("%s/films/%s/", baseUrl, id);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<IdResponseDTO<FilmPropertiesDTO>>() {} )
                .block();
    }

    @Override
    public SearchResponseDTO searchFilmsByTitle(String title) {
        String url = String.format("%s/films/?search=%s", baseUrl, title);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<FilmPropertiesDTO>>() {} )
                .block();
    }
}
