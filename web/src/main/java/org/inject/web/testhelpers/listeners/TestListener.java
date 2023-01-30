package org.inject.web.testhelpers.listeners;

import org.inject.web.testhelpers.screenshots.ScreenshotMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

@Component
public class TestListener implements TestExecutionListener {

    @Autowired
    private ScreenshotMaker screenshotMaker;

    @Override
    public void beforeTestMethod(TestContext testContext) {
        testContext.getApplicationContext()
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
    }

    @Override
    public void afterTestExecution(TestContext testContext) {
        if (testContext.getTestException() != null) {
            screenshotMaker.makeScreenshot();
        }
    }
}