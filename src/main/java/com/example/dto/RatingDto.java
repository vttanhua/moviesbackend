package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingDto {
    @JsonAlias(value="Source")
    private String source;
    @JsonAlias(value="Value")
    private String value;

}
