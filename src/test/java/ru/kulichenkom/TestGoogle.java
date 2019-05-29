//Это первый тест на selenide
package ru.kulichenkom;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestGoogle {
    @Test
    public void openGoogle() {
        open("http://google.com ");
        $(By.name("q")).setValue("Hello, world!").pressEnter();
        if ($(".P94G9b").exists()) {
            $$(".r").shouldHave(size(9));
        } else $$(".r").shouldHave(size(10));
        $(".r").shouldHave(Condition.text("Hello, world"));
    }
}
