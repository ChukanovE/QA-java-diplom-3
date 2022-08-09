import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MainPageTest {
    private final String nameChapter;

    public MainPageTest(String nameChapter) {
        this.nameChapter = nameChapter;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"Булки"},
                {"Соусы"},
                {"Начинки"},
        };
    }

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @Test
    @Description("Переход к разделу")
    public void goToChapter() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickChapter(nameChapter);
        assertTrue("раздел " + nameChapter + " не отображается", mainPage.isNameChapterRespondClickChapter(nameChapter));
    }
}