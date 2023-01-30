package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Диалоговые окна")
public class DialogTest extends BaseTest {

    @Test(description = "Проверка диалогового окна")
    @Feature("Ввод текста в диалог")
    @Story("Взаимодействие с диалогом")
    @Severity(SeverityLevel.MINOR)
    public void alertTest() {
        coreSteps.openPageUsingButton("Dialog boxes", "Dialog Boxes")
                .clickOn("Launch prompt")
                .fillAlert("Текст в диалоге")
                .acceptAlert();

        assertionStep.elementTextIs("Prompt text", "You typed: Текст в диалоге");
    }
}
