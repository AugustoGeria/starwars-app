package com.example.starwarsapp.controller;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import com.example.starwarsapp.DTO.VehicleDTO.VehiclePropertiesDTO;
import com.example.starwarsapp.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor

public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<PaginatedListResponseDTO> getAllVehicles(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(vehicleService.getAllVehicles(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdResponseDTO<VehiclePropertiesDTO>> getVehicleById(@PathVariable String id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping("/search/by-name")
    public ResponseEntity<SearchResponseDTO<VehiclePropertiesDTO>> searchVehiclesByName(@RequestParam String name) {
        return ResponseEntity.ok(vehicleService.searchVehiclesByName(name));
    }

    @GetMapping("/search/by-model")
    public ResponseEntity<SearchResponseDTO<VehiclePropertiesDTO>> searchVehiclesByModel(
            @RequestParam String model) {
        return ResponseEntity.ok(vehicleService.searchVehiclesByModel(model));
    }
}
