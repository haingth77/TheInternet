package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import pages.TodoMvcPage;

public class TestBase {
    @AfterMethod(alwaysRun = true)
    public void captureScreenWhenFail(ITestResult result) {
        if (!result.isSuccess()) {
            Browser.captureScreen(result.getName());
        }
    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Browser.close();
    }
}
