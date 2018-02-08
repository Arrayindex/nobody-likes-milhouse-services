package com.confusedpenguins.nobodylikesmilhouse.api.domain;

import com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase.UseCaseFactory;
import okhttp3.OkHttpClient;

public class ProductionDirector implements Director {
    private UseCaseFactory factory;
    private final String authEndpoint = "https://graph.facebook.com";

    @Override
    public void construct() {
        OkHttpClient httpClient = new OkHttpClient();
        factory = new UseCaseFactory(httpClient, authEndpoint);
    }

    @Override
    public UseCaseFactory getUseCaseFactory() {
        return factory;
    }
}
