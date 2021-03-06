//переписать эти тесты на использование паттерна PageObject
package ru.kulichenkom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TestGoogleSearch {
    @Test
    public void secondGoogleTest() {
        GoogleSearchPage searchPage = open("http://google.com", GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.typeSearchText("Hello, world!");
        resultsPage.results().shouldHaveSize(9);
//        for (int i = 0; i < 9; i++) {
//            resultsPage.results().get(i).shouldHave(Condition.text("Hello"));
//        }
        resultsPage.results().forEach(element -> element.shouldHave(Condition.text("Hello")));
    }
}

class GoogleSearchPage {
    public GoogleResultsPage typeSearchText(String searchText) {
        $(By.name("q")).setValue(searchText).pressEnter();
        return page(GoogleResultsPage.class);
    }
}

class GoogleResultsPage {
    public ElementsCollection results() {
        return $$(".r");
    }
}
