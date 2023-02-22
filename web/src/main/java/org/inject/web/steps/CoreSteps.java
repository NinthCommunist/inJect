package org.inject.web.steps;

import io.qameta.allure.Step;
import org.inject.web.actions.*;
import org.inject.web.properties.WebProperties;
import org.inject.web.seleniumhelper.elementcollections.PageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoreSteps {
    @Autowired
    private WebProperties webProperties;

    @Autowired
    private PageHolder pageHolder;

    @Autowired
    private ButtonAction buttonAction;

    @Autowired
    private NavigateAction navigateAction;

    @Autowired
    private FieldAction fieldAction;

    @Autowired
    private DropdownAction dropdownAction;

    @Autowired
    private FileAction fileAction;

    @Autowired
    private MouseAction mouseAction;

    @Autowired
    private WaiterAction waiterAction;

    @Autowired
    private AlertAction alertAction;

    @Step("Открыть главную страницу")
    public void openMainPage() {
        navigateAction.openUrl(webProperties.getBaseUrl());
        pageHolder.setCurrentPage("Main");
    }

    @Step("Закрыть браузер")
    public void quitBrowser() {
        navigateAction.quitBrowser();
    }

    @Step("Открыть страницу {pageName} используя кнопку {buttonName}")
    public CoreSteps openPageUsingButton(String buttonName, String pageName) {
        buttonAction.clickOnButton(buttonName);
        pageHolder.setCurrentPage(pageName);
        return this;
    }

    @Step("Нажать на {elementName}")
    public CoreSteps clickOn(String elementName) {
        buttonAction.clickOnButton(elementName);
        return this;
    }

    @Step("Заполнить поле {inputName} текстом {text}")
    public CoreSteps fillInput(String inputName, String text) {
        fieldAction.fillInput(inputName, text);
        return this;
    }

    @Step("В дропдауне {dropdownName} выбрать опцию c текстом {optionText}")
    public CoreSteps selectDropdownOptionText(String dropdownName, String optionText) {
        dropdownAction.selectDropdownOption(dropdownName, optionText);
        return this;
    }

    @Step("В даталисте {datalistName} ввести значение {text} из опции")
    public CoreSteps fillInputDatalist(String datalistName, String text) {
        dropdownAction.fillDatalist(datalistName, text);
        return this;
    }

    @Step("В загрузчк файлов {inputName} загрузить файл {filePath}")
    public CoreSteps uploadFile(String inputName, String filePath) {
        fileAction.uploadFile(inputName, filePath);
        return this;
    }

    @Step("Нажать на элементы {elements}")
    public CoreSteps clickOn(List<String> elements) {
        elements.forEach(this::clickOn);
        return this;
    }

    @Step("Перетащить элемент {elementName} по оси X на {xOffset} и по оси Y на {yOffset} ")
    public CoreSteps dragElementBy(String elementName, int xOffset, int yOffset) {
        mouseAction.dragElementBy(elementName, xOffset, yOffset);
        return this;
    }

    @Step("Ждать появление у элемента {elementName} текста '{text}' {waitSeconds} секунд ")
    public CoreSteps waitElementTextToBe(String elementName, String text, int waitSeconds) {
        waiterAction.waitElementText(elementName, text, waitSeconds);
        return this;
    }

    @Step("Принять алерт")
    public CoreSteps acceptAlert() {
        alertAction.acceptAlert();
        return this;
    }

    @Step("Заполнить алерт текстом {text}")
    public CoreSteps fillAlert(String text) {
        alertAction.fillAlert(text);
        return this;
    }
}
