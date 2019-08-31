package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewDto {

    @JsonAlias(value="display_title")
    private String title;
    private String headline;
    @JsonAlias(value="summary_short")
    private String shortSummary;
    //TODO additional fields here.
}
