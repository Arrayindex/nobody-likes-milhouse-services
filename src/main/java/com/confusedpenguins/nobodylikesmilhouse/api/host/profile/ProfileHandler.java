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
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class ProfileHandler implements RequestHandler<ProfileRequest, LambdaProxyResponse> {
    private final Logger logger = LogManager.getLogger(ProfileHandler.class);
    UseCaseFactory factory;

    public ProfileHandler() {
        super();
        ProductionDirector director = new ProductionDirector();
        director.construct();
        factory = director.getUseCaseFactory();

        logger.info("Constructor Kicked");
    }

    @Override
    public LambdaProxyResponse handleRequest(ProfileRequest input, Context context) {
        logger.info("handleRequest Start");
        Identity identity = this.factory.newAuthenticateUserUseCase(input.getFacebookToken()).execute();

        if (identity == null) {
            logger.info("Identity Null");
            return new UnauthorizedAnswer();
        }

        logger.info("We Gotta Thing");
        LambdaProxyResponse lambdaProxyResponse = new LambdaProxyResponse(HttpStatus.SUCCESS, new ProfileResponse(identity));
        return lambdaProxyResponse;
    }
}
