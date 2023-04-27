package theInternet;

import common.Browser;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FramePage;

public class FrameTest extends TestBase {
    FramePage framePage;
    @BeforeClass
    void open() {
        Browser.open("chrome");
        framePage = new FramePage();
        framePage.open();
    }

    @BeforeMethod
    void switchToDefault() {
        Browser.switchToDefault();
    }

    @Test
    void validateLeftContent() {
        framePage.switchToFrameLeft();
        System.out.println(framePage.getResult());
        Assert.assertEquals(framePage.getResult(), "LEFT");
    }

    @Test
    void validateMiddleContent() {
        framePage.switchToFrameMiddle();
        System.out.println(framePage.getResult());
        Assert.assertEquals(framePage.getResult(), "MIDDLE");
    }

    @Test
    void validateRightContent() {
        framePage.switchToFrameRight();
        System.out.println(framePage.getResult());
        Assert.assertEquals(framePage.getResult(),"RIGHT");
    }

    @Test
    void validateBottomContent() {
        framePage.switchToFrameBottom();
        System.out.println(framePage.getResult());
        Assert.assertEquals(framePage.getResult(),"BOTTOM");
    }
}

