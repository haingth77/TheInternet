package calculator;

import common.Browser;
import common.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CalculatorPage;

public class BodyMassIndexTest extends TestBase {
    CalculatorPage calculatorPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.open(browser);
        calculatorPage = new CalculatorPage();
        calculatorPage.open();
        calculatorPage.selectMetricTab();
    }

    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {"24", "male", "170", "80", "BMI = 27.7 kg/m2   (Overweight)"},
                {"37", "male", "172", "64", "BMI = 21.6 kg/m2   (Normal)"},
                {"37", "female", "172", "64", "BMI = 21.6 kg/m2   (Normal)"}
        };
    }

    @BeforeMethod(alwaysRun = true)
    void clearUpForm() {
        calculatorPage.cleanUpForm();
    }

    @Test(dataProvider = "testData")
    void validateResult(String age, String gender, String height, String weight, String expectedResult) {
            calculatorPage.fillForm(age, gender, height, weight);
            String result = calculatorPage.getResult();
            Assert.assertEquals(result, expectedResult);
        }

}

