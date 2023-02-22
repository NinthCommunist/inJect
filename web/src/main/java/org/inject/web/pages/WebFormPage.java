package org.inject.web.pages;

import org.inject.web.seleniumhelper.elementcollections.annotations.Name;
import org.inject.web.seleniumhelper.elementcollections.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("Web Form")
public class WebFormPage extends BasePage {

    @Name("Text input")
    private By textInput = By.xpath("//input[@id = 'my-text-id']");

    @Name("Password")
    private By passwordInput = By.xpath("//input[@name = 'my-password']");

    @Name("Dropdown (select)")
    private By dropdownSelect = By.xpath("//select[@name = 'my-select']");

    @Name("Dropdown (datalist)")
    private By datalistInput = By.xpath("//input[@list = 'my-options']");

    @Name("File input")
    private By fileInput = By.xpath("//input[@type = 'file']");

    @Name("Checked checkbox")
    private By checkedCheckbox = By.xpath("//input[@id = 'my-check-1']");

    @Name("Default checkbox")
    private By defaultCheckbox = By.xpath("//input[@id = 'my-check-2']");

    @Name("Checked radio")
    private By checkedRadio = By.xpath("//input[@id = 'my-radio-1']");

    @Name("Default radio")
    private By defaultRadio = By.xpath("//input[@id = 'my-radio-2']");

    @Name("Color picker")
    private By colorInput = By.xpath("//input[@type = 'color']");

    @Name("Date picker")
    private By dateInput = By.xpath("//input[@name = 'my-date']");

    @Name("Example range")
    private By rangeInput = By.xpath("//input[@type = 'range']");

    @Name("Submit")
    private By submitButton = By.xpath("//button[@type = 'submit']");

    @Name("Disabled input")
    private By disabledInput = By.xpath("//input[@name = 'my-disabled']");

    @Name("Readonly input")
    private By readonlyInput = By.xpath("//input[@name = 'my-readonly']");
}
