package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieReviewDto {
}

//{"status":"OK","copyright":"Copyright (c) 2019 The New York Times Company. All Rights Reserved.","has_more":false,"num_results":1,"results":[{"display_title":"Interstellar","mpaa_rating":"PG-13","critics_pick":1,"byline":"A. O. SCOTT","headline":"Off to the Stars, With Grief, Dread and Regret","summary_short":"In Christopher Nolan\u2019s science-fiction parable \u201cInterstellar,\u201d Earth is dying, and a team of astronauts searches the universe for a new home for the human race.","publication_date":"2014-11-04","opening_date":"2014-11-07","date_updated":"2017-11-02 04:18:20","link":{"type":"article","url":"http:\/\/www.nytimes.com\/2014\/11\/05\/movies\/interstellar-christopher-nolans-search-for-a-new-planet.html","suggested_link_text":"Read the New York Times Review of Interstellar"},"multimedia":{"type":"mediumThreeByTwo210","src":"https:\/\/static01.nyt.com\/images\/2014\/11\/05\/arts\/interstellar-1\/interstellar-1-mediumThreeByTwo210-v2.jpg","width":210,"height":140}}]},[Date:"Fri, 05 Jul 2019 11:41:18 GMT", Content-Type:"application/json; charset=UTF-8", Content-Length:"993", Connection:"keep-alive", Cache-Control:"max-age=600", Expires:"Fri, 05 Jul 2019 11:51:18 GMT", Server:"Apache/2.2.15 (CentOS)", Accept-Ranges:"bytes", Via:"1.1 varnish", Age:"0", X-Served-By:"cache-bwi5026-BWI", X-Cache:"MISS", X-Cache-Hits:"0", X-Timer:"S1562326878.300443,VS0,VE229", Vary:"Accept-Encoding", Access-Control-Allow-Origin:"*", Access-Control-Allow-Headers:"Accept, Content-Type, X-Forwarded-For, X-Prototype-Version, X-Requested-With", Access-Control-Expose-Headers:"Content-Length, X-JSON", Access-Control-Allow-Methods:"GET, OPTIONS"]>

