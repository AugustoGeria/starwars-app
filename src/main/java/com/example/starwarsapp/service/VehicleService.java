package com.example.starwarsapp.service;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;

public interface VehicleService {
    PaginatedListResponseDTO getAllVehicles(int page, int size) ;

    IdResponseDTO getVehicleById(String id);

    SearchResponseDTO searchVehiclesByName(String name);

    SearchResponseDTO searchVehiclesByModel(String name);
}
