package com.confusedpenguins.nobodylikesmilhouse.api.web;


public abstract class HttpStatusAnswer {

    protected transient HttpStatus status;

    public HttpStatusAnswer(HttpStatus status) {
        this.status = status;
    }

    public int getStatusCode() {
        return status.getNumVal();
    }

    public HttpStatus getStatus() {
        return status;
    }

}