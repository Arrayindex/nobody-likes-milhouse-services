package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyResponse;

public class ProfileResponse extends LambdaProxyResponse {
    public ProfileResponse(HttpStatus status, String json) {
        super(status);
        this.body = json;
    }
}
