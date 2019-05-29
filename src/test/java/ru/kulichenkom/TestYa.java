//Это первый тест на selenide
package ru.kulichenkom;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class TestYa {
    private String searchingText = "Hello, world!";

    @Test
    public void openYa() {
        open("http://yandex.ru ");
        for (int i = 0; i < 10; i++) {//
            if ($(".input__control").exists()) {
                $(".input__control").setValue(searchingText);
            } else
                $("input#text").setValue(searchingText);
            if ($(".websearch-button__text").exists()) {
                $(".websearch-button__text").click();
            } else
                $("div.search2__button").click();
            if ($(".card__narrow").exists()) {
                $$(".typo_text_l").shouldHave(size(13));
            } else $$(".typo_text_l").shouldHave(size(11));
            $(".typo_text_l").shouldHave(Condition.text(searchingText));
        }
    }
}
