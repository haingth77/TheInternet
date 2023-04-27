package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest {
    WebDriver driver;
    List<Person> persons;
    double largeDue = 0;
    int rowOrderLargestDue =0;

    @BeforeClass
    void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        persons = rows.stream().map(row -> {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = cells.get(1).getText();
            String lastName = cells.get(0).getText();
            double due = Double.parseDouble(cells.get(3).getText().replace("$",""));
            return new Person(firstName,lastName,due);
        }).collect(Collectors.toList());
    }
    @Test
    void validLargestDuePerson() {
//       List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
//       cells.forEach(cell -> {
//           System.out.println(cell.getText());
//       });
//       List<WebElement> firstRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
//       firstRow.forEach(cell -> System.out.println(cell.getText()));
//
//       List<WebElement> dueRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
//       dueRow.forEach(due -> System.out.println(due.getText()));
        Assert.assertEquals(
                persons
                        .stream()
                        .max(Comparator.comparing(Person::getDue)).orElseThrow().getFullName(),"Jason Doe");
    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}

//---------------------Doan nay Hai lam, code da chay thanh cong--------------------------------------------------------------------------------------------------//
//    List<WebElement> dueValue = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
//        for (int i=0; i<4; i++) {
//        double parseDue = Double.parseDouble(dueValue.get(i).getText().replace("$",""));
//        if (largeDue < parseDue) {
//        largeDue = parseDue;
//        rowOrderLargestDue = i+1;
//        }
//        }
//        String firstnameLargeDue = (tableTest.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]",rowOrderLargestDue))).getText());
//        String lastNameLargeDue = (tableTest.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]",rowOrderLargestDue))).getText());
//        Assert.assertEquals(String.format("%s %s",firstnameLargeDue, lastNameLargeDue),"Doe Jason");
//        driver.quit();
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------//