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

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий")
    public void searchForRepository(String repo) {
        $(".header-search-input").setValue(repo);
        $(".header-search-input").pressEnter();
    }
    @Step("Кликаем по найденному репозиторию")
    public void repository(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Кликаем по вкладке Issues")
    public void issuesTab() {
        $("#issues-tab").click();
    }
    @Step("Проверка текста на странице Issues")
    public void verificationText(String repo) {
        $(".container-md").shouldHave(text(repo));
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}