package com.confusedpenguins.nobodylikesmilhouse.api.web;

import java.util.Map;

public abstract class LambdaProxyRequest {
    private final String facebookTokenHeader = "x-facebook-token";
    private Map<String, String> headers;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getFacebookToken() {
        if (this.headers == null) {
            return null;
        }

        return this.headers.getOrDefault(facebookTokenHeader, null);
    }
}
