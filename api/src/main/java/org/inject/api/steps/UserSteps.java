package org.inject.api.steps;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import org.inject.api.constants.PathsConstants;
import org.inject.api.models.requests.CredentialsPojo;
import org.inject.api.models.requests.UserPojo;
import org.inject.api.sender.ApiSender;
import org.inject.api.sender.ResponseWrapper;

import java.util.Map;


public class UserSteps extends BaseSteps {

    @Step("Создать пользователя {user.username}")
    public ResponseWrapper createUser(UserPojo user) {
        return new ApiSender(apiSender)
                .method(Method.POST)
                .path(PathsConstants.USER.CREATE)
                .body(user)
                .send();
    }

    @Step("Авторизоваться под учеткой {credentials.username}")
    public ResponseWrapper loginUser(CredentialsPojo credentials) {
        return new ApiSender(apiSender)
                .method(Method.GET)
                .path(PathsConstants.USER.LOGIN)
                .queryParam(Map.of("username", credentials.getUsername(),
                        "password", credentials.getPassword()))
                .send();
    }

    @Step("Получить информацию по пользователю {username}")
    public ResponseWrapper getUserByUserName(String username) {
        return new ApiSender(apiSender)
                .method(Method.GET)
                .path(PathsConstants.USER.GET_USER)
                .pathParam(Map.of("username", username))
                .send();
    }
}
