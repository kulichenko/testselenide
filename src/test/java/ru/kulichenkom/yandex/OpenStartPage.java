package ru.kulichenkom.yandex;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

public class OpenStartPage {
    private StartPage startPage;

    @BeforeEach
    public void setUp() {
        startPage = open(StartPage.URL, StartPage.class);
    }

    @CsvSource({
            "Примитивные типы"
    })

    @ParameterizedTest
    public void testSearchWithoutLoginMouseInitiate(String searchingText) {
        startPage.searchQueryMouseInitiate(searchingText);
    }

    @CsvSource({
            "Примитивные типы"
    })

    @ParameterizedTest
    public void testSearchWithoutLoginPressEnter(String searchingText) {
        startPage.searchQueryMouseInitiate(searchingText);
    }

    @AfterEach
    void closeBrowser() {
        Selenide.close();
    }
}
