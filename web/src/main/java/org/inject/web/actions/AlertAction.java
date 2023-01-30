package org.inject.web.actions;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class AlertAction {

    @Autowired
    WebDriver driver;

    public void acceptAlert() {
        driver.switchTo().alert()
                .accept();
    }

    public void fillAlert(String text) {
        driver.switchTo().alert()
                .sendKeys(text);
    }
}
