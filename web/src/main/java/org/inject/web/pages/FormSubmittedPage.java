package org.inject.web.pages;

import org.inject.web.annotations.Name;
import org.inject.web.seleniumhelper.elementcollections.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("Form Submitted")
public class FormSubmittedPage extends BasePage {

    @Name("Submit info")
    private By submitInfoText = By.xpath("//h1[@class = 'display-6']");
}
