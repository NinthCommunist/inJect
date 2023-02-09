package tests;

import org.inject.web.CoreConfig;
import org.inject.web.steps.AssertionStep;
import org.inject.web.steps.CoreSteps;
import org.inject.web.testhelpers.listeners.TestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;


@ContextConfiguration(classes = CoreConfig.class)
@TestExecutionListeners(TestListener.class)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected CoreSteps coreSteps;
    @Autowired
    protected AssertionStep assertionStep;

    @BeforeMethod
    public void setUp() {
        coreSteps.openMainPage();
    }

    @AfterClass
    public void tearDown() {
        coreSteps.quitBrowser();
    }


}