package org.inject.api.sender;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;
import java.util.stream.Collectors;

public class ResponseWrapper {

    private final Response response;

    public ResponseWrapper(Response response) {
        this.response = response;
    }

    public ResponseWrapper checkStatusCode(int statusCode) {
        Assert.assertTrue(statusCode == response.getStatusCode(), "Неверный статус код: " + response.getStatusCode());
        return this;
    }

    public <T> T bodyAs(Class<T> t) {
        return response.getBody().as(t);
    }

    public Map<String, String> getHeaders() {
        return response.headers().asList().stream().collect(Collectors.toMap(Header::getName, Header::getValue));
    }
}
