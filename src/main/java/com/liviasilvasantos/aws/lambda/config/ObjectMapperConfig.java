package com.liviasilvasantos.aws.lambda.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperConfig {

    public static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }
}
