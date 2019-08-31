package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * OK Response:
 * {"status":"OK","copyright":"Copyright (c) 2019 The New York Times Company. All Rights Reserved.","has_more":false,"num_results":1,
 * "results":[{"display_title":"Interstellar","mpaa_rating":"PG-13","critics_pick":1,"byline":"A. O. SCOTT","headline":"Off to the Stars, With Grief, Dread and Regret",
 * "summary_short":"In Christopher Nolan\u2019s science-fiction parable \u201cInterstellar,\u201d Earth is dying, and a team of astronauts searches the universe for a new home for the human race.",
 * "publication_date":"2014-11-04","opening_date":"2014-11-07","date_updated":"2017-11-02 04:18:20",
 * "link":{"type":"article","url":"http:\/\/www.nytimes.com\/2014\/11\/05\/movies\/interstellar-christopher-nolans-search-for-a-new-planet.html",
 * "suggested_link_text":"Read the New York Times Review of Interstellar"},
 * "multimedia":{"type":"mediumThreeByTwo210","src":"https:\/\/static01.nyt.com\/images\/2014\/11\/05\/arts\/interstellar-1\/interstellar-1-mediumThreeByTwo210-v2.jpg","width":210,"height":140}}]}
 *
 * no reviews case is just empty results list.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieReviewResponseDto {
    @JsonAlias(value="status")
    private String status;
    private String copyright;
    @JsonAlias(value="has_more")
    private Boolean hasMore;
    @JsonAlias(value="num_results")
    private Integer resultsCount;
    @JsonAlias(value="results")
    private List<ReviewDto> reviews;
}
