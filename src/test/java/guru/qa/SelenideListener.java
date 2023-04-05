package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListener {
    @DisplayName("Тест - 1. Чистый Selenide (с Listener)")
    @Test
    public void testSelenideListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").setValue("GeronXXX/Lesson10.Files");
        $(".header-search-input").pressEnter() ;
        $(".f4.text-normal").click();
        $("#issues-tab").click();

        $(".container-md").shouldHave(text("Welcome to issues!"));
    }
}