package com.cydeo.fakeuserapp.service.impl;

import com.cydeo.fakeuserapp.service.FakeUserService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakeUserServiceImpl implements FakeUserService {

    private final Faker faker;

    public FakeUserServiceImpl(Faker faker) {
        this.faker = faker;
    }

    @Override
    public String getRandomName() {
        return faker.name().fullName();
    }


}
