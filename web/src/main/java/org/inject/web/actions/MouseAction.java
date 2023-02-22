package org.inject.web.actions;

import org.inject.web.seleniumhelper.WebDriverHolder;
import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MouseAction {

    private final ElementSearcher elementsSearcher;
    private final WebDriverHolder webDriverHolder;

    @Autowired
    public MouseAction(ElementSearcher elementsSearcher, WebDriverHolder webDriverHolder) {
        this.elementsSearcher = elementsSearcher;
        this.webDriverHolder = webDriverHolder;
    }

    public void dragElementBy(String elementName, int xOffset, int yOffset) {
        WebElement sourceElement = elementsSearcher.findClickableElement(elementName);
        new Actions(webDriverHolder.getDriver())
                .dragAndDropBy(sourceElement, xOffset, yOffset)
                .build().perform();
    }
}
