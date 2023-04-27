package pages;

import common.Browser;
import org.openqa.selenium.By;

import static common.Browser.*;

public class FormAuthenticationPage {
    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By submitButton = By.className("radius");
    By successMessageLabel = By.className("success");
    public void open(){
        visit("https://the-internet.herokuapp.com/login");
    }
    public void signIn(String username, String password){
        fill(usernameTextBox,username);
        fill(passwordTextBox,password);
        click(submitButton);
    }
    public String getSuccessMessage() {
        return  getText(successMessageLabel);
    }
}
