package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Class for handling movie search responses from omdbapi.com
 *
 * OK case: {"Search":[
 * {"Title":"Interstellar","Year":"2014","imdbID":"tt0816692","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"},
 * {"Title":"The Science of Interstellar","Year":"2015","imdbID":"tt4415360","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMDFhNzU4MTMtYzZmNS00ZDEzLTg2MjQtYmUzZDA1ZWU4OTkzXkEyXkFqcGdeQXVyNDQ2MTMzODA@._V1_SX300.jpg"},
 * {"Title":"Interstellar Wars","Year":"2016","imdbID":"tt5083736","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMzE5MmExYzMtYjQxYi00ZDlkLTkzMTYtMWQzNTZkMjBiYWI2L2ltYWdlXkEyXkFqcGdeQXVyNTM3MDMyMDQ@._V1_SX300.jpg"},
 * {"Title":"Lolita from Interstellar Space","Year":"2014","imdbID":"tt3506492","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDI1MmJmYWUtOTExZS00MGY3LWJhMzMtNThkYWJhZWQ1YmIyXkEyXkFqcGdeQXVyNjQ2MjQ5NzM@._V1_SX300.jpg"},
 * {"Title":"Interstellar: Nolan's Odyssey","Year":"2014","imdbID":"tt4172224","Type":"movie","Poster":"N/A"},
 * {"Title":"Interstellar Civil War: Shadows of the Empire","Year":"2017","imdbID":"tt5056352","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMDJmYjQ4YmEtOTkzMS00MzQ3LWExNmUtMzgzZWQxMWJkZjk2XkEyXkFqcGdeQXVyMzM1MjQzNTk@._V1_SX300.jpg"},
 * {"Title":"Interstellar","Year":"2005","imdbID":"tt0758429","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTgyNzUyMTQ3OV5BMl5BanBnXkFtZTgwNDg0OTE2MzE@._V1_SX300.jpg"},
 * {"Title":"Inside 'Interstellar'","Year":"2015","imdbID":"tt5297406","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BYzNhZjBmNmItZGQ0NS00Mzk4LWJhYTgtZDhkNWJmZTJmZDFmL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjE0OTE2MDY@._V1_SX300.jpg"},
 * {"Title":"Cosmic Journey: The Voyager Interstellar Mission and Message","Year":"2003","imdbID":"tt0802967","Type":"movie","Poster":"N/A"},
 * {"Title":"Interstellar Stella","Year":"2006","imdbID":"tt0925090","Type":"movie","Poster":"N/A"}],"totalResults":"19","Response":"True"}
 *
 * Error case: {"Response":"False","Error":"Movie not found!"}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSearchResponseDto {
        @JsonAlias(value="Search")
        private List<MovieDto> search;
        @JsonAlias(value="Response")
        private Boolean response;
        @JsonAlias(value="Error")
        private String error;
        @JsonAlias(value="totalResults")
        private int totalResults;

        private String searchKeyword;
}
