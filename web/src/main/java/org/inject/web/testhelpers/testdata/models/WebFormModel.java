package org.inject.web.testhelpers.testdata.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.inject.web.testhelpers.testdata.interfaces.EnumConvertibleToString;

import java.util.List;

@Data
@Builder
public class WebFormModel {

    private final String textInput;
    private final String passwordInput;
    private final DropdownSelectEnum dropdownSelect;
    private final DropdownDatalistEnum dropdownDatalist;
    private final String filePath;
    private final List<CheckboxesEnum> checkboxes;
    private final RadioButtonEnum radioButton;
    private final String color;
    private final String date;
    private final int rangeXoffset;


    public enum DropdownSelectEnum implements EnumConvertibleToString {
        ONE("One"),
        TWO("Two"),
        THREE("Three");

        @Getter
        private final String value;

        DropdownSelectEnum(String value) {
            this.value = value;
        }
    }

    public enum DropdownDatalistEnum implements EnumConvertibleToString {
        SAN_FRANCISCO("San Francisco"),
        NEW_YORK("New York"),
        SEATTLE("Seattle"),
        LOS_ANGELES("Los Angeles"),
        CHICAGO("Chicago");

        @Getter
        private final String value;

        DropdownDatalistEnum(String value) {
            this.value = value;
        }
    }

    public enum CheckboxesEnum implements EnumConvertibleToString {
        CHECKED("Checked checkbox"),
        DEFAULT("Default checkbox");

        @Getter
        private final String value;

        CheckboxesEnum(String value) {
            this.value = value;
        }
    }


    public enum RadioButtonEnum implements EnumConvertibleToString {
        CHECKED("Checked radio"),
        DEFAULT("Default radio");

        @Getter
        private final String value;

        RadioButtonEnum(String value) {
            this.value = value;
        }
    }
}
