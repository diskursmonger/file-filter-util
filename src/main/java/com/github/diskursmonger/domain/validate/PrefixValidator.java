package com.github.diskursmonger.domain.validate;

import com.github.diskursmonger.domain.exception.ValidationException;


public class PrefixValidator {


    public static void validate(String prefix) {
        if (FileNameRules.illegalCharsPattern().matcher(prefix).find()) {
            throw new ValidationException("Prefix contains illegal characters for this OS.");
        }
    }
}
