package org.inject.api.steps;

import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.inject.api.sender.ApiRequest;
import org.inject.api.sender.StableRequestData;

import java.util.List;
import java.util.Map;

public abstract class BaseSteps {

    protected StableRequestData stableRequestData = new StableRequestData();

    public void authorization(String token) {
        addHeadersForStep(Map.of("Authorization", token));
    }

    public void addHeadersForStep(Map<String, String> headers) {
        stableRequestData.addHeaders(headers);
    }

    public void addCookiesForStep(List<Cookie> cookies) {
        stableRequestData.addCookies(cookies);
    }
}
