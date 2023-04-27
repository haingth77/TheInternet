package theInternet;

import common.Browser;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormAuthenticationPage;

import static common.Browser.*;

public class formAuthenticationTest extends TestBase {
    FormAuthenticationPage formAuthenticationPage;
//    Form  Authentication
//    Login successful with valid credentials
//    Open browser
//    Navigate to https://the-internet.herokuapp.com/login
//    Fill in username with tomsmith
//    Fill in the password with SuperSecretPassword!
//    Click on Login button
//    And the home page is appear
    @BeforeClass
    void openBrowser() {
        open("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
    }
    @Test
    void loginSuccessfullyWithValidCredentials() {
        formAuthenticationPage.signIn("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(formAuthenticationPage.getSuccessMessage().contains("You logged into a secure area"));
        Assert.assertEquals(Browser.currentUrl(),"https://the-internet.herokuapp.com/secure");
    }
}
