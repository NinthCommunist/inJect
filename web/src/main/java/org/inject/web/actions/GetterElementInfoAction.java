package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope("threadlocal")
public class GetterElementInfoAction {

    @Autowired
    ElementSearcher elementsSearcher;

    public String getElementText(String elementName){
        return elementsSearcher.findWebElement(elementName)
                .getText();
    }

    public String getElementAttribute(String elementName, String attribute){
        return Optional.ofNullable(elementsSearcher.findWebElement(elementName)
                .getAttribute(attribute))
                .orElse("null");
    }

}
