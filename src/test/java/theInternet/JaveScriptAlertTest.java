package theInternet;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;

public class JaveScriptAlertTest {
    JavaScriptAlertPage javaScriptAlert;
    @BeforeClass
    void setup() {
        Browser.open("chrome");
        javaScriptAlert = new JavaScriptAlertPage();
        javaScriptAlert.open();
    }

    @Test
    void clickOnJSAlertButton() {
        javaScriptAlert.clickOnJSAlert();
        Browser.acceptAlert("");
        Assert.assertEquals(javaScriptAlert.getResultContent(),"You successfully clicked an alert");
    }

    @Test
    void clickOnJSConfirmButton() {
        javaScriptAlert.clickOnJSConfirm();
        Browser.acceptAlert("");
        Assert.assertEquals(javaScriptAlert.getResultContent(),"You clicked: Ok");
    }

    @Test
    void clickOnJSAlertPrompt() {
        javaScriptAlert.clickOnJSPrompt();
        String inputContext = "hello";
        Browser.acceptAlert(inputContext);
        String expectResult = "You entered: " + inputContext;
        Assert.assertEquals(javaScriptAlert.getResultContent(),expectResult);
    }
}
