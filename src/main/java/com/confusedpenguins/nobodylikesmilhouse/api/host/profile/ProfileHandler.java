package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.ProductionDirector;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase.UseCaseFactory;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.user.Identity;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatusAnswer;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyResponse;
import com.confusedpenguins.nobodylikesmilhouse.api.web.answers.UnauthorizedAnswer;

import java.util.HashMap;

public class ProfileHandler implements RequestHandler<ProfileRequest, LambdaProxyResponse> {
    UseCaseFactory factory;

    public ProfileHandler() {
        ProductionDirector director = new ProductionDirector();
        factory = director.getUseCaseFactory();
    }

    @Override
    public LambdaProxyResponse handleRequest(ProfileRequest input, Context context) {

        Identity identity = this.factory.newAuthenticateUserUseCase(input.getFacebookToken()).execute();

        if(identity == null) {
            return new UnauthorizedAnswer();
        }

        LambdaProxyResponse lambdaProxyResponse = new LambdaProxyResponse(HttpStatus.SUCCESS, new ProfileResponse(identity));
        return lambdaProxyResponse;
    }
}
