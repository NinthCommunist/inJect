package org.inject.api.steps;

import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.inject.api.sender.ApiSender;

import java.util.List;
import java.util.Map;

public abstract class BaseSteps {

    protected ApiSender apiSender = new ApiSender();

    @Step("Добавлен токен авторизации")
    public void authorization(String token) {
        addHeadersForStep(Map.of("Authorization", token));
    }

    public void addHeadersForStep(Map<String, String> headers) {
        apiSender.addHeaders(headers);
    }

    public void addCookiesForStep(List<Cookie> cookies) {
        apiSender.addCookies(cookies);
    }
}
