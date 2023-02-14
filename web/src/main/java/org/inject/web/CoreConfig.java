package org.inject.web;

import org.inject.web.properties.WebProperties;
import org.inject.web.seleniumhelper.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
@EnableConfigurationProperties(WebProperties.class)
public class CoreConfig {

    @Autowired
    private WebProperties webProperties;

    @Bean
    @Scope("threadlocal")
    public WebDriver webDriver(){
        return WebDriverFactory.getWebDriver(webProperties);
    }
}
