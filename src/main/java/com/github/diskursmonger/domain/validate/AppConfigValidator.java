package com.github.diskursmonger.domain.validate;

import com.github.diskursmonger.domain.AppConfig;

public final class AppConfigValidator {
    private AppConfigValidator() {}
    public static void validate(AppConfig config) {
        PrefixValidator.validate(config.prefix);
    }

}
