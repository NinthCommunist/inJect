package org.inject.web.seleniumhelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.inject.web.properties.WebProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Map;

public class WebDriverFactory {

    public static WebDriver getWebDriver(WebProperties webProperties) {
        return webProperties.isRemote() ? remoteDriver(webProperties) : localDriver(webProperties);
    }

    private static WebDriver localDriver(WebProperties webProperties) {
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

    private static WebDriver remoteDriver(WebProperties webProperties) {
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
                driver = WebDriverManager.firefoxdriver().remoteAddress(webProperties.getSelenoidUrl()).capabilities(capabilities).create();
                break;
            case "edge":
                driver = WebDriverManager.edgedriver().remoteAddress(webProperties.getSelenoidUrl()).capabilities(capabilities).create();
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
