package guru.qa;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class PageObgects {

    @Step("Opening the main page")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Looking for a repository")
    public void searchForRepository(String repo) {
        $(".header-search-input").setValue(repo);
        $(".header-search-input").pressEnter();
    }
    @Step("Click on the found repository")
    public void repository(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Click on the Issues tab")
    public void issuesTab() {
        $("#issues-tab").click();
    }
    @Step("Checking text on the Issues page")
    public void verificationText(String repo) {
        $(".container-md").shouldHave(text(repo));
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}