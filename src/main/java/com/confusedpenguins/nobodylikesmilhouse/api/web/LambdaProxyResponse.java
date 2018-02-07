package com.confusedpenguins.nobodylikesmilhouse.api.web;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class LambdaProxyResponse {

    // Required by API Gateway
    private boolean isBase64Encoded = false;
    private int statusCode;
    private Map<String, String> headers;
    protected String body;

    /**
     * @param statusCode The status code to be returned.
     * @param headers    Any extra headers to return. May be null if there are no extra
     *                   headers to return.
     * @param payload    The body of the response.
     */
    public LambdaProxyResponse(int statusCode, Map<String, String> headers, Object payload) {
        this.statusCode = statusCode;
        this.headers = headers == null ? new HashMap<>() : headers;

        Gson gson = new Gson();
        String json = gson.toJson(payload);
        this.body = json;
    }

    public LambdaProxyResponse(HttpStatus answer, Object payload) {
        this(answer.getNumVal(), null, null);
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

}