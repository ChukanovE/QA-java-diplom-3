import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MainPageTest {
    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @Test
    @Description("Переход к разделу Булки")
    public void goToBun() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickFillingsButton();
        mainPage.clickBunButton();
        assertTrue("раздел Булки не отображается", mainPage.isIngredientsListBunVisible());
    }

    @Test
    @Description("Переход к разделу Соусы")
    public void goToSauces() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickSaucesButton();
        assertTrue("раздел Соусы не отображается", mainPage.isIngredientsListSauceVisible());
    }

    @Test
    @Description("Переход к разделу Начинки")
    public void goToFilling() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickFillingsButton();
        assertTrue("раздел Начинки не отображается", mainPage.isIngredientsFillingVisible());
    }
}