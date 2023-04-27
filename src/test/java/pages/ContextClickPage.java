package pages;

import common.Browser;
import org.openqa.selenium.By;

public class ContextClickPage {
    By clickBox = By.id("hot-spot");
    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightClickOnBox() {
        Browser.rightClick(clickBox);
    }

}
