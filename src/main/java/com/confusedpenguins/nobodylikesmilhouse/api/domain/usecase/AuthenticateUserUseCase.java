package com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase;

import com.confusedpenguins.nobodylikesmilhouse.api.domain.user.Identity;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class AuthenticateUserUseCase implements UseCase<Identity> {
    private final Logger logger = LogManager.getLogger(AuthenticateUserUseCase.class);
    private String authEndpoint;
    private String facebookToken;
    private OkHttpClient okHttpClient;
    private Gson gson;

    public AuthenticateUserUseCase(String authEndpoint, String facebookToken, OkHttpClient okHttpClient) {
        this.authEndpoint = authEndpoint;
        this.facebookToken = facebookToken;
        this.okHttpClient = okHttpClient;
        this.gson = new Gson();
    }

    @Override
    public Identity execute() {
        try {
            logger.info("Authenticating User");
            if (this.facebookToken == null) {
                return null;
            }

            Request request = getBaseBuilder().get().url(getAuthenticatedPath("/v2.12/me", this.facebookToken)).build();
            logger.info("Request URL " + request.url());
            Response response = this.okHttpClient.newCall(request).execute();
            logger.info("Response: " + response.toString());

            if (!response.isSuccessful()) {
                return null;
            }

            logger.info("Got User " + response.toString());
            return gson.fromJson(new String(response.body().bytes()), Identity.class);
        } catch (IOException exception) {
            logger.error(exception);
            exception.printStackTrace();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        return null;
    }

    private Request.Builder getBaseBuilder() {
        return new Request.Builder().addHeader("Content-Type", "application/json");
    }

    private String getAuthenticatedPath(String path, String token) {
        return authEndpoint + path + "?access_token=" + token;
    }
}
