package org.inject.web.seleniumhelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.inject.web.properties.WebProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;

@Component
@Scope("threadlocal")
@EnableConfigurationProperties(WebProperties.class)
public class WebDriverFactory {

    private final WebProperties webProperties;

    @Autowired
    public WebDriverFactory(WebProperties webProperties) {
        this.webProperties = webProperties;
    }

    @Bean
    @Scope("threadlocal")
    public WebDriver getWebDriver() {
        return webProperties.isRemote() ? remoteDriver() : localDriver();
    }

    private WebDriver localDriver() {
        WebDriver driver;
        switch (webProperties.getBrowserName()) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "edge":
                driver = WebDriverManager.edgedriver().create();
                break;
            default:
                throw new IllegalArgumentException("Неверно указан браузер: " + webProperties.getBrowserName());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(webProperties.getTimeout()));
        return driver;
    }

    private WebDriver remoteDriver() {
        WebDriver driver;
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true
        ));
        switch (webProperties.getBrowserName()) {
            case "chrome":
                driver = WebDriverManager.chromedriver().remoteAddress(webProperties.getSelenoidUrl()).capabilities(capabilities).create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().remoteAddress(webProperties.getSelenoidUrl()).create();
                break;
            case "edge":
                driver = WebDriverManager.edgedriver().remoteAddress(webProperties.getSelenoidUrl()).create();
                break;
            default:
                throw new IllegalArgumentException("Неверно указан браузер: " + webProperties.getBrowserName());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(webProperties.getTimeout()));
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        return driver;
    }
}
