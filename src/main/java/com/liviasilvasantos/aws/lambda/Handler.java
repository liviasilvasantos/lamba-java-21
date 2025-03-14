package com.liviasilvasantos.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liviasilvasantos.aws.lambda.request.LoginRequest;
import com.liviasilvasantos.aws.lambda.response.LoginResponse;
import com.liviasilvasantos.aws.lambda.service.LoginService;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static LoginService loginService;
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        loginService = new LoginService();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        var logger = context.getLogger();
        logger.log(("Request received - " + request.getBody()));

        try {
            var loginRequest = objectMapper.readValue(request.getBody(), LoginRequest.class);
            var loginResponse = loginService.execute(loginRequest);

            return new APIGatewayProxyResponseEvent()
                        .withStatusCode(200)
                        .withBody(objectMapper.writeValueAsString(loginResponse))
                        .withIsBase64Encoded(false);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
