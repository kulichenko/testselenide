package ru.kulichenkom.yandex;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    public static final String URL = "https://yandex.ru/";
    private SelenideElement searchField = $("input#text");
    private SelenideElement searchButton = $("div.search2__button > button[type=\"submit\"]");

    public StartPage searchQueryMouseInitiate(String searchingText) {
        searchField.setValue(searchingText);
        searchButton.click();
        return this;
    }

    public StartPage searchQueryPressEnter(String searchingText) {
        searchField.setValue(searchingText).pressEnter();
        return this;
    }
}