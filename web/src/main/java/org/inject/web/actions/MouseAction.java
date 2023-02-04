package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class MouseAction {

    private final ElementSearcher elementsSearcher;
    private final WebDriver driver;

    @Autowired
    public MouseAction(ElementSearcher elementsSearcher, WebDriver driver) {
        this.elementsSearcher = elementsSearcher;
        this.driver = driver;
    }

    public void dragElementBy(String elementName, int xOffset, int yOffset) {
        WebElement sourceElement = elementsSearcher.findClickableElement(elementName);
        new Actions(driver)
                .dragAndDropBy(sourceElement, xOffset, yOffset)
                .build().perform();
    }
}
