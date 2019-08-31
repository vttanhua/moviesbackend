package com.example.util;

import com.example.service.MoviesReviewService;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.Duration;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureCache
public class MovieDurationDeserializeTest {

    @MockBean
    JsonParser jsonParser;

    MovieDurationDeserialize movieDurationDeserialize;

    @Before
    public void init(){
        this.movieDurationDeserialize = new MovieDurationDeserialize();
    }

    @Test
    public void testDurationParsingOKCase() throws IOException {
        when(jsonParser.getText()).thenReturn("169 min");
        Duration d = movieDurationDeserialize.deserialize(jsonParser,null);
        assertThat(d, equalTo(Duration.ofMinutes(169)));
    }

    @Test
    public void testDurationParsingNULLCase_1() throws IOException {
        when(jsonParser.getText()).thenReturn(null);
        Duration d = movieDurationDeserialize.deserialize(jsonParser,null);
        assertThat(d, nullValue(Duration.class));
    }

    @Test
    public void testDurationParsingNullCase_2() throws IOException {
        when(jsonParser.getText()).thenReturn("");
        Duration d = movieDurationDeserialize.deserialize(jsonParser,null);
        assertThat(d, nullValue(Duration.class));
    }

    @Test
    public void testDurationParsingNullCase_3() throws IOException {
        when(jsonParser.getText()).thenReturn("169min");
        Duration d = movieDurationDeserialize.deserialize(jsonParser,null);
        assertThat(d, nullValue(Duration.class));

    }

    @Test
    public void testDurationParsingNullCase_4(){
        Duration d = null;
        try {
            when(jsonParser.getText()).thenReturn("169 hour");
            d = movieDurationDeserialize.deserialize(jsonParser,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(d, nullValue(Duration.class));
    }

}
