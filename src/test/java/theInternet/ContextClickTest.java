package theInternet;

import common.Browser;
import common.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContextClickPage;

public class ContextClickTest extends TestBase {
    ContextClickPage contextClickPage;

    @BeforeClass
    void open() {
        Browser.open("chrome");
        contextClickPage = new ContextClickPage();
        contextClickPage.open();
    }

    @Test
    void contextClick() {
        contextClickPage.rightClickOnBox();
        Browser.wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
