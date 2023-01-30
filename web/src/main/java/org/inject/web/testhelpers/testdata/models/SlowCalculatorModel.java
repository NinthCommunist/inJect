package org.inject.web.testhelpers.testdata.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlowCalculatorModel {

    private final String firstValue;
    private final String secondValue;
    private final String resultValue;

}
