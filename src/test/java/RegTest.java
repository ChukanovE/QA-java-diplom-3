import PageObject.LoginPage;
import PageObject.RegPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegTest {
    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @Test
    @Description("Успешная регистрация")
    public void successRegistration() {
        RegPage registerPage =  open(RegPage.URL, RegPage.class);
        LoginPage loginPage = registerPage.successRegistrationNewUser();
        assertTrue("не удалось пройти регистрацию", loginPage.isEnterVisibleButton());
    }

    @Test
    @Description("Ошибка некорректного пароля")
    public void failRegistration() {
        RegPage registerPage =  open(RegPage.URL, RegPage.class);
        registerPage.failRegistrationNewUser();
        assertTrue("ошибка некорректного пароля не отображается", registerPage.isIncorrectPasswordTextVisible());
    }
}