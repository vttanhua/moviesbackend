package com.example.movies;

import com.example.service.MoviesReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesReviewTest {

    @Autowired
    MoviesReviewService moviesReviewService;

    @Test
    public void testReviewFound() {
        String searchKeyword = "interstellar";
        moviesReviewService.getReviews(searchKeyword);
    }

    @Test
    public void testSearchNotFound() {
        String searchKeyword = "interstellarrr";
        moviesReviewService.getReviews(searchKeyword);
    }
}
