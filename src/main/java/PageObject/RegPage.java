package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //поле Имя
    @FindBy(how = How.XPATH,using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameRegisterField;

    //поле Email
    @FindBy(how = How.XPATH,using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailRegisterField;

    //поле Пароль
    @FindBy(how = How.XPATH,using = ".//input[@name = 'Пароль']")
    private SelenideElement passwordRegisterField;

    //ошибка
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordText;

    //кнопка Зарегестрироваться
    @FindBy(how = How.XPATH,using = ".//button[(text() = 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Войти')]")
    private SelenideElement loginButton;

    //заголовок Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement enterText;

    @Step("Нажать на кнопку Войти")
    public LoginPage clickLoginButtonOnRegisterPage() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Отображается сообщение о некорректном пароле")
    public boolean isIncorrectPasswordTextVisible(){
        incorrectPasswordText.shouldBe(visible);
        return true;
    }

    @Step("Успешная регистрация пользователя")
    public LoginPage successRegistrationNewUser() {
        nameRegisterField.setValue(RandomStringUtils.randomAlphabetic(10));
        emailRegisterField.setValue(RandomStringUtils.randomAlphabetic(10) + "@gmail.com");
        passwordRegisterField.setValue(RandomStringUtils.randomAlphabetic(6));
        registerButton.click();
        enterText.shouldBe(visible);
        return page(LoginPage.class);
    }
    @Step("Неуспешная регистрация пользователя")
    public void failRegistrationNewUser() {
        nameRegisterField.setValue(RandomStringUtils.randomAlphabetic(10));
        emailRegisterField.setValue(RandomStringUtils.randomAlphabetic(10) + "@gmail.com");
        passwordRegisterField.setValue(RandomStringUtils.randomAlphabetic(5));
        registerButton.click();
        incorrectPasswordText.shouldBe(visible);
    }
}
