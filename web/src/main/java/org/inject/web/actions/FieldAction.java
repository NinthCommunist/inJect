package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.ElementsSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class FieldAction {

    @Autowired
    ElementsSearcher elementsSearcher;

    public void fillInput(String inputName, String text){
        elementsSearcher.findClickableElement(inputName).sendKeys(text);
    }
}
