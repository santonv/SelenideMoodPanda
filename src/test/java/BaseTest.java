import Pages.LoginPage;
import Pages.MoodPage;
import Pages.MyUpdatesPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;




import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public static final String EMAIL = "sidorik.a97@gmail.com";
    public static final String PASSWORD = "650065";
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected MoodPage moodPage;
    protected MyUpdatesPage myUpdatesPage;

    @BeforeMethod
    public void setUP() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://moodpanda.com/";
        loginPage = new LoginPage();
        moodPage = new MoodPage();
        myUpdatesPage = new MyUpdatesPage();
    }

    @AfterMethod
    public void tearDown(){
        getWebDriver().quit();
    }
}
