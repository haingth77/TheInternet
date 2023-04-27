package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static common.Browser.*;

public class CalculatorPage {
    By metricTab = By.xpath("//a[.='Metric Units']");
    By ageTextBox = By.id("cage");
    By maleCheckBox = By.xpath("//label[@for='csex1']/span[@class='rbmark']");
    By femaleCheckBox = By.xpath("//label[@for='csex2']/span[@class='rbmark']");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By calculatorButton = By.xpath("//input[@value='Calculate']");
    By resultLabel = By.xpath("//div[@class='bigtext']");
    By cleanButton = By.className("clearbtn");


    public void open() {
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab() {
        click(metricTab);
    }

    public void fillForm(String age, String gender, String height, String weight) {
        Browser
                .wait
                .until(ExpectedConditions.visibilityOfElementLocated(ageTextBox)).sendKeys(age);
        if (gender.equals("male")) {
            check(maleCheckBox);
        } else {
            check(femaleCheckBox);
        }
        fill(heightTextBox, height);
        fill(weightTextBox, weight);
        click(calculatorButton);
    }

    public String getResult() {
        return getText(resultLabel);
    }

    public void cleanUpForm() {
        click(cleanButton);
    }
}
