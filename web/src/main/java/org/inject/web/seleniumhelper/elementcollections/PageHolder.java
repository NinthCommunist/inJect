package org.inject.web.seleniumhelper.elementcollections;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope("threadlocal")
public class PageHolder {

    @Autowired
    private BeanFactory beanFactory;

    private BasePage currentPage;

    public BasePage getCurrentPage() {
        return Optional.ofNullable(currentPage)
                .orElseThrow(() ->
                        new IllegalArgumentException("Не удалось получить текущую страницу, проверьте, что она установлена."));
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = beanFactory.getBean(currentPage, BasePage.class);
    }
}
