package theInternet;

import common.Browser;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import java.time.Duration;

import static common.Browser.*;

public class DynamicallyLoadingTest extends TestBase {
    DynamicLoadingPage dynamicLoadingPage;
    @BeforeClass
    void open() {
        Browser.open("chrome");
        dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
    }

    @Test
    void waitForElementPresentAfterLoadingSuccess() throws InterruptedException{
        dynamicLoadingPage.start();

//        Thread.sleep(5000);// Implicit wait
//        String finishContent = driver.findElement(By.cssSelector("#finish h4")).getText();

        // Explicit wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Assert.assertEquals(dynamicLoadingPage.getSuccessMessage(),"Hello World!");
    }
}
