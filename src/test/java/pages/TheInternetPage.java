package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheInternetPage {
    WebDriver driver;
    By checkBox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By checkBox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public TheInternetPage(WebDriver driver) {
        this.driver = driver;
    }


    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public void checkCheckBox(String checkBoxName) {
        if (checkBoxName.equals("checkBox1")) {
            if (!driver.findElement(checkBox1).isSelected()) {
                driver.findElement(checkBox1).click();
            }
        } else {
            if (!driver.findElement(checkBox2).isSelected()) {
                driver.findElement(checkBox2).click();
            }
        }
    }

    public Boolean getCheckBoxStatus1() {
        return driver.findElement(checkBox1).isSelected();
    }

}
