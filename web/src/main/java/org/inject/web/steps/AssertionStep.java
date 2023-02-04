package org.inject.web.steps;

import io.qameta.allure.Step;
import org.inject.web.actions.GetterElementInfoAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
@Scope("threadlocal")
public class AssertionStep {

    @Autowired
    private GetterElementInfoAction getterElementInfoAction;

    @Step("Проверка что у элемента {elementName} текст равен {text}")
    public AssertionStep elementTextIs(String elementName, String text) {
        String elementText = getterElementInfoAction.getElementText(elementName);
        Assert.assertEquals(elementText, text,
                String.format("Текст элемента %s  - '%s'",
                        elementName, text));
        return this;
    }

    @Step("Проверка что у элемента {elementName} атрибут {attribute} равен {value}")
    public AssertionStep elementHasAttributeValue(String elementName, String attribute, String value) {
        String attributeValue = getterElementInfoAction.getElementAttribute(elementName, attribute);
        Assert.assertEquals(attributeValue, value,
                String.format("У элемента %s атрибут %s равен %s",
                        elementName, attribute, attributeValue));
        return this;
    }
}
