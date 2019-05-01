package com.example.movies;

import com.example.service.MoviesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
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
    public void testSearchFound() {
        String searchKeyword = "interstellar";
        moviesService.searchMovies(searchKeyword);
    }

    @Test
    public void getMovieInfoFound() {
        String imdbID = "tt0816692";
        moviesService.getMovieInfo(imdbID);
    }

    @Test
    public void getMovieInfoNotFound() {
        String imdbID = "tt0816692xyz";
        moviesService.getMovieInfo(imdbID);
    }

}
