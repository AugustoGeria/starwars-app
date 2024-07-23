package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;

public interface StarshipService {
    PaginatedListResponseDTO getAllStarships(int page, int size);

    IdResponseDTO getStarshipById(String id);

    SearchResponseDTO searchStarshipsByName(String name);

    SearchResponseDTO searchStarshipsByModel(String model);
}
