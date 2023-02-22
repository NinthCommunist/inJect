package org.inject.web.actions;

import org.inject.web.seleniumhelper.WebDriverHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertAction {

    private final WebDriverHolder webDriverHolder;

    @Autowired
    public AlertAction(WebDriverHolder webDriverHolder) {
        this.webDriverHolder = webDriverHolder;
    }

    public void acceptAlert() {
        webDriverHolder.getDriver().switchTo().alert()
                .accept();
    }

    public void fillAlert(String text) {
        webDriverHolder.getDriver().switchTo().alert()
                .sendKeys(text);
    }
}
