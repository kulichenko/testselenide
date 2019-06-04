package ru.kulichenkom.pageobject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

class RegisterPage {
    public RegisterPage fillWishfulEmail(String email) {
        $("#MemberName").setValue(email);
        return page(RegisterPage.class);
    }

    public PasswordInput submitRegisterPage() {
        $("#iSignupAction").click();
        return page(PasswordInput.class);
    }
}

class PasswordInput {
    public PasswordInput fillPassword(String password) {
        $("#PasswordInput").setValue(password);
        return page(PasswordInput.class);
    }

    public NameInputPage submitPasswordPage() {
        $("#iSignupAction").click();
        return page(NameInputPage.class);
    }
}

class NameInputPage {
    public NameInputPage fillName(String lastName, String firstName) {
        $("#LastName").setValue(lastName);
        $("#FirstName").setValue(firstName);
        return page(NameInputPage.class);
    }

    public СountryAndBirthday submitFillNamePage() {
        $("#iSignupAction").click();
        return page(СountryAndBirthday.class);
    }
}

class СountryAndBirthday {
    public СountryAndBirthday fillCountryAndBirthday(String country, String day, String month, String year) {
        $("#Country").selectOption(country);
        $("#BirthDay").selectOption(day);
        $("#BirthMonth").selectOption(month);
        $("#BirthYear").selectOption(year);
        return page(СountryAndBirthday.class);
    }

    public void submitCountryAndBirthdayPage() {
        $("#iSignupAction").click();
    }
}