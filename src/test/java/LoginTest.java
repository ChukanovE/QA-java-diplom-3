import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RecoverPasswordPage;
import PageObject.RegPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    public  UserOperations userOperations;
    Map<String, String> response = new HashMap<>();

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        response = userOperations.register();
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginClickButtonLoginInAccountOnMainPage() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLogInAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        assertTrue("кнопка Оформить заказ не отображается", mainPage.isOrderButtonVisible());
    }

    @Test
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginClickButtonPersonalAccountOnMainPage() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        assertTrue("кнопка Оформить заказ не отображается", mainPage.isOrderButtonVisible());
    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void loginClickButtonInRegisterPage() {
        RegPage registerPage =  open(RegPage.URL, RegPage.class);
        LoginPage loginPage = registerPage.clickLoginButtonOnRegisterPage();
        loginPage.login(response.get("email"),response.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue("кнопка Оформить заказ не отображается", mainPage.isOrderButtonVisible());
    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void loginClickButtonOnRecoverPasswordPage() {
        RecoverPasswordPage recoverPasswordPage = open(RecoverPasswordPage.URL, RecoverPasswordPage.class);
        LoginPage loginPage = recoverPasswordPage.clickLoginOnRecoverPasswordPage();
        loginPage.login(response.get("email"),response.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue("кнопка Оформить заказ не отображается", mainPage.isOrderButtonVisible());
    }
}