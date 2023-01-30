package org.inject.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.RequiredArgsConstructor;
import org.testng.Assert;

/**
 * Фильтр проверки времени ответа
 */
@RequiredArgsConstructor
public class CheckResponseTimeFilter implements Filter {

    private final long expectedResponseTime;

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        String requestName = requestSpec.getDerivedPath();
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime <= expectedResponseTime,
                String.format(
                        "Время ответа на запрос %s составляет %d",
                        requestName, responseTime));
        return response;
    }
}
