package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    private static final String EMAIL_INPUT = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String PASSWORD_INPUT = "#ContentPlaceHolderContent_TextBoxPassword";
    private static final String LOGIN_BUTTON = "#ContentPlaceHolderContent_ButtonLogin";
    private SelenideElement errorMessage = $(By.xpath("//div[contains(@class,'alert-dis')]"));

    @Step("Input e-mail, password and click login button")
    public MoodPage Login(String mail,String password){
        $(EMAIL_INPUT).sendKeys(mail);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return new MoodPage();
    }

    public String getErrorMessage(){
        return errorMessage.text();
    }
}
