package com.example.starwarsapp.DTO.ResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdResponseDTO<T> {
    private String message;
    private SearchAndIdResultDTO<T> result;
}
