package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ProfileResponse {
    private String body;
    private int statusCode;
    private HashMap<String, String> headers;
    private final boolean isBase64Encoded = false;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public ProfileResponse() {
    }

    public ProfileResponse(Object record, HashMap<String, String> headers, int statusCode) {
        Gson gson = new Gson();
        String json = gson.toJson(record);
        this.body = json;
        this.statusCode = statusCode;
        this.headers = headers;
    }
}