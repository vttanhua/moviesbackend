package com.example.movies;

import com.example.dto.MovieReviewResponseDto;
import com.example.dto.MovieSearchResponseDto;
import com.example.service.MoviesReviewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
//@DirtiesContext
public class MoviesReviewTest {

    @Autowired
    MoviesReviewService moviesReviewService;

    @Test
    public void testReviewFound() {
        String searchKeyword = "interstellar";
        moviesReviewService.getReviews(searchKeyword);
    }

    @Test
    public void testReviewFoundMapper() {
        String searchKeyword = "interstellar";
        MovieReviewResponseDto responseData = moviesReviewService.getReviewsDto(searchKeyword);
        log.info("Review results: {}",responseData);
    }

    @Test
    public void testReviewFoundMapperCacheTest() {
        String searchKeyword = "interstellar";
        for(int i = 0; i < 10; i++) {
            MovieReviewResponseDto responseData = moviesReviewService.getReviewsDto(searchKeyword);
            log.info("Review results: {}", responseData);
            if(i%5==0)
                moviesReviewService.clearCache();
        }
    }


    @Test
    public void testSearchNotFound() {
        String searchKeyword = "interstellarrr";
        moviesReviewService.getReviews(searchKeyword);
    }

    @Test
    public void testReviewNotFoundMapper() {
        String searchKeyword = "interstellarrr";
        MovieReviewResponseDto responseData = moviesReviewService.getReviewsDto(searchKeyword);
        log.info("Review no results: {}",responseData);
    }

    @Test
    public void testReviewNotFoundMapperToJSON() throws JsonProcessingException {
        String searchKeyword = "interstellarrr";
        MovieReviewResponseDto responseData = moviesReviewService.getReviewsDto(searchKeyword);
        log.info("Review no results: {}",responseData);
        String result = new ObjectMapper().writeValueAsString(responseData);
        log.info("Search as string {}", result);
    }

    @Test
    public void testReviewFoundMapperToJSON() throws JsonProcessingException {
        String searchKeyword = "interstellar";
        MovieReviewResponseDto responseData = moviesReviewService.getReviewsDto(searchKeyword);
        log.info("Review results: {}",responseData);
        String result = new ObjectMapper().writeValueAsString(responseData);
        log.info("Search as string {}", result);
    }


}
