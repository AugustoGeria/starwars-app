package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;

public interface FilmService {
    SearchResponseDTO getAllFilms(int page, int size);

    IdResponseDTO getFilmById(String id);

    SearchResponseDTO searchFilmsByTitle(String title);
}
