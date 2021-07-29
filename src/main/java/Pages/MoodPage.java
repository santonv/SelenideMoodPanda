package Pages;

import Elements.MeDropDown;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MoodPage extends BasePage {
    public String updateMood = ".navbar-hidesmalla";
    public String MeValue = "//li[@id='LIMe']//a[contains(text(),'%s')]";
    private static final SelenideElement UPDATE_BUTTON = $(By.xpath("//button[contains(@class,'ButtonUpdate')]"));
    private String hugs = "//*[@class='badge mchugs%s']";
    private static final SelenideElement GO_TO_MY_DIARY_BTN = $(By.xpath("//a[contains(@class,'ButtonMyDiary')]"));
    private static final String DELETE_MOOD_BUTTON = "//span[contains(@id,'ButtonDelete_%s')]/span";


    @Step("click on 'Me' and select My updates")
    public MyUpdatesPage clickOnMyUpdatesPage(String label) {
        new MeDropDown(label).write();
        return new MyUpdatesPage();
    }
    @Step("Click on Update Mood button")
    public MyUpdatesPage clickUpdateMoodButton() {
        $$(".navbar-hidesmalla").findBy(text("Update mood")).click();
        return new MyUpdatesPage();
    }
    @Step("Select mood value {valueOfMood} and click on Update button")
    public MyUpdatesPage updateNewMood(int moodPoints, int valueOfMood) {
            if (moodPoints < 5) {
                for (int i = 0; i < valueOfMood; i++) {
                    $(By.xpath("//a[contains(@class,'ui-slider')]")).shouldBe(exist).sendKeys(Keys.ARROW_LEFT);
                }
            }
            else if (moodPoints >= 5) {
                for (int b = 0; b < valueOfMood; b++) {
                    $(By.xpath("//a[contains(@class,'ui-slider')]")).shouldBe(exist).sendKeys(Keys.ARROW_RIGHT);
                }
            }
            UPDATE_BUTTON.click();
            GO_TO_MY_DIARY_BTN.shouldBe(exist).click();
        return new MyUpdatesPage();
        }
    @Step("Get mood value")
    public int getMoodValue() {
        return Integer.valueOf($(UPDATE_BUTTON).shouldBe(visible).getText().split(" ")[3]);
    }

    @Step("Click on send hug button")
    public void sendHug(String moodNumber){
     String selectorHugs = String.format(hugs,moodNumber);
     $(By.xpath(selectorHugs)).click();
    }

    @Step("Delete mood number {numberDeleteButton}")
    public MoodPage deleteMood(String numberDeleteButton){
    $(By.xpath(String.format(DELETE_MOOD_BUTTON,numberDeleteButton))).shouldBe(exist).click();
        return new MoodPage();
    }

}
