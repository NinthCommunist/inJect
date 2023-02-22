package org.inject.web.seleniumhelper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.inject.web.properties.WebProperties;
import org.inject.web.seleniumhelper.elementcollections.PageHolder;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


public abstract class WebDriverHolder {

    public abstract WebDriver getDriver();

}
