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
public class MoviesService {

    @Value("${movie.search.baseUrl}")
    private String movieApiBaseUrl;

    @Value("${movie.search.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MoviesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> searchMovies(String searchKeyword) {
        log.info("Search movies called with {}.", searchKeyword);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.movieApiBaseUrl);
        uriBuilder.queryParam("s", searchKeyword);
        uriBuilder.queryParam("type", "movie");
        uriBuilder.queryParam("apiKey", this.apiKey);
        String url = uriBuilder.build(false).encode(Charset.forName("UTF-8")).toUriString();
        log.debug("Search movies url {}.", url);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            log.debug("Status ok" + response.toString());
        } else {
            log.error("Error while searching movies with keyword {}. Status was {}", searchKeyword, response.getStatusCode());
        }
        return response;
    }

    public ResponseEntity<String> getMovieInfo(String imdbID) {
        log.info("Get movie info of imdbID {}.", imdbID);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.movieApiBaseUrl);
        uriBuilder.queryParam("i", imdbID);
        uriBuilder.queryParam("apiKey", this.apiKey);
        String url = uriBuilder.build(false).encode(Charset.forName("UTF-8")).toUriString();
        log.debug("Get movie info url {}.", url);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            log.debug("Status ok" + response.toString());
        } else {
            log.error("Error while getting movie info for imdbID {}. Status was {}", imdbID, response.getStatusCode());
        }
        return response;
    }

}
