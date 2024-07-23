package com.example.starwarsapp.DTO.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PaginatedListResponseDTO {

    private String message;
    @JsonProperty("total_records")
    private int totalRecords;
    @JsonProperty("total_pages")
    private int totalPages;
    private String previous;
    private String next;
    private List<SummaryDTO> results;
}
