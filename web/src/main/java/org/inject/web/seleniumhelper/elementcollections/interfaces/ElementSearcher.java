package org.inject.web.seleniumhelper.elementcollections.interfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface ElementSearcher {
    WebElement findWebElement(String elementName);

    WebElement findClickableElement(String elementName);

}
