package common;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Browser {
    private static WebDriver driver;
    private static final int MAXIMUM_TIME_OUT_IN_SECONDS = 30;
    public static WebDriverWait wait;
    public static void open(String browser) {
        switch (browser) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                driver = new EdgeDriver();
                break;
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAXIMUM_TIME_OUT_IN_SECONDS));
    }
    public static void visit(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void captureScreen(String fileName){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./target/screenshot/"
                + fileName
                + "-"
                + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(file, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void rightClick(By locator) {
        Actions actions = new Actions(driver);
        actions
                .contextClick(driver.findElement(locator))
                .perform();
    }
    public static void fill(By locator, String withText){
        driver.findElement(locator).sendKeys(withText);
    }
    public static void click (By locator) {
        driver.findElement(locator).click();
    }
    public static String getText (By locator) {
        return driver.findElement(locator).getText();
    }
    public static String currentUrl () {
        return driver.getCurrentUrl();
    }
    public static void check (By locator) {
        if(!driver.findElement(locator).isSelected()){
            click(locator);
        }
    }
    public static void uncheck (By locator) {
        if(driver.findElement(locator).isSelected()){
            click(locator);
        }
    }
    public static void close() {
        if (driver!=null) {
            driver.quit();
        }
    }

    public static void switchToFrame(String locator) {
        driver.switchTo().frame(locator);
    }
    public static void switchToDefault() {
        if (driver!=null) {
            driver.switchTo().defaultContent();
        }
    }
    public static void navigateBack() {
        if (driver!=null) {
            driver.navigate().back();
        }
    }
    public static void acceptAlert(String inputText) {
        if (inputText=="") {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().sendKeys(inputText);
            driver.switchTo().alert().accept();
        }
    }
    public static void actionHover(By locator) {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(locator))
                .perform();
    }

    public static void wait(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAXIMUM_TIME_OUT_IN_SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String getTextOfWebElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList()).toString();
    }

    public static String getDataFromCsvFile(String fileLoction) throws IOException, CsvValidationException {
        String[] csvCells;
        List<String> provinceNameCsv = new ArrayList<String>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CSVReader readcsv = new CSVReader(new FileReader(fileLoction));

        while ((csvCells = readcsv.readNext()) != null) {
            provinceNameCsv.add(csvCells[0]);
        }
        return provinceNameCsv.toString().replace("\uFEFF","");
    }

}
