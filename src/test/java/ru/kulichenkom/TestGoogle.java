package ru.kulichenkom;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestGoogle {
    @Test
    public void openGoogle() {
        open("http://google.com ");
        $(By.name("q")).setValue("Hello, world!").pressEnter();
    }
}
