package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class DropdownAction {

    private final ElementSearcher elementsSearcher;

    @Autowired
    public DropdownAction(ElementSearcher elementsSearcher) {
        this.elementsSearcher = elementsSearcher;
    }

    public void selectDropdownOption(String dropdownName, String optionText) {
        Select select = new Select(elementsSearcher.findWebElement(dropdownName));
        select.selectByVisibleText(optionText);
    }

    public void fillDatalist(String datalistName, String text) {
        WebElement inputDatalist = elementsSearcher.findClickableElement(datalistName);
        WebElement optionDatalist = elementsSearcher.findClickableElement(datalistName)
                .findElement(By.xpath(String.format("./..//option[@value = '%s']",text)));
        inputDatalist.sendKeys(optionDatalist.getAttribute("value"));
    }
}
