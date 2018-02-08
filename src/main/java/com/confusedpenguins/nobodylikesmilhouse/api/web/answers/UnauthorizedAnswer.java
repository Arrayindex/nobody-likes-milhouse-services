package com.confusedpenguins.nobodylikesmilhouse.api.web.answers;

import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyResponse;

import java.util.Map;

public class UnauthorizedAnswer extends LambdaProxyResponse {

    public UnauthorizedAnswer() {
        super(HttpStatus.UNAUTHORIZED, "There be dragons there");
    }
}
