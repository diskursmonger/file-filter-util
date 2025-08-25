package com.github.diskursmonger.domain.validation;

import java.util.List;

public class ValidatorFactory {
    public List<Validator> create() {
        return List.of(
                new InputFilesValidator(),
                new OutputPathValidator(),
                new PrefixValidator()
        );
    }
}
