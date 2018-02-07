package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyResponse;

import java.util.HashMap;

public class ProfileHandler implements RequestHandler<ProfileRequest, ProfileResponse> {
    @Override
    public ProfileResponse handleRequest(ProfileRequest input, Context context) {
        ProfileResponse lambdaProxyResponse = new ProfileResponse(HttpStatus.SUCCESS, "Hello World");
        return lambdaProxyResponse;
    }
}
