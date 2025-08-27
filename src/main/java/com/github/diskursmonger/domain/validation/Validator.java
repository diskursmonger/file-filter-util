package com.github.diskursmonger.domain.validation;

import com.github.diskursmonger.domain.config.AppConfig;

public interface Validator {
    void validate(AppConfig appConfig);
}
