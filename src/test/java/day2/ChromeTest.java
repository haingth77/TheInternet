package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

public class ChromeTest {
//    @Test
//    public static void validatePageUrl() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://selenium.dev");
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/");
//        driver.quit();
//    }
//    @Test
//    public static void validatePageUrlWithHeadlessMode() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless=new");
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.get("https://selenium.dev");
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.selenium.dev/");
//        driver.quit();
//    }

//    public static void main(String[] args) {
//        Map<String, Object> deviceMetrics = new HashMap<>(); //Ti le ngang, doc cua man hinh
//        deviceMetrics.put("width", 390);
//        deviceMetrics.put("height", 844);
//        deviceMetrics.put("pixelRatio", 1.0);                   //Phan tram pixel
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceMetrics", deviceMetrics);
//        mobileEmulation.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safar");
//            //userArgent: mo devtool->network-> kiem userAgent
//        ChromeOptions chromeOptions = new ChromeOptions();
//
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.get("https://google.com");
//    }
//
//    @Test
//    void openSeleniumHomePageAndCapturePerformanceMetrics(){
//        ChromeDriver driver = new ChromeDriver();
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//        devTools.send(Performance.enable(Optional.empty()));
//        List<Metric> metricList = devTools.send(Performance.getMetrics());
//        driver.get("https://selenium.dev");
//
//        Assert.assertEquals(driver.getTitle(),"Selenium");
//        driver.quit();
//
//        for(Metric m : metricList) {
//            System.out.println(m.getName() + " = " + m.getValue());
//        }
//
//    }
//    @Test
//    void fakeGeoLocation(){
//        WebDriver driver = new ChromeDriver();
//        DevTools devTools = ((HasDevTools) driver).getDevTools();
//        devTools.createSession();
//        devTools.send(Emulation.setGeolocationOverride(Optional.of(30.3079823),
//                Optional.of(-97.893803),
//                Optional.of(1)));
//
//        driver.get("https://oldnavy.gap.com/stores");
//    }

    @Test
    void captureRequests(){
        WebDriver driver = new ChromeDriver();
        DevTools devTool = ((HasDevTools) driver).getDevTools();

        devTool.createSession();
        devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTool.addListener(Network.requestWillBeSent(), requestSent -> {
            System.out.println("Request URL => " + requestSent.getRequest().getUrl());
            System.out.println("Request Method => " + requestSent.getRequest().getMethod());
            System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());
            System.out.println("------------------------------------------------------");
        });

        devTool.addListener(Network.responseReceived(), responseReceieved -> {
            System.out.println("Response Url => " + responseReceieved.getResponse().getUrl());
            System.out.println("Response Status => " + responseReceieved.getResponse().getStatus());
            System.out.println("Response Headers => " + responseReceieved.getResponse().getHeaders().toString());
            System.out.println("Response MIME Type => " + responseReceieved.getResponse().getMimeType().toString());
            System.out.println("------------------------------------------------------");
        });

        driver.get("https://selenium.dev");
    }
}
