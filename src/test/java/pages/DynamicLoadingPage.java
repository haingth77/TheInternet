package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static common.Browser.*;

public class DynamicLoadingPage {
    By startButton = By.xpath("//button[.='Start']");
    public void open() {
        visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }
    public void start() {
        click(startButton);
    }
    public String getSuccessMessage() {
        String finishContent =  Browser.wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.cssSelector("#finish h4")))
                .getText();
        return finishContent;
    }
}
