import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
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
        assertEquals("раздел Булки не отображается","Булки", mainPage.nameChapterVisible());
    }

    @Test
    @Description("Переход к разделу Соусы")
    public void goToSauces() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickSaucesButton();
        assertEquals("раздел Соусы не отображается", "Соусы", mainPage.nameChapterVisible());
    }

    @Test
    @Description("Переход к разделу Начинки")
    public void goToFilling() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickFillingsButton();
        assertEquals("раздел Начинки не отображается", "Начинки", mainPage.nameChapterVisible());
    }
}