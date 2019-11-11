package ru.kulichenkom.yandex;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class OpenStartPage {
    private StartPage startPage;

    @BeforeEach
    public void setUp() {
        startPage = open(StartPage.URL, StartPage.class);
    }
}
