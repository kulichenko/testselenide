package ru.kulichenkom.youtube;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.*;

public class YoutubeTest {
    @CsvSource({
            "Paw patrol, Paw patrol",
            "Paw patrol, Paw bone"
    })

    @ParameterizedTest
    public void testSearchVideoWithoutLogin(String searchingText, String expectedText) {
        open("https://www.youtube.com/", SearchPage.class)
                .searchVideo(searchingText)
                .checkingResults(expectedText);
    }

    @CsvSource({
            "Paw patrol, Paw patrol, ivan1524215632145@gmail.com, Aaabbb15",
            "Paw patrol, Paw bone, ivan1524215632145@gmail.com, Aaabbb15"
    })

    @ParameterizedTest
    public void testSearchVideoWithLogin(String searchingText, String expectedText, String userName, String password) {
        open("https://www.youtube.com/", SearchPage.class)
                .login(userName, password)
                .searchVideo(searchingText)
                .checkingResults(expectedText);
    }

    @AfterEach
    void closeBrowser() {
        Selenide.close();
    }
}