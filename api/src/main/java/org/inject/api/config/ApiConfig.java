package org.inject.api.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"classpath:config/config.properties"})
public interface ApiConfig extends Config {

    @Key("base_url")
    String getBaseUrl();

    @Key("expected_response_time")
    long getExpectedResponseTime();

    static ApiConfig config() {
        return ConfigFactory.create(ApiConfig.class);
    }
}
