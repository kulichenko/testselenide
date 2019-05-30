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
        resultsPage.results().get(0).shouldHave(Condition.text("Hello, world"));
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
