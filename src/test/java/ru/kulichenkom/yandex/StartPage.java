package ru.kulichenkom.yandex;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    public static final String URL = "https://yandex.ru/";
    private SelenideElement searchField = $("input#text");
    private SelenideElement searchButton = $("div.search2__button");
    private SelenideElement loginButton = $("div > a.button.desk-notif-card__login-enter-expanded.button_theme_gray.i-bem.button_js_inited");

    public StartPage searchQuery(String searchingText) {
        searchField.setValue(searchingText);
        searchButton.click();
        return this;
    }

}
