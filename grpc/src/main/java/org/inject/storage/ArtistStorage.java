package org.inject.storage;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Component
public class ArtistStorage {

    private List<String> PerovPictures =
            List.of("Тройка", "Охотники на привале", "Ботаник");

    private List<String> ShishkinPictures =
            List.of("Утро в сосновом лесу", "Рожь", "Зима",
                    "Сосна на песке", "Лес вечером", "Вечер в сосновом лесу");

    private List<String> AivazovskyPictures =
            List.of("Девятый вал", "Черное море", "Вид Константинополя при лунном освещении");


    private List<String> BrulovPictures =
            List.of("Итальянский полдень", "Всадница", "Бахчисарайский фонтан");

    private List<String> RepinPictures =
            List.of("Бурлаки на волге", "Не ждали", "Садко",
                    "Мужичок из робких", "Диоген и мальчик");

    private List<String> VasnetsovPictures =
            List.of("Богатыри", "Витязь на распутье", "Алёнушка",
                    "Иван-царевич на Сером Волке");

    private List<String> SurikovPictures =
            List.of("Боярыня Морозова", "Витязь на распутье", "Взятие снежного городка",
                    "Вид памятника Петру I на Сенатской площади в Петербурге", "Вид на Кремль");

    private Map<String, List<String>> artistPictures =
            Map.of("Перов", PerovPictures,
                    "Шишкин", ShishkinPictures,
                    "Айвазовский", AivazovskyPictures,
                    "Брюлов", BrulovPictures,
                    "Репин", RepinPictures,
                    "Васнецов", VasnetsovPictures,
                    "Суриков", SurikovPictures);
}
