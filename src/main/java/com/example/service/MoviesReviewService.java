package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;
import java.util.HashMap;

@Slf4j
@Service
public class MoviesReviewService {

    @Value("${movie.review.apiurl}")
    private String movieApiBaseUrl;

    @Value("${movie.review.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MoviesReviewService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getReviews(String searchKeyword) {
        log.info("Get movie reviews for keyword {}.", searchKeyword);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.movieApiBaseUrl);
        uriBuilder.queryParam("query", searchKeyword);
        uriBuilder.queryParam("api-key", this.apiKey);
        String url = uriBuilder.build(false).encode(Charset.forName("UTF-8")).toUriString();
        log.debug("Get movie reviews url {}.", url);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            log.debug("Status ok: " + response.toString());
        } else {
            log.error("Error while searching movie reviews with keyword {}. Status was {}", searchKeyword, response.getStatusCode());
        }
        return response;

    }


}
