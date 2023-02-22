package org.inject.web.pages;

import org.inject.web.seleniumhelper.elementcollections.annotations.Name;
import org.inject.web.seleniumhelper.elementcollections.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("Main")
public class MainPage extends BasePage {

    @Name("Web form")
    private By webFormButton = By.xpath("//a[contains(@href,'web-form')]");

    @Name("Slow calculator")
    private By slowCalculatorButton = By.xpath("//a[contains(@href,'slow-calculator')]");

    @Name("Dialog boxes")
    private By dialogBoxesButton = By.xpath("//a[contains(@href, 'dialog-boxes')]");

    @Name("Login form")
    private By loginFormButton = By.xpath("//a[contains(@href, 'login-form')]");

}
