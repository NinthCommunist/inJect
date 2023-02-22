package org.inject.web.testhelpers.testdata.generate;

import net.datafaker.Faker;
import org.inject.web.testhelpers.testdata.models.SlowCalculatorModel;
import org.inject.web.testhelpers.testdata.models.WebFormModel;

import java.nio.file.FileSystems;
import java.util.List;
import java.util.stream.Collectors;

public class TestDataGenerator {

    private final Faker faker = new Faker();

    public WebFormModel generateWebFormModel() {
        String uploadFileName = "/UploadTestFile";
        String datePattern = "MM/dd/YYYY";
        int minOffset = -150;
        int maxOffset = 150;

        return WebFormModel.builder()
                .textInput(faker.cat().name())
                .passwordInput(faker.internet().password())
                .dropdownSelect(faker.options().option(WebFormModel.DropdownSelectEnum.class))
                .dropdownDatalist(faker.options().option(WebFormModel.DropdownDatalistEnum.class))
                .filePath(createUploadFilePath(uploadFileName))
                .checkboxes(filterRandomElements(List.of(WebFormModel.CheckboxesEnum.values())))
                .radioButton(faker.options().option(WebFormModel.RadioButtonEnum.class))
                .color(faker.color().hex())
                .date(faker.date().birthday(datePattern))
                .rangeXoffset(faker.random().nextInt(minOffset, maxOffset))
                .build();
    }

    public SlowCalculatorModel generateSimpleSlowCalcModel() {
        int firstValue = faker.random().nextInt(1, 9);
        int secondValue = faker.random().nextInt(1, 9);
        int resultValue = firstValue + secondValue;

        return SlowCalculatorModel.builder()
                .firstValue(String.valueOf(firstValue))
                .secondValue(String.valueOf(secondValue))
                .resultValue(String.valueOf(resultValue))
                .build();
    }

    private String createUploadFilePath(String filename) {
        return FileSystems.getDefault().getPath("src/main/resources/testfiles")
                .toAbsolutePath() + filename;
    }

    /**
     * Метод, который оставляет в списке случайные элементы
     *
     * @param list список, который нужно отфильровать
     * @param <E>  тип хрнящийся в списке
     * @return список, где остались случайные элементы
     */
    private <E> List<E> filterRandomElements(List<E> list) {
        return list.stream().filter(e -> faker.random().nextBoolean())
                .collect(Collectors.toList());
    }
}
