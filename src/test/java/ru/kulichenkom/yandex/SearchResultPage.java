package ru.kulichenkom.yandex;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private ElementsCollection searchedContent = $$("div.content__left > ul");
    private SelenideElement answer = $("div > div.fact-answer.typo.typo_text_xl.typo_line_m.typo_type_bold.fact__answer");
}

