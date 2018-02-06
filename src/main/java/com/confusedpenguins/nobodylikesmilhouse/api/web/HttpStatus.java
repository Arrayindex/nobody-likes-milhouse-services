package com.confusedpenguins.nobodylikesmilhouse.api.web;

public enum HttpStatus {
    SUCCESS(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    UNSUPPORTED_MEDIA(415),
    UNAVAILABLE_LEGAL_REASONS(451),
    SERVER_ERROR(500),
    NOT_IMPLEMENTED(501);

    private int numVal;

    HttpStatus(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}

