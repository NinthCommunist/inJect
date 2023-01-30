package org.inject.web.pages;

import org.inject.web.annotations.Name;
import org.inject.web.seleniumhelper.elementcollections.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("Login Form")
public class LoginFormPage extends BasePage {

    @Name("Login")
    private By loginButton = By.xpath("//input[@id = 'username']");

    @Name("Password")
    private By passwordButton = By.xpath("//input[@id = 'password']");

    @Name("Submit")
    private By submitButton = By.xpath("//button[@type = 'submit']");

    @Name("Authorization result")
    private By authResultText = By.xpath("//div[@role = 'alert']");
}

