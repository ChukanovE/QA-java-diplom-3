package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.page;

public class RecoverPasswordPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка Войти
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Войти')]")
    private SelenideElement loginButton;

    @Step("Нажать на кнопку Войти")
    public LoginPage clickLoginOnRecoverPasswordPage() {
        loginButton.shouldBe(exist).click();
        return page(LoginPage.class);
    }
}