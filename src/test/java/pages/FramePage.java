package pages;

import common.Browser;
import org.openqa.selenium.By;

public class FramePage {
    String frameTop = "frame-top";
    String frameLeft = "frame-left";
    String frameMiddle = "frame-middle";
    String frameRight = "frame-right";
    String frameBottom = "frame-bottom";
    By result = By.xpath("html/body");

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/nested_frames");
    }

    public void switchToFrameLeft() {
        Browser.switchToFrame(frameTop);
        Browser.switchToFrame(frameLeft);
    }

    public void switchToFrameMiddle() {
        Browser.switchToFrame(frameTop);
        Browser.switchToFrame(frameMiddle);
    }

    public void switchToFrameRight() {
        Browser.switchToFrame(frameTop);
        Browser.switchToFrame(frameRight);
    }

    public void switchToFrameBottom() {
        Browser.switchToFrame(frameBottom);
    }

    public String getResult() {
        return Browser.getText(result);
    }
}
