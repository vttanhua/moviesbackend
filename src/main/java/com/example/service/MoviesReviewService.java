package com.example.service;

import com.example.dto.MovieReviewResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.cache.annotation.Cacheable;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

@Slf4j
@Service
@CacheConfig(cacheNames = "movieReviewCache")
public class MoviesReviewService {

    @Value("${movie.review.apiurl}")
    private String movieApiBaseUrl;

    @Value("${movie.review.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MoviesReviewService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(cacheNames = "movieReviewCache")
    public MovieReviewResponseDto getReviewsDto(String searchKeyword){
        ResponseEntity<String> response = this.getReviews(searchKeyword);
        ObjectMapper objectMapper = new ObjectMapper();
        MovieReviewResponseDto responseData = null;
        try {
            log.info("response getbody {}:",response.getBody());
            responseData = objectMapper.readValue(response.getBody(), MovieReviewResponseDto.class);
            responseData.getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseData;
    }

    public ResponseEntity<String> getReviews(String searchKeyword) {
        log.info("Get movie reviews for keyword {}.", searchKeyword);
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

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

    @CacheEvict(allEntries = true)
    public void clearCache(){}


}
