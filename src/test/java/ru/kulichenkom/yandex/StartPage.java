package ru.kulichenkom.yandex;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    public static final String URL = "https://yandex.ru/";
    private SelenideElement searchField = $("input#text");
    private SelenideElement searchButton = $(".button_pressed_yes");

}
