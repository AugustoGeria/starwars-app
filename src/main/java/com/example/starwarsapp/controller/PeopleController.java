package com.example.starwarsapp.controller;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.PaginatedListResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import com.example.starwarsapp.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    public ResponseEntity<PaginatedListResponseDTO> getAllPeople(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(peopleService.getAllPeople(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdResponseDTO> getPersonById(@PathVariable String id) {
        return ResponseEntity.ok(peopleService.getPersonById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResponseDTO> searchPeopleByName(@RequestParam String name) {
        return ResponseEntity.ok(peopleService.searchPeopleByName(name));
    }
}
