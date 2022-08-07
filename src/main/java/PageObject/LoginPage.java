package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//h2[text() = 'Вход']")
    private SelenideElement headEnter;

    //Поле email
    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    //Поле пароль
    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordField;

    //Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Войти')]")
    private SelenideElement enterButton;

    //Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[(text() = 'Зарегистрироваться')]")
    private SelenideElement regButton;

    //Кнопка восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[(text() = 'Восстановить пароль')]")
    private SelenideElement passwordRecoveryButton;

    //Кнопка офрмить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @Step("Отображается войти")
    public boolean isEnterVisibleButton() {
        enterButton.shouldBe(visible);
        return true;
    }

    @Step("Авторизоваться")
    public void login(String email, String password) {
//        emailField.click();
        emailField.setValue(email);
//        passwordField.click();
        passwordField.setValue(password);
        enterButton.click();
        createOrderButton.shouldBe(visible);
    }
}