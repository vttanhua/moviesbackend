package com.example.controller;

import com.example.service.MoviesReviewService;
import com.example.service.MoviesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

    private MoviesService moviesService;
    private MoviesReviewService moviesReviewService;

    public MoviesController(MoviesService moviesService, MoviesReviewService moviesReviewService) {
        this.moviesService = moviesService;
        this.moviesReviewService = moviesReviewService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<String> searchMovies(@RequestParam("searchTerm") String searchTerm) {
        return moviesService.searchMovies(searchTerm);
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ResponseEntity<String> getMovie(@RequestParam("imdbID") String imdbID) {
        return moviesService.getMovieInfo(imdbID);
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public ResponseEntity<String> getReviews(@RequestParam("searchTerm") String searchKeyword) {
        return moviesReviewService.getReviews(searchKeyword);
    }

}
