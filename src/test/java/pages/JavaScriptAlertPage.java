package pages;

import common.Browser;
import org.openqa.selenium.By;

public class JavaScriptAlertPage {
    By JSAlertButton = By.xpath("//button[.='Click for JS Alert']");
    By JSAlertConfirmButton = By.xpath("//button[.='Click for JS Confirm']");
    By JSAlertPromptBUtton = By.xpath("//button[.='Click for JS Prompt']");
    By resultContent = By.id("result");

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickOnJSAlert() {
        Browser.click(JSAlertButton);
    }

    public void clickOnJSConfirm() {
        Browser.click(JSAlertConfirmButton);
    }

    public void clickOnJSPrompt() {
        Browser.click(JSAlertPromptBUtton);
    }

    public String getResultContent() {
        return Browser.getText(resultContent);
    }

}
