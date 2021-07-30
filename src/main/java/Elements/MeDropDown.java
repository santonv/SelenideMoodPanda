package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class MeDropDown {

    String label;
    String meButton = "//li[@id='LIMe']";
    String locatorDropDown = "//li[@id='LIMe']//a[contains(text(),'%s')]";

    public MeDropDown(String label) {
        this.label = label;
    }

    public void write (){
        $(By.xpath(meButton)).click();
        $(By.xpath(String.format(locatorDropDown,label))).click();



    }
}
