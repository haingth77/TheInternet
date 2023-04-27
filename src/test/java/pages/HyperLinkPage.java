package pages;

import common.Browser;
import org.openqa.selenium.By;

public class HyperLinkPage {
    By hyperLink200 = By.xpath("//a[@href='status_codes/200']");
    By hyperLink301 = By.xpath("//a[@href='status_codes/301']");
    By hyperLink404 = By.xpath("//a[@href='status_codes/404']");
    By hyperLink500 = By.xpath("//a[@href='status_codes/500']");
    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickOn200() {
        Browser.click(hyperLink200);
    }
    public void clickOn301() {
        Browser.click(hyperLink301);
    }
    public void clickOn404() {
        Browser.click(hyperLink404);
    }
    public void clickOn500() {
        Browser.click(hyperLink500);
    }
}
