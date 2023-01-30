package tests;

import io.qameta.allure.*;
import org.inject.web.testhelpers.testdata.dataproviders.DataProviders;
import org.inject.web.testhelpers.testdata.models.SlowCalculatorModel;
import org.testng.annotations.Test;

@Epic("Медленный калькулятор")
public class SlowCalculatorTest extends BaseTest {

    @Test(description = "Сложение двух чисел",
            dataProvider = "simpleSlowCalc",
            dataProviderClass = DataProviders.class)
    @Feature("Сложение")
    @Story("Два числа")
    @Severity(SeverityLevel.NORMAL)
    public void calculatorTest(SlowCalculatorModel model){
        coreSteps.openPageUsingButton("Slow calculator", "Slow Calculator")
                .clickOn(model.getFirstValue())
                .clickOn("+")
                .clickOn(model.getSecondValue())
                .clickOn("=")
                .waitElementTextToBe("Calculator screen", model.getResultValue(), 10);

        assertionStep.elementTextIs("Calculator screen", model.getResultValue());
    }
}
