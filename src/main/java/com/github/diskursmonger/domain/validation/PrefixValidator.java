package com.github.diskursmonger.domain.validation;

import com.github.diskursmonger.domain.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;


public class PrefixValidator implements Validator {

    @Override
    public void validate(AppConfig appConfig) {
        if (FileNameRules.illegalCharsPattern().matcher(appConfig.prefix()).find()) {
            throw new ValidationException("Prefix contains illegal characters for this OS.");
        }
    }
}
