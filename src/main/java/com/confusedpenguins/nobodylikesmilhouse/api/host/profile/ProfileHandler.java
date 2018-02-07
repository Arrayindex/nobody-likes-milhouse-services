package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatusAnswer;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyResponse;

import java.util.HashMap;

public class ProfileHandler implements RequestHandler<ProfileRequest, LambdaProxyResponse> {
    @Override
    public LambdaProxyResponse handleRequest(ProfileRequest input, Context context) {
        LambdaProxyResponse lambdaProxyResponse = new LambdaProxyResponse(HttpStatus.SUCCESS, new ProfileResponse("Hello World"));
        return lambdaProxyResponse;
    }
}
