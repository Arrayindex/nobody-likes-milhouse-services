package com.confusedpenguins.nobodylikesmilhouse.api.host.profile;

import com.confusedpenguins.nobodylikesmilhouse.api.domain.user.Identity;

public class ProfileResponse {
    private Identity identity;

    public ProfileResponse(Identity identity) {
        this.identity = identity;
    }
}
