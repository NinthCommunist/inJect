package org.inject.web.actions;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("threadlocal")
public class NavigateAction {

    private final WebDriver driver;

    @Autowired
    public NavigateAction(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void quitBrowser() {
        driver.quit();
    }
}
