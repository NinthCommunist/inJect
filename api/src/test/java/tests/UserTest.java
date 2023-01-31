package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.TestInstanceParameter;
import org.assertj.core.api.SoftAssertions;
import org.inject.api.models.requests.CredentialsPojo;
import org.inject.api.models.requests.UserPojo;
import org.inject.api.models.responses.ServerResponse;
import org.inject.api.sender.ResponseWrapper;
import org.inject.api.steps.UserSteps;
import org.testng.annotations.Test;

import java.util.Map;

@Epic("Тест пользователей")
public class UserTest {

    @TestInstanceParameter("role")
    private UserPojo userPojo;
    private CredentialsPojo credentialsPojo;
    private UserSteps userSteps;
    private SoftAssertions softly;

    public UserTest(UserPojo userPojo, CredentialsPojo credentialsPojo) {
        this.userPojo = userPojo;
        this.credentialsPojo = credentialsPojo;
        this.userSteps = new UserSteps();
        this.softly = new SoftAssertions();
    }

    @Test(description = "Основной тест для /user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Регистрация, авторизация, получение информации")
    public void mainTestUser() {
        ResponseWrapper responseCreate = userSteps.createUser(userPojo).checkStatusCode(200);
        softly.assertThat(responseCreate.getHeaders())
                .contains(Map.entry("Content-Type", "application/json"));
        softly.assertThat(responseCreate.bodyAs(ServerResponse.class))
                .extracting(ServerResponse::getMessage)
                .isEqualTo(String.valueOf(userPojo.getId()));

        ResponseWrapper responseLogin = userSteps.loginUser(credentialsPojo).checkStatusCode(200);
        softly.assertThat(responseLogin.getHeaders())
                .contains(Map.entry("Content-Type", "application/json"));
        ServerResponse responseBodyLogin = responseLogin.bodyAs(ServerResponse.class);
        softly.assertThat(responseBodyLogin)
                .extracting(ServerResponse::getMessage)
                .isNotNull();
        ///если бы в ответе был токкен авторизации
        userSteps.authorization(responseBodyLogin.getMessage());

        ResponseWrapper responseInfo = userSteps.getUserByUserName(userPojo.getUsername()).checkStatusCode(200);
        softly.assertThat(responseInfo.getHeaders())
                .contains(Map.entry("Content-Type", "application/json"));
        softly.assertThat(responseInfo.bodyAs(UserPojo.class))
                .isEqualTo(userPojo);

        softly.assertAll();

    }


}