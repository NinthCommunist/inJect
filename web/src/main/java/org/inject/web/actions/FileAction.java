package org.inject.web.actions;

import org.inject.web.seleniumhelper.elementcollections.ElementsSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class FileAction {

    @Autowired
    ElementsSearcher elementsSearcher;

    public void uploadFile(String inputName, String filePath){
        elementsSearcher.findWebElement(inputName).sendKeys(filePath);
    }
}
