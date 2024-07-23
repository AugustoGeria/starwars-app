package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import com.example.starwarsapp.DTO.VehicleDTO.VehiclePropertiesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService{

    private final WebClient webClient;
    @Value("${starwars.api.base-url}")
    protected String baseUrl;
    @Override
    public PaginatedListResponseDTO getAllVehicles(int page, int size) {
        String url = String.format("%s/vehicles/?page=%d&limit=%d", baseUrl, page, size);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(PaginatedListResponseDTO.class)
                .block();
    }

    @Override
    public IdResponseDTO getVehicleById(String id) {
        String url = String.format("%s/vehicles/%s/", baseUrl, id);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<IdResponseDTO<VehiclePropertiesDTO>>() {} )
                .block();
    }

    @Override
    public SearchResponseDTO searchVehiclesByName(String name) {
        String url = String.format("%s/vehicles/?name=%s", baseUrl, name);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<VehiclePropertiesDTO>>() {} )
                .block();
    }

    @Override
    public SearchResponseDTO searchVehiclesByModel(String name) {
        String url = String.format("%s/vehicles/?model=%s", baseUrl, name);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<SearchResponseDTO<VehiclePropertiesDTO>>() {} )
                .block();
    }
}
