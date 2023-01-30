package tests;

import io.qameta.allure.*;
import org.inject.web.testhelpers.testdata.dataproviders.DataProviders;
import org.inject.web.testhelpers.testdata.models.WebFormModel;
import org.testng.annotations.Test;

import static java.util.stream.Collectors.toList;

@Epic("Главная форма")
public class WebFormTest extends BaseTest {

    @Test(description = "Отправка простой формы",
            dataProvider = "simpleWebForm",
            dataProviderClass = DataProviders.class)
    @Feature("Заполнение формы")
    @Story("Заполнение тестовых данных через провайдер")
    @Severity(SeverityLevel.BLOCKER)
    public void mainTest(WebFormModel model) throws InterruptedException {
        coreSteps.openPageUsingButton("Web form", "Web Form")
                .fillInput("Text input", model.getTextInput())
                .fillInput("Password", model.getPasswordInput())
                .selectDropdownOptionText("Dropdown (select)", model.getDropdownSelect().getValue())
                .fillInputDatalist("Dropdown (datalist)", model.getDropdownDatalist().getValue())
                .uploadFile("File input", model.getFilePath())
                .clickOn(model.getCheckboxes().stream().map(it -> it.getValue()).collect(toList()))
                .clickOn(model.getRadioButton().getValue())
                .fillInput("Color picker", model.getColor())
                .fillInput("Date picker", model.getDate())
                .dragElementBy("Example range", model.getRangeXoffset(), 0)
                .openPageUsingButton("Submit", "Form Submitted");

        assertionStep.elementTextIs("Submit info", "Form submitted");
    }

    @Test(description = "Проверка полей формы")
    @Feature("Заполнение формы")
    @Story("Заполнение тестовых данных вручную")
    @Severity(SeverityLevel.NORMAL)
    public void checkField(){
        coreSteps.openPageUsingButton("Web form", "Web Form")
                .fillInput("Text input", "Тест можно писать как обычный кейс")
                .fillInput("Password", "123456");

        assertionStep.elementHasAttributeValue("Disabled input", "disabled", "true")
                .elementHasAttributeValue("Readonly input", "readonly", "true");
    }

}
