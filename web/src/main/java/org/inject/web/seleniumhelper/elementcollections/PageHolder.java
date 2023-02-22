package org.inject.web.seleniumhelper.elementcollections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@Scope(value = "threadlocal", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PageHolder {

    private final Map<String, BasePage> pages;
    private BasePage currentPage;

    @Autowired
    public PageHolder(Map<String, BasePage> pages) {
        this.pages = pages;
    }

    public BasePage getCurrentPage() {
        return Optional.ofNullable(currentPage)
                .orElseThrow(() ->
                        new IllegalArgumentException("Не удалось получить текущую страницу, проверьте, что она установлена."));
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = pages.get(currentPage);
    }
}
