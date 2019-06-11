package ru.kulichenkom.findby;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    @FindBy(css = "tr:nth-child(1) > td > input")
    private SelenideElement login;
    @FindBy(css = "tr:nth-child(2) > td > input")
    private SelenideElement password;
    @FindBy(css = "tr:nth-child(3) > td > input")
    private SelenideElement realName;
    @FindBy(css = "#phone3")
    private SelenideElement phoneNo;
    @FindBy(css = "tr:nth-child(5) input")
    private SelenideElement email;
    @FindBy(css = ".politika")
    private SelenideElement flagAgreePolitic;
    @FindBy(css = "#submit_reg")
    private SelenideElement submitButton;

    public RegistrationPage fillRegisterFields(CharSequence userName, CharSequence userPass,
                                               CharSequence firstName, CharSequence lastName, CharSequence phoneNumber,
                                               CharSequence emailAdress) {
        login.sendKeys(userName);
        password.sendKeys(userPass);
        realName.sendKeys(firstName + " " + lastName);
        phoneNo.sendKeys(phoneNumber);
        email.sendKeys(emailAdress);
        return this;
    }

    public ProfilePage submitRegistration() {
        flagAgreePolitic.click();
        submitButton.click();
        return page(ProfilePage.class);
    }
}

class ProfilePage {
    @FindBy(css = ".succes > b")
    private SelenideElement success;
    @FindBy(css = "a:nth-child(1) > span")
    private SelenideElement returnToMainPage;
    @FindBy(css = "#namefio")
    private SelenideElement nameFIO;

    public void checkRegisteredName(String nameForChecking) {
        success.shouldHave(Condition.text("Вы успешно зарегистрированы"));
        returnToMainPage.click();
        String expectedValue = nameFIO.getText();
        Assertions.assertEquals(nameForChecking, expectedValue);
    }
}

class TestMotoScuterRegistration {
    @Test
    public void testRegistration() {
        open("https://www.moto-scuter.ru/reg/", RegistrationPage.class)
                .fillRegisterFields("sfdahadfrdjhs", "fasbddftasfhfvwuJH312",
                        "gdffthsd", "sfgdfffaaw", "9234188954",
                        "ssqwgb@dflkjg.com").submitRegistration()
                .checkRegisteredName("gdffthsd sfgdfffaaw");
    }
}