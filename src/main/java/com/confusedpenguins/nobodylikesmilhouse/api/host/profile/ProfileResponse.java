package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatus;
import com.confusedpenguins.nobodylikesmilhouse.api.web.HttpStatusAnswer;

public class ProfileResponse extends HttpStatusAnswer {
    private final String val;

    public ProfileResponse(HttpStatus status) {
        super(status);
        val = null;
    }

    public ProfileResponse(HttpStatus status, String val) {
        super(status);
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
