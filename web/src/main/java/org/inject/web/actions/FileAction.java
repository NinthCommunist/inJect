package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.interfaces.ElementSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class FileAction {

    private final ElementSearcher elementsSearcher;

    @Autowired
    public FileAction(ElementSearcher elementsSearcher) {
        this.elementsSearcher = elementsSearcher;
    }

    public void uploadFile(String inputName, String filePath){
        elementsSearcher.findWebElement(inputName).sendKeys(filePath);
    }
}
