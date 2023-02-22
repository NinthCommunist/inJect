package org.inject.web.actions;

import org.inject.web.seleniumhelper.WebDriverHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigateAction {

    private final WebDriverHolder webDriverHolder;

    @Autowired
    public NavigateAction(WebDriverHolder webDriverHolder) {
        this.webDriverHolder = webDriverHolder;
    }

    public void openUrl(String url) {
        webDriverHolder.getDriver().get(url);
    }

    public void quitBrowser() {
        webDriverHolder.getDriver().quit();
    }
}
