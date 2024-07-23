package com.example.starwarsapp.controller;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import com.example.starwarsapp.service.StarshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/starships")
public class StarshipController {

    private final StarshipService starshipService;

    @GetMapping
    public ResponseEntity<PaginatedListResponseDTO> getAllStarships(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(starshipService.getAllStarships(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdResponseDTO> getStarshipById(@PathVariable String id) {
        return ResponseEntity.ok(starshipService.getStarshipById(id));
    }

    @GetMapping("/search/by-name")
    public ResponseEntity<SearchResponseDTO> searchStarshipsByName(@RequestParam String name) {
        return ResponseEntity.ok(starshipService.searchStarshipsByName(name));
    }

    @GetMapping("/search/by-model")
    public ResponseEntity<SearchResponseDTO> searchStarshipsByModel(@RequestParam String model) {
        return ResponseEntity.ok(starshipService.searchStarshipsByModel(model));
    }
}
