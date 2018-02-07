package com.confusedpenguins.nobodylikesmilhouse.api.web;

import java.util.Map;

public abstract class LambdaProxyRequest {
    private Map<String, String> headers;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
