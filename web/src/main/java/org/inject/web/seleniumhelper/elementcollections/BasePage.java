package org.inject.web.seleniumhelper.elementcollections;

import org.inject.web.seleniumhelper.elementcollections.annotations.Name;
import org.openqa.selenium.By;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class BasePage {

    private Map<String, By> elements;

    @PostConstruct
    public void init() {
        elements = initElements();
    }

    public By getElement(String name) {
        return Optional.ofNullable(elements.get(name))
                .orElseThrow(() -> new IllegalArgumentException("На странице не найдено элемента с именем " + name));

    }

    private Map<String, By> initElements() {
        List<Field> fields = List.of(getClass().getDeclaredFields());
        return fields.stream()
                .filter(field -> field.getDeclaredAnnotation(Name.class).value() != null)
                .collect(Collectors.toMap(field -> field.getDeclaredAnnotation(Name.class).value(), this::getFieldValue));
    }

    private By getFieldValue(Field field) {
        ReflectionUtils.makeAccessible(field);
        return (By) ReflectionUtils.getField(field, this);
    }
}
