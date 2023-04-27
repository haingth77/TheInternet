package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class DropDownTest {
    @Test
    void validateOptionSuccess() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/dropdown");
//    driver.findElement(By.xpath("//select[@id='dropdown']")).click();
//    driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).click();
//    Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).isSelected());
//    Select() function
    Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
    dropdown.selectByIndex(2);

}
}
