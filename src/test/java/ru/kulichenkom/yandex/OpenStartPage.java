package ru.kulichenkom.yandex;

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
            "nissan"
    })

    @ParameterizedTest
    public void testSearchWithoutLogin(String searchingText) {
        startPage.searchQuery(searchingText);
    }
}
