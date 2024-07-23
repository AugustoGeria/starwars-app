package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;

public interface PeopleService {
    PaginatedListResponseDTO getAllPeople(int page, int size);

    IdResponseDTO getPersonById(String id);

    SearchResponseDTO searchPeopleByName(String name);
}
