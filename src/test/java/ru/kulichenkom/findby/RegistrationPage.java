package ru.kulichenkom.findby;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
    private WebDriver driver;
    @FindBy(css = "tr:nth-child(1) > td > input")
    private WebElement login;
    @FindBy(css = "tr:nth-child(2) > td > input")
    private WebElement password;
    @FindBy(css = "tr:nth-child(3) > td > input")
    private WebElement realName;
    @FindBy(css = "#phone3")
    private WebElement phoneNo;
    @FindBy(css = "tr:nth-child(5) input")
    private WebElement email;
    @FindBy(css = ".politika")
    private WebElement flagAgreePolitic;
    @FindBy(css = "#submit_reg")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillRegisterFields(CharSequence userName, CharSequence userPass,
                                   CharSequence firstName, CharSequence lastName, CharSequence phoneNumber,
                                   CharSequence emailAdress) {
        login.sendKeys(userName);
        password.sendKeys(userPass);
        realName.sendKeys(firstName + " " + lastName);
        phoneNo.sendKeys(phoneNumber);
        email.sendKeys(emailAdress);
    }
//}

    //class TestMotoScuterRegistration {
    @Test
    public void testRegistration() {

        driver.get("https://www.moto-scuter.ru/reg/");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterFields("sfdahdfsdjhs", "fasbdhfvwuJH312",
                "sfdhsd", "sdfdhffaaw", "6615478545",
                "sdsdsahgb@dflkjg.com");
    }
}