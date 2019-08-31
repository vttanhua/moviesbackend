package com.example.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
    @JsonAlias(value="Title")
    private String title;
    @JsonAlias(value="Year")
    private int year;
    private String imdbID;
    @JsonAlias(value="Type")
    private String type;
    @JsonAlias(value="Poster")
    private String poster;

}

//sinngle item is:
//,{"Search":[{"Title":"Interstellar","Year":"2014","imdbID":"tt0816692",
// "Type":"movie",
// "Poster":"https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"},
