package com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase;

import okhttp3.OkHttpClient;

public class UseCaseFactory {
    private OkHttpClient httpClient;
    private final String authEndpoint;

    public UseCaseFactory(OkHttpClient httpClient, String authEndpoint) {
        this.httpClient = httpClient;
        this.authEndpoint = authEndpoint;
    }

    public AuthenticateUserUseCase newAuthenticateUserUseCase(String facebookToken) {
        return new AuthenticateUserUseCase(authEndpoint, facebookToken, httpClient);
    }
}
