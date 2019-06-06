package ru.kulichenkom.secondPageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

class RegisterPage {
    private SelenideElement registerButton = $(".green:nth-child(2)");
    private SelenideElement login = $("tr:nth-child(1) > td > input");
    private SelenideElement password = $("tr:nth-child(2) > td > input");
    private SelenideElement realName = $("tr:nth-child(3) > td > input");
    private SelenideElement phoneNo = $("#phone3");
    private SelenideElement email = $("tr:nth-child(5) input");
    private SelenideElement flagAgreePolitic = $(".politika");
    private SelenideElement submitButton = $("#submit_reg");

    public RegisterPage goToRegisterPage() {
        registerButton.click();
        return this;
    }

    public RegisterPage fillRegisterFields(String userName, String userPass,
                                           String firstName, String lastName, String phoneNumber,
                                           String emailAdress) {
        login.setValue(userName);
        password.setValue(userPass);
        realName.setValue(firstName + " " + lastName);
        phoneNo.setValue(phoneNumber);
        email.setValue(emailAdress);
        return this;
    }

    public ProfilePage submitRegistration() {
        flagAgreePolitic.click();
        submitButton.click();
        return new ProfilePage();
    }
}

class ProfilePage {
    private SelenideElement success = $(".succes > b");
    private SelenideElement returnToMainPage = $("a:nth-child(1) > span");
    private SelenideElement nameFIO = $("#namefio");

    public void checkRegisteredName(String nameForChecking) {
        success.shouldHave(Condition.text("Вы успешно зарегистрированы"));
        returnToMainPage.click();
        String expectedValue = nameFIO.getText();
        Assertions.assertEquals(nameForChecking, expectedValue);
    }
}