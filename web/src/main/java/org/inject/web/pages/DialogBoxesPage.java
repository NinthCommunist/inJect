package org.inject.web.pages;

import org.inject.web.annotations.Name;
import org.inject.web.seleniumhelper.elementcollections.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("Dialog Boxes")
public class DialogBoxesPage extends BasePage {

    @Name("Launch prompt")
    private By promptButton = By.xpath("//button[@id = 'my-prompt']");

    @Name("Prompt text")
    private By promptText = By.xpath("//p[@id = 'prompt-text']");
}
