package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.ProductionDirector;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase.UseCaseFactory;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.user.Identity;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyRequest;
import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyResponse;
import com.confusedpenguins.nobodylikesmilhouse.api.web.answers.UnauthorizedAnswer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UpdateProfileHandler implements RequestHandler<LambdaProxyRequest<ProfileRequest>, LambdaProxyResponse> {
    private final Logger logger = LogManager.getLogger(UpdateProfileHandler.class);
    UseCaseFactory factory;

    public UpdateProfileHandler() {
        super();
        ProductionDirector director = new ProductionDirector();
        director.construct();
        factory = director.getUseCaseFactory();
    }

    @Override
    public LambdaProxyResponse handleRequest(LambdaProxyRequest<ProfileRequest> input, Context context) {
        Identity identity = this.factory.newAuthenticateUserUseCase(input.getFacebookToken()).execute();

        if (identity == null) {
            return new UnauthorizedAnswer();
        }
        ProfileRequest request = input.getSerializedBody(ProfileRequest.class);
        logger.info("Got Request for " + request.getFirstName());

        return new LambdaProxyResponse(HttpStatus.SUCCESS, input.getSerializedBody(ProfileRequest.class));
    }
}
