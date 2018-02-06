package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;

public class ProfileHandler implements RequestHandler<ProfileRequest, ProfileResponse> {
    @Override
    public ProfileResponse handleRequest(ProfileRequest input, Context context) {
        return new ProfileResponse("Hello World 123");
    }
}
