package ru.kulichenkom.pageobject;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestOutlookEmailRegister {
    @Test
    public void register() {
        open("https://signup.live.com/", RegisterPage.class)
                .fillWishfulEmail("sadkjasetValueshkawskdhsaaskjdh@outlook.com")
                .submitRegisterPage()
                .fillPassword("PkssetValuejwG65hdkaD")
                .submitPasswordPage()
                .fillName("sdfsdlf", "sdfsdf")
                .submitFillNamePage()
                .fillCountryAndBirthday("Польша", "12", "Ноябрь", "2001")
                .submitCountryAndBirthdayPage();
    }
}
