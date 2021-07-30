
import io.qameta.allure.*;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;


public class MoodTest extends BaseTest{

    @Epic("Tests for My updates page")
    @Feature(value = "Test for opening My updates page")
    @Severity(SeverityLevel.MINOR)
    @Story("Open My Updates page")
    @Test
    public void openMyUpdates(){
        open("Login");
        loginPage.Login(EMAIL,PASSWORD);
        moodPage.clickOnMyUpdatesPage("My updates");
        $$(By.xpath("//span[contains(@class,'navbar')]")).findBy(text("Feed")).shouldBe(exist);
    }

    @Epic("Tests for My updates page")
    @Feature(value = "Test for Add new Mood")
    @Severity(SeverityLevel.MINOR)
    @Story("Create new Mood")
    @Test
    public void updateMood(){
        open("login");
        loginPage.Login(EMAIL,PASSWORD);
        moodPage.clickOnMyUpdatesPage("My updates");
        moodPage.clickUpdateMoodButton();
        int value = moodPage.getMoodValue();
        moodPage.updateNewMood(value,3);
        $(By.xpath("//div[contains(@class,'p7675665 media m1')]")).shouldBe(exist).shouldBe(text("8"));
    }

    @Epic("Tests for My updates page")
    @Feature(value = "Test for send Hug")
    @Severity(SeverityLevel.MINOR)
    @Story("Send hug to Mood")
    @Test
    public void clickSendHug(){
        open("login");
        loginPage.Login(EMAIL,PASSWORD);
        moodPage.clickOnMyUpdatesPage("My updates");
        moodPage.sendHug("1");
        $(By.xpath("//*[@class='badge mchugs1']")).shouldBe(text("1"));
    }

    @Epic("Tests for My updates page")
    @Feature(value = "Test for delete Mood")
    @Severity(SeverityLevel.MINOR)
    @Story("Delete Mood")
    @Test
    public void deleteMood(){
        open("login");
        loginPage.Login(EMAIL,PASSWORD);
        moodPage.clickOnMyUpdatesPage("My updates");
        moodPage.deleteMood("0");
    }
}
