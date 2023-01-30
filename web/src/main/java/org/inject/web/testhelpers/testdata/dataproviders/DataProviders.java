package org.inject.web.testhelpers.testdata.dataproviders;

import org.inject.web.testhelpers.testdata.generate.TestDataGenerator;
import org.inject.web.testhelpers.testdata.models.SlowCalculatorModel;
import org.inject.web.testhelpers.testdata.models.WebFormModel;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class DataProviders {

    private final TestDataGenerator testDataGenerator = new TestDataGenerator();

    @DataProvider(name = "simpleWebForm")
    public Iterator<WebFormModel> createSimpleWebFormData() {
        return List.of(testDataGenerator.generateWebFormModel()).iterator();
    }

    @DataProvider(name = "simpleSlowCalc")
    public Iterator<SlowCalculatorModel> createSimpleSlowCalcData() {
        return List.of(testDataGenerator.generateSimpleSlowCalcModel()).iterator();
    }
}
