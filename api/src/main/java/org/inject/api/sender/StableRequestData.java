package org.inject.api.sender;

import io.restassured.http.Cookie;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class StableRequestData {

    private Map<String, String> headers;
    private List<Cookie> cookies;

    public StableRequestData(){
        headers = new HashMap<>();
        cookies = new ArrayList<>();
    }

    public void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    public void addCookies(List<Cookie> cookies) {
        this.cookies.addAll(cookies);
    }
}
