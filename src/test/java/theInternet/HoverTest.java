package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoverTest {

    WebDriver driver;

    @Test
    void verifyAvatar1Info(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.xpath("//*[@class='figure'][1]")))
                .perform();

        Assert.assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
    }
}
