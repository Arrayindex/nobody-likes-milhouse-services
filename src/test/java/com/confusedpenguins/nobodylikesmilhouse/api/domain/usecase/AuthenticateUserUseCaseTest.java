package com.confusedpenguins.nobodylikesmilhouse.api.domain.usecase;

import com.confusedpenguins.nobodylikesmilhouse.api.domain.ProductionDirector;
import com.confusedpenguins.nobodylikesmilhouse.api.domain.user.Identity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.SysexMessage;

import static org.junit.Assert.*;

public class AuthenticateUserUseCaseTest {
    ProductionDirector director;
    UseCaseFactory factory;

    @Before
    public void setUp() throws Exception {
        director = new ProductionDirector();
        director.construct();
        factory = director.getUseCaseFactory();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() {
        Identity identity = factory.newAuthenticateUserUseCase("EAAXODKbJKAoBAFTi6DEyOyqQUXQHZB25XQp1aZCwvejImHzjIl8eZBRO1Bt8CXb01tkNYu7z5K7FTBjItnl9ztLjULjNh1bKNvI7cz71FX2sqZC2f4I7MWNgts8bdPN4DaKozaOwMMAobD6j8E6MGwZBncRlUIAOZBkwNu1ZBqhSygS7HwiIAHZCxqh92flzIHIZD").execute();

        System.out.println(identity);
        assertNotNull("Should Return Identity", identity);
    }
}