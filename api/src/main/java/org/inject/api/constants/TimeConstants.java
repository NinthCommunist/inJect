package org.inject.api.constants;

import org.inject.api.config.ApiConfig;

public class TimeConstants {

    public static final long EXPECTED_RESPONSE_TIME = ApiConfig.config().getExpectedResponseTime();
}
