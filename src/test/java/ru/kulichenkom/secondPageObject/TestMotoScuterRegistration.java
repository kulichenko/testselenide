package ru.kulichenkom.secondPageObject;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestMotoScuterRegistration {
    @Test
    public void testRegistration() {
        open("https://www.moto-scuter.ru/", RegisterPage.class)
                .goToRegisterPage()
                .fillRegisterFields("sfdahdfsdjhs", "fasbdhfvwuJH312",
                        "sfdhsd", "sdfdhffaaw", "6615478545",
                        "sdsdsahgb@dflkjg.com")
                .submitRegistration()
                .checkRegisteredName("sfdhsd sdfdhffaaw");
    }
}
