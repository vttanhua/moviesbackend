package com.example.movies;

import com.example.dto.MovieInfoDto;
import com.example.dto.MovieSearchResponseDto;
import com.example.service.MoviesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MoviesTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    MoviesService moviesService;

    @Test
    public void testSearchNotFound() {
        String searchKeyword = "test movie name";
        moviesService.searchMovies(searchKeyword);

    }

    @Test
    public void testSearchNotFoundMapper() {
        //String testvalue = "{\"Response\":\"False\",\"Error\":\"Movie not found!\"}";
        String searchKeyword = "test movie name";
        MovieSearchResponseDto searchMoviesDto = moviesService.searchMoviesDto(searchKeyword);
        log.info("Search  results: "+searchMoviesDto);
    }


    @Test
    public void testSearchNotFoundMapperToJSON() throws JsonProcessingException {
        //String testvalue = "{\"Response\":\"False\",\"Error\":\"Movie not found!\"}";
        String searchKeyword = "test movie name";
        MovieSearchResponseDto searchMoviesDto = moviesService.searchMoviesDto(searchKeyword);
        log.info("Search  results: "+searchMoviesDto);
        String result = new ObjectMapper().writeValueAsString(searchMoviesDto);
        log.info("Search as string {}", result);
    }

    @Test
    public void testSearchFound() {
        String searchKeyword = "interstellar";
        moviesService.searchMovies(searchKeyword);
    }

    @Test
    public void testSearchFoundMapper() {
        String testValue = "{\"Search\":[\n" +
                "  {\"Title\":\"Interstellar\",\"Year\":\"2014\",\"imdbID\":\"tt0816692\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"The Science of Interstellar\",\"Year\":\"2015\",\"imdbID\":\"tt4415360\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMDFhNzU4MTMtYzZmNS00ZDEzLTg2MjQtYmUzZDA1ZWU4OTkzXkEyXkFqcGdeQXVyNDQ2MTMzODA@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"Interstellar Wars\",\"Year\":\"2016\",\"imdbID\":\"tt5083736\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMzE5MmExYzMtYjQxYi00ZDlkLTkzMTYtMWQzNTZkMjBiYWI2L2ltYWdlXkEyXkFqcGdeQXVyNTM3MDMyMDQ@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"Lolita from Interstellar Space\",\"Year\":\"2014\",\"imdbID\":\"tt3506492\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDI1MmJmYWUtOTExZS00MGY3LWJhMzMtNThkYWJhZWQ1YmIyXkEyXkFqcGdeQXVyNjQ2MjQ5NzM@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"Interstellar: Nolan's Odyssey\",\"Year\":\"2014\",\"imdbID\":\"tt4172224\",\"Type\":\"movie\",\"Poster\":\"N/A\"},\n" +
                "  {\"Title\":\"Interstellar Civil War: Shadows of the Empire\",\"Year\":\"2017\",\"imdbID\":\"tt5056352\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMDJmYjQ4YmEtOTkzMS00MzQ3LWExNmUtMzgzZWQxMWJkZjk2XkEyXkFqcGdeQXVyMzM1MjQzNTk@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"Interstellar\",\"Year\":\"2005\",\"imdbID\":\"tt0758429\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTgyNzUyMTQ3OV5BMl5BanBnXkFtZTgwNDg0OTE2MzE@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"Inside 'Interstellar'\",\"Year\":\"2015\",\"imdbID\":\"tt5297406\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYzNhZjBmNmItZGQ0NS00Mzk4LWJhYTgtZDhkNWJmZTJmZDFmL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjE0OTE2MDY@._V1_SX300.jpg\"},\n" +
                "  {\"Title\":\"Cosmic Journey: The Voyager Interstellar Mission and Message\",\"Year\":\"2003\",\"imdbID\":\"tt0802967\",\"Type\":\"movie\",\"Poster\":\"N/A\"},\n" +
                " {\"Title\":\"Interstellar Stella\",\"Year\":\"2006\",\"imdbID\":\"tt0925090\",\"Type\":\"movie\",\"Poster\":\"N/A\"}],\"totalResults\":\"19\",\"Response\":\"True\"}";

        String searchKeyword = "interstellar";
        MovieSearchResponseDto searchMoviesDto = moviesService.searchMoviesDto(searchKeyword);
        log.info("Search  results: "+searchMoviesDto);
    }

    @Test
    public void testSearchFoundMapperToJSON() throws JsonProcessingException {
        String searchKeyword = "interstellar";
        MovieSearchResponseDto searchMoviesDto = moviesService.searchMoviesDto(searchKeyword);
        log.info("Search  results: "+searchMoviesDto);
        String result = new ObjectMapper().writeValueAsString(searchMoviesDto);
        log.info("Search as string {}", result);
}

    @Test
    public void getMovieInfoFound() {
        String imdbID = "tt0816692";
        moviesService.getMovieInfo(imdbID);
    }

    @Test
    public void getMovieInfoFoundMapper() {
        String testData = " {\"Title\":\"Interstellar\",\"Year\":\"2014\",\"Rated\":\"PG-13\",\n" +
                " \"Released\":\"07 Nov 2014\",\"Runtime\":\"169 min\",\"Genre\":\"Adventure, Drama, Sci-Fi\",\n" +
                " \"Director\":\"Christopher Nolan\",\"Writer\":\"Jonathan Nolan, Christopher Nolan\",\n" +
                " \"Actors\":\"Ellen Burstyn, Matthew McConaughey, Mackenzie Foy, John Lithgow\",\n" +
                " \"Plot\":\"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.\",\n" +
                " \"Language\":\"English\",\"Country\":\"USA, UK, Canada\",\"Awards\":\"Won 1 Oscar. Another 43 wins & 143 nominations.\",\n" +
                " \"Poster\":\"https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg\",\n" +
                " \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"72%\"},{\"Source\":\"Metacritic\",\"Value\":\"74/100\"}],\n" +
                " \"Metascore\":\"74\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"1,304,706\",\"imdbID\":\"tt0816692\",\"Type\":\"movie\",\"DVD\":\"31 Mar 2015\",\"BoxOffice\":\"$158,737,441\",\n" +
                " \"Production\":\"Paramount Pictures\",\"Website\":\"http://www.InterstellarMovie.com/\",\"Response\":\"True\"}";
        String imdbID = "tt0816692";
        MovieInfoDto responseData = moviesService.getMovieInfoDto(imdbID);
        log.info("Get movie info with results: {}", responseData);
    }

    @Test
    public void getMovieInfoFoundMapperToJSON() throws JsonProcessingException {
        String imdbID = "";
        MovieInfoDto responseData = moviesService.getMovieInfoDto(imdbID);
        log.info("Get movie info with results: {}", responseData);
        String result = new ObjectMapper().writeValueAsString(responseData);
        log.info("Search as string {}", result);
    }

    @Test
    public void getMovieInfoNotFound() {
        String imdbID = "tt0816692xyz";
        moviesService.getMovieInfo(imdbID);
    }

    @Test
    public void getMovieInfoNotFoundMapper() {
        String testData = "{\"Response\":\"False\",\"Error\":\"Incorrect IMDb ID.\"}";
        String imdbID = "tt0816692xyz";
        MovieInfoDto responseData = moviesService.getMovieInfoDto(imdbID);
        log.info("Get movie info with results: {}", responseData);
        assertThat(responseData.getError(), equalTo("Incorrect IMDb ID."));
        assertThat(responseData.getResponse(), equalTo(false));
    }

    @Test
    public void getMovieInfoNotFoundMapperToJSON() throws JsonProcessingException {
        String testData = "{\"Response\":\"False\",\"Error\":\"Incorrect IMDb ID.\"}";
        String imdbID = "tt0816692xyz";
        MovieInfoDto responseData = moviesService.getMovieInfoDto(imdbID);
        log.info("Get movie info with results: {}", responseData);
        assertThat(responseData.getError(), equalTo("Incorrect IMDb ID."));
        assertThat(responseData.getResponse(), equalTo(false));
        String result = new ObjectMapper().writeValueAsString(responseData);
        log.info("Search as string {}", result);
    }


}
