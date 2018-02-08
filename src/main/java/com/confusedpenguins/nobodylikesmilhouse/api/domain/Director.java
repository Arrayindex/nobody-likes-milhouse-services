package com.confusedpenguins.nobodylikesmilhouse.api.domain;

import com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase.UseCaseFactory;

public interface Director {

    public void construct();

    public UseCaseFactory getUseCaseFactory();

}
