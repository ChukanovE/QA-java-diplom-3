import PageObject.LoginPage;
import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccTest {
    public UserOperations userOperations;
    Map<String, String> response = new HashMap<>();

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        response = userOperations.register();
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @Test
    @Description("Переход в Личный кабинет")
    public void goToPersonalAccount() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        String actualNameValue = mainPage.getNameValue();
        String expectedName = response.get("name");
        assertEquals("имя пользователя не соответствует",expectedName, actualNameValue);
    }

    @Test
    @Description("Переход из личного кабинета в конструктор по клику на логотип")
    public void goFromPersonalAccountToConstructorClickLogo() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogoButton();
        String actualText = mainPage.getConstructorText();
        String expectedText = "Соберите бургер";
        assertEquals ("заголовок " + expectedText + " не отображается", expectedText, actualText);
    }

    @Test
    @Description("Переход из личного кабинета в конструктор по калику на Конструктор")
    public void goFromPersonalAccountToConstructorClickConstructor() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        String actualText = mainPage.getConstructorText();
        String expectedText = "Соберите бургер";
        assertEquals ("заголовок " + expectedText + " не отображается" , expectedText, actualText);
    }

    @Test
    @Description("Успешный выход из аккаунта")
    public void successLogout() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLogInAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogoutButton();
        assertTrue("заголовок Вход не отображается", mainPage.isEnterTextVisible());
    }
}




