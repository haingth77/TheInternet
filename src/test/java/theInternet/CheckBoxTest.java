package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TheInternetPage;

public class CheckBoxTest {
    WebDriver driver;
    TheInternetPage theInternetPage;

    @BeforeClass
    void openBrowser() {
        driver = new ChromeDriver();
        theInternetPage = new TheInternetPage(driver);
        theInternetPage.open();
    }

    @Test
    void validationCheckSuccess() {
        theInternetPage.checkCheckBox("checkBox1");
        Boolean result = theInternetPage.getCheckBoxStatus1();
        Assert.assertTrue(result);
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
