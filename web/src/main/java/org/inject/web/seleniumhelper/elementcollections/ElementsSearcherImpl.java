package org.inject.web.seleniumhelper.elementcollections;

import org.inject.web.seleniumhelper.WebDriverHolder;
import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ElementsSearcherImpl implements ElementSearcher {

    private final PageHolder pageHolder;
    private final WebDriverHolder webDriverHolder;

    @Autowired
    public ElementsSearcherImpl(PageHolder pageHolder, WebDriverHolder webDriverHolder) {
        this.pageHolder = pageHolder;
        this.webDriverHolder = webDriverHolder;
    }

    public WebElement findWebElement(String elementName) {
        return webDriverHolder.getDriver().findElement(pageHolder.getCurrentPage()
                .getElement(elementName));
    }

    public WebElement findClickableElement(String elementName) {
        return new WebDriverWait(webDriverHolder.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(findWebElement(elementName)));
    }
}
