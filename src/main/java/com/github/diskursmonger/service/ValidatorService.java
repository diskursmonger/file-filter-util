package com.github.diskursmonger.service;

import com.github.diskursmonger.domain.AppConfig;
import com.github.diskursmonger.domain.validation.Validator;

import java.util.List;

public class ValidatorService {
    private final List<Validator> validators;

    public ValidatorService(List<Validator> v) {
        this.validators = List.copyOf(v);
    }

    public void validate(AppConfig appConfig) {
        for (var v : validators) {
            v.validate(appConfig);
        }
    }
}
