package org.inject.api.sender;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Cookie;
import io.restassured.http.Method;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.inject.api.constants.PathsConstants;
import org.inject.api.constants.TimeConstants;
import org.inject.api.filters.CheckResponseTimeFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Единственный класс, который отправляет запрос
 */
@Setter
@Accessors(fluent = true)
public class ApiRequest {

    private Method method;
    private String path;
    private Map<String, String> pathParam;
    private Map<String, String> headers;
    private List<Cookie> cookies;
    private Map<String, String> queryParam;
    private Object body;

    private RequestSpecBuilder requestSpecBuilder;

    public ApiRequest(StableRequestData stableRequestData) {
        this.headers = stableRequestData.getHeaders();
        this.cookies = stableRequestData.getCookies();
        this.requestSpecBuilder = new RequestSpecBuilder();
    }

    public ResponseWrapper send() {
        buildHeaders();
        buildUrl();
        buildBody();

        return new ResponseWrapper(given(requestSpecBuilder.build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .filter(new AllureRestAssured())
                .filter(new CheckResponseTimeFilter(TimeConstants.EXPECTED_RESPONSE_TIME))
                .when()
                .request(method)
                .andReturn());
    }

    private void buildUrl() {
        requestSpecBuilder.setBaseUri(PathsConstants.BASE_URL);
        if (path != null) {
            requestSpecBuilder.setBasePath(path);
        }
        if (queryParam != null) {
            requestSpecBuilder.addQueryParams(queryParam);
        }
        if (pathParam != null) {
            pathParam.forEach((key, value) -> requestSpecBuilder.addPathParam(key, value));
        }
    }

    private void buildHeaders() {
        requestSpecBuilder.addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        if (headers.size() != 0) {
            requestSpecBuilder.addHeaders(headers);
        }
        if (cookies.size() != 0) {
            cookies.forEach(requestSpecBuilder::addCookie);
        }

    }

    private void buildBody() {
        if (body != null) {
            requestSpecBuilder.setBody(body);
        }
    }
}
