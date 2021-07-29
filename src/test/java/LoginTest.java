
import com.codeborne.selenide.Condition;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Login Data")
    public Object[][] getData() {
        return new Object[][]{
                {"", PASSWORD,"Error: Could not find account. Forgot Password?"},
                {EMAIL, "","Error: Could not find account. Forgot Password?"},
                {"invalidEmail",PASSWORD,"Error: Could not find account. Forgot Password?"},
                {EMAIL,"invalidPassword","Error: Could not find account. Forgot Password?"}
    };
}

    @Epic("Tests for Login")
    @Feature(value = "Test for Login with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "Login Data")
    public void loginDataShouldBeRequires(String eMail, String password, String errorMessage){
        open("login");
        loginPage.Login(eMail,password);
        $(By.xpath("//div[contains(@class,'alert-dis')]")).shouldHave(Condition.text(errorMessage));
    }

    @Epic("Tests for Login")
    @Feature(value = "Test for Login with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginWithValidDataTest(){
        open("login");
        loginPage.Login(EMAIL,PASSWORD);
        $(".navbar-hidesmalla").shouldBe(Condition.exist);
        moodPage.clickOnMyUpdatesPage("My updates");
    }
}
