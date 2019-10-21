package ru.kulichenkom.youtube;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class SearchPage {
    public static final String URL = "https://www.youtube.com/";
    private SelenideElement inputSearch = $("input#search");
    private SelenideElement searchButton = $("button#search-icon-legacy");
    private SelenideElement loginButton = $("div#buttons yt-formatted-string#text");
    private SelenideElement userName = $("#identifierId");
    private SelenideElement password = $("input.whsOnd");
    private SelenideElement goToPasswordButton = $("#identifierNext");
    private SelenideElement nextButton = $("#passwordNext");

    public SearchPage login(String user, String pass) {
            loginButton.click();
            userName.setValue(user);
            goToPasswordButton.click();
            nextButton.waitUntil(visible, 3000);
            password.setValue(pass);
            nextButton.click();
        return this;
    }

    public ResultPage searchVideo(String searchingText) {
        inputSearch.setValue(searchingText);
        searchButton.click();
        return new ResultPage();
    }
}

class ResultPage {
    private ElementsCollection contents = $$(".ytd-two-column-search-results-renderer:nth-child(1) > #contents");
    private SelenideElement toggleButton = $("#container ytd-toggle-button-renderer > a > paper-button#button");

    public void checkingResults(String searchQuery) {
        toggleButton.waitUntil(appear, 5000); //waiting for toggle button appearance
        Assertions.assertNotNull(contents);
        Assertions.assertTrue(contents.toString().contains(searchQuery));
    }
}