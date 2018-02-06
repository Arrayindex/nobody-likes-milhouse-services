package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ProfileResponse {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ProfileResponse() {
    }
}