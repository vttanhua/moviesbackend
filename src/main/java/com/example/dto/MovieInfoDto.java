package com.example.dto;


import com.example.util.MovieDurationDeserialize;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieInfoDto {
    private String movieInfoForImdbId;

    @JsonAlias(value="Title")
    private String title;
    @JsonAlias(value="Year")
    private Integer year;
    @JsonAlias(value="Rated")
    private String rated;
    @JsonAlias(value="Released")
    @JsonFormat(pattern = "dd MMM yyyy")
    private Date released;
    @JsonAlias(value="Runtime")
    @JsonDeserialize(using = MovieDurationDeserialize.class)
    private Duration runtime;
    @JsonAlias(value="Genre")
    private String genre;
    @JsonAlias(value="Director")
    private String director;
    @JsonAlias(value="Writer")
    private String writer;
    @JsonAlias(value="Actors")
    private String actors;
    @JsonAlias(value="Plot")
    private String plot;
    @JsonAlias(value="Language")
    private String language;
    @JsonAlias(value="Country")
    private String country;
    @JsonAlias(value="Awards")
    private String awards;
    @JsonAlias(value="Poster")
    private String poster;
    @JsonAlias(value="Ratings")
    private List<RatingDto> ratings;
    @JsonAlias(value="Metascore")
    private Integer metascore;
    @JsonAlias(value="imdbRating")
    private Double imdbRating;
    @JsonAlias(value="imdbVotes")
    private String imdbVotes;//TODO create converter
    @JsonAlias(value="imdbId")
    private String imdbId;
    @JsonAlias(value="Type")
    private String type;
    @JsonAlias(value="DWD")
    private String DWD;
    @JsonAlias(value="BoxOffice")
    private String boxOffice;//TODO create currency object
    @JsonAlias(value="Production")
    private String production;
    @JsonAlias(value="Website")
    private String website;
    @JsonAlias(value="Response")
    private Boolean response;
    @JsonAlias(value="Error")
    private String error;

}
