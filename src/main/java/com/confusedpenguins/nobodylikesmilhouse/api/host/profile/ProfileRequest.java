package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

public class ProfileRequest {
    private String facebookToken;

    public ProfileRequest() {
    }

    public ProfileRequest(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public String getFacebookToken() {
        return facebookToken;
    }
}
