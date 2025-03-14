package com.liviasilvasantos.aws.lambda.service;

import com.liviasilvasantos.aws.lambda.request.LoginRequest;
import com.liviasilvasantos.aws.lambda.response.LoginResponse;

public class LoginService {
    public LoginResponse execute(final LoginRequest loginRequest){
        boolean isAuthorized = loginRequest.username().equals("admin")
                && loginRequest.password().equals("123");

        return new LoginResponse(isAuthorized);
    }
}
