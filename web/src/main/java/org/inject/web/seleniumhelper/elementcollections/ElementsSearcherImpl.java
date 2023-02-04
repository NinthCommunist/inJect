package org.inject.web.seleniumhelper.elementcollections;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Scope("threadlocal")
public class ElementsSearcherImpl implements ElementSearcher {

    private final PageHolder pageHolder;
    private final WebDriver driver;

    @Autowired
    public ElementsSearcherImpl(PageHolder pageHolder, WebDriver driver) {
        this.pageHolder = pageHolder;
        this.driver = driver;
    }

    public WebElement findWebElement(String elementName) {
        return driver.findElement(pageHolder.getCurrentPage()
                .getElement(elementName));
    }

    public WebElement findClickableElement(String elementName) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(findWebElement(elementName)));
    }
}
