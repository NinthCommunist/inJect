package org.inject.web.pages;

import org.inject.web.annotations.Name;
import org.inject.web.seleniumhelper.elementcollections.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component("Slow Calculator")
public class SlowCalculatorPage extends BasePage {

    @Name("1")
    private By oneButton = By.xpath("//span[text() = '1']");

    @Name("2")
    private By twoButton = By.xpath("//span[text() = '2']");

    @Name("3")
    private By threeButton = By.xpath("//span[text() = '3']");

    @Name("4")
    private By fourButton = By.xpath("//span[text() = '4']");

    @Name("5")
    private By fiveButton = By.xpath("//span[text() = '5']");

    @Name("6")
    private By sixButton = By.xpath("//span[text() = '6']");

    @Name("7")
    private By sevenButton = By.xpath("//span[text() = '7']");

    @Name("8")
    private By eightButton = By.xpath("//span[text() = '8']");

    @Name("9")
    private By nineButton = By.xpath("//span[text() = '9']");

    @Name("+")
    private By plusButton = By.xpath("//span[text() = '+']");

    @Name("=")
    private By equalsButton = By.xpath("//span[text() = '=']");

    @Name("Calculator screen")
    private By calculatorScreen = By.xpath("//div[@class = 'screen']");
}
