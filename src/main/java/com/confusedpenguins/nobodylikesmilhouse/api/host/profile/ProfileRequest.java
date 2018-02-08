package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.confusedpenguins.nobodylikesmilhouse.api.web.LambdaProxyRequest;

public class ProfileRequest extends LambdaProxyRequest {
    private String firstName;
    private String email;
    private String quote;

    public ProfileRequest() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getQuote() {
        return quote;
    }

    @Override
    public String toString() {
        return "ProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}