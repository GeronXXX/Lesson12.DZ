package guru.qa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {
    private static final String Repository = "GeronXXX/Lesson10.Files";
   private static final SelenideElement headerSearchInput = $(".header-search-input");
   private static final SelenideElement repository = $(linkText(Repository));
   private static final SelenideElement IssuesTab = $("#issues-tab");
   private static final SelenideElement VerificationText  = $(".container-md");
    @DisplayName("2. Lambda steps through step (name, () -> {})")
    @Test
    public void testLambda() {
        step("Opening the main page", () -> {
            open("https://github.com/");
        });
        step("Looking for a repository" + Repository, () -> {
            headerSearchInput.setValue(Repository);
            headerSearchInput.pressEnter();
        });
        step("Click on the found repository", () -> {
            repository.click();
        });
        step("Click on the Issues tab", () -> {
            IssuesTab.click();
        });
        step("Checking text on the Issues page", () -> {
            VerificationText.shouldHave(text("Welcome to issues!"));
        });
    }
}