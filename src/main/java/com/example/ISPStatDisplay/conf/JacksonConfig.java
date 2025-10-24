package com.example.ISPStatDisplay.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.createXmlMapper(false).build();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty-print for debugging
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Avoid Hibernate proxy issues
        mapper.setDateFormat(StdDateFormat.instance); // Optional: for date formatting
        return mapper;
    }
}