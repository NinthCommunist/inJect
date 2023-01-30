package org.inject.web.actions;

import org.inject.web.pages.MainPage;
import org.inject.web.properties.WebProperties;
import org.inject.web.seleniumhelper.elementcollections.ElementsSearcher;
import org.inject.web.seleniumhelper.elementcollections.PageHolder;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class ButtonAction {

    @Autowired
    ElementsSearcher elementsSearcher;

    public void clickOnButton(String name){
        elementsSearcher.findClickableElement(name).click();
    }
}
