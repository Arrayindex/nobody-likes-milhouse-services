package com.confusedpenguins.nobodylikesmilhouse.api.web;

import java.util.HashMap;
import java.util.Map;

public abstract class LambdaProxyResponse {

    // Required by API Gateway
    private boolean isBase64Encoded = false;
    private int statusCode;
    private Map<String, String> headers;
    protected String body;

    /**
     * @param statusCode
     *            The status code to be returned.
     * @param headers
     *            Any extra headers to return. May be null if there are no extra
     *            headers to return.
     * @param body
     *            The body of the response.
     */
    public LambdaProxyResponse(int statusCode, Map<String, String> headers, String body) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers == null ? new HashMap<>() : headers;
    }

    public LambdaProxyResponse(HttpStatus answer) {
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