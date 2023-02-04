package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class FieldAction {

    private final ElementSearcher elementsSearcher;

    @Autowired
    public FieldAction(ElementSearcher elementsSearcher) {
        this.elementsSearcher = elementsSearcher;
    }

    public void fillInput(String inputName, String text){
        elementsSearcher.findClickableElement(inputName).sendKeys(text);
    }
}
