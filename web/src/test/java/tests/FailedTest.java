package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Упавший тест")
public class FailedTest extends BaseTest {

    @Test(description = "Специально упавший тест")
    @Feature("Ошибка авторизации")
    @Story("Неверный пароль")
    @Severity(SeverityLevel.CRITICAL)
    public void alertTest(){
        coreSteps.openPageUsingButton("Login form", "Login Form")
                .fillInput("Login", "username")
                .fillInput("Password", "123456")
                .clickOn("Submit");

        assertionStep.elementTextIs("Authorization result", "Success");
    }
}
