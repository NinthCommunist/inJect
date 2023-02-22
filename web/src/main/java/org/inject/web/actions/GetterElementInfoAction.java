package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetterElementInfoAction {

    private final ElementSearcher elementsSearcher;

    @Autowired
    public GetterElementInfoAction(ElementSearcher elementsSearcher) {
        this.elementsSearcher = elementsSearcher;
    }

    public String getElementText(String elementName) {
        return elementsSearcher.findWebElement(elementName)
                .getText();
    }

    public String getElementAttribute(String elementName, String attribute) {
        return Optional.ofNullable(elementsSearcher.findWebElement(elementName)
                        .getAttribute(attribute))
                .orElse("null");
    }

}
