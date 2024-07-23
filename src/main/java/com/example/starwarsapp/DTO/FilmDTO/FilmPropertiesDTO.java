package com.example.starwarsapp.DTO.FilmDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FilmPropertiesDTO {
    private List<String> characters;
    private String created;
    private String director;
    private String edited;
    @JsonProperty("episode_id")
    private int episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private List<String> planets;
    private String producer;
    @JsonProperty("release_date")

    private String releaseDate;
    private List<String> species;
    private List<String> starships;
    private String title;
    private String url;
    private List<String> vehicles;
}
