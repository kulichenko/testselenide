//переписать эти тесты на использование паттерна PageObject
package ru.kulichenkom;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class GoogleOpenAndTest {
    @Test
    public void testGooglePage() {
        openUrl openGoogle = new openUrl("http://google.com", "Hello, world!");
        openGoogle.openPage();
        openGoogle.checkResults();
    }
}
class openUrl {
    private String url, searchText;

    public openUrl(String url, String searchText) {
        this.url = url;
        this.searchText = searchText;
    }

    public void openPage() {
        open(url);
        $(By.name("q")).setValue(searchText).pressEnter();
    }

    public void checkResults() {

        if ($(".P94G9b").exists()) {
            $$(".r").shouldHave(size(9));
        } else $$(".r").shouldHave(size(10));
        $(".r").shouldHave(Condition.text(searchText));
    }
}

