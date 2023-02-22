package org.inject.web.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ConfigurationProperties(prefix = "web")
@PropertySource(value = "classpath:application.yml", factory = PropertySourceFactoryIml.class)
@Data
public class WebProperties {

    private String browserName;
    private String baseUrl;
    private int timeout;
    private String uploadFileName;
    private String selenoidUrl;
    private boolean remote;

}
