package com.example.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Duration;

public class MovieDurationDeserialize extends JsonDeserializer<Duration> {

    @Override
    public Duration deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String str = jsonParser.getText();
        return parseDuration(str);
    }

    protected Duration parseDuration(String duration) throws IOException {
        if (duration == null || duration.isEmpty())
            return null;
        else {
            String[] durationParts = duration.trim().split(" ");
            if (durationParts.length == 2) {
                switch (durationParts[1]) {
                    case "min":
                        return Duration.ofMinutes(Long.parseLong(durationParts[0]));
                    default: throw new IOException(String.format("Cannot deserialize %s as Duration", duration));
                }
            }
        }
        return null;
    }
}
