package com.github.diskursmonger.domain.validation;

import com.github.diskursmonger.domain.AppConfig;

public interface Validator {
    void validate(AppConfig appConfig);
}
