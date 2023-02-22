package org.inject.web.actions;

import org.inject.web.seleniumhelper.WebDriverHolder;
import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class WaiterAction {

    private final ElementSearcher elementsSearcher;

    private final WebDriverHolder webDriverHolder;

    @Autowired
    public WaiterAction(ElementSearcher elementsSearcher, WebDriverHolder webDriverHolder) {
        this.elementsSearcher = elementsSearcher;
        this.webDriverHolder = webDriverHolder;
    }

    public void waitElementText(String elementName, String text, int waitSecond) {
        WebElement element = elementsSearcher.findWebElement(elementName);
        wait(webDriverHolder.getDriver(), waitSecond)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    private WebDriverWait wait(WebDriver driver, int second) {
        return new WebDriverWait(driver, Duration.ofSeconds(second));
    }
}
