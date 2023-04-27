package theInternet;

import common.Browser;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HyperLinkPage;

import static common.Browser.*;


public class HyperLinkTest extends TestBase {
    HyperLinkPage hyperLink;

    @BeforeClass
    void open() {
        Browser.open("chrome");
        hyperLink = new HyperLinkPage();
        hyperLink.open();
    }

    @Test
    void ValidationHyperLinkChanged() {
        hyperLink.open();
        hyperLink.clickOn200();
        Assert.assertEquals(Browser.currentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        navigateBack();
        //
        hyperLink.clickOn301();
        Assert.assertEquals(Browser.currentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        navigateBack();
        //
        hyperLink.clickOn404();
        Assert.assertEquals(Browser.currentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        navigateBack();            /*Cung chuc nang giong dong: driver.findElement(By.xpath("//a[@href='/status_codes']")).click(); */
        //
        hyperLink.clickOn500();
        Assert.assertEquals(Browser.currentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        navigateBack();
    }
}
