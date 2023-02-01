package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class ButtonAction {

    @Autowired
    ElementSearcher elementsSearcher;

    public void clickOnButton(String name){
        elementsSearcher.findClickableElement(name).click();
    }
}
