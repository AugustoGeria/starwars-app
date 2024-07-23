package com.example.starwarsapp.DTO.ResponseDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResponseDTO<T> {
    private String message;
    private List<SearchAndIdResultDTO<T>> result;}
