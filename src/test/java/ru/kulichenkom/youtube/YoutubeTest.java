package ru.kulichenkom.youtube;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.*;

public class YoutubeTest {
    @CsvSource({
            "Paw patrol, Paw patrol, ivan1524215632145@gmail.com, Aaabbb15",
            "Paw patrol, Paw patrol,,",
            "Paw patrol, Paw bone,,",
            "Paw patrol, Paw bone, ivan1524215632145@gmail.com, Aaabbb15"
    })

    @ParameterizedTest
    public void testSearchVideo(String searchingTexet, String expectedText, String userName, String password) {
        open("https://www.youtube.com/", SearchPage.class)
                .login(userName, password)
                .searchVideo(searchingTexet)
                .checkingResults(expectedText);
    }
}