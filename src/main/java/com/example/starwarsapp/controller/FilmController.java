package com.example.starwarsapp.controller;

import com.example.starwarsapp.DTO.ResponseDTO.IdResponseDTO;
import com.example.starwarsapp.DTO.ResponseDTO.SearchResponseDTO;
import com.example.starwarsapp.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<SearchResponseDTO> getAllFilms(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(filmService.getAllFilms(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdResponseDTO> getFilmById(@PathVariable String id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResponseDTO> searchFilmsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(filmService.searchFilmsByTitle(title));
    }
}
