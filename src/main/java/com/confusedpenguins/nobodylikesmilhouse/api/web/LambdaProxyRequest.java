package com.confusedpenguins.nobodylikesmilhouse.api.web;

import com.google.gson.Gson;

import java.util.Map;

public class LambdaProxyRequest<E> {
    private final String facebookTokenHeader = "x-facebook-token";
    private Map<String, String> headers;
    private String body;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public E getSerializedBody(Class<E> clazz) {
        return new Gson().fromJson(this.body, clazz);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFacebookToken() {
        if (this.headers == null) {
            return null;
        }

        return this.headers.getOrDefault(facebookTokenHeader, null);
    }
}
