package org.inject.web.actions;

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
public class WaiterAction {

    private final ElementSearcher elementsSearcher;

    private final WebDriver driver;

    @Autowired
    public WaiterAction(ElementSearcher elementsSearcher, WebDriver driver) {
        this.elementsSearcher = elementsSearcher;
        this.driver = driver;
    }

    public void waitElementText(String elementName, String text, int waitSecond) {
        WebElement element = elementsSearcher.findWebElement(elementName);
        wait(driver, waitSecond)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    private WebDriverWait wait(WebDriver driver, int second) {
        return new WebDriverWait(driver, Duration.ofSeconds(second));
    }
}
