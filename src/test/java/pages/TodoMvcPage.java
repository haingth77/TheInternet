package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TodoMvcPage {
    public WebDriver driver;

    public TodoMvcPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://todomvc.com/examples/vanillajs/");
    }

    public void createNewTask(String name) {
        driver.findElement(By.className("new-todo")).sendKeys(name, Keys.ENTER);
    }

    public void markCompleted(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format("//label[.='%s']", name)))).perform();
        driver.findElement(By.xpath(String.format("//label[.='%s']/preceding-sibling::input", name))).click();
        driver.findElement(By.linkText("Completed")).click();
    }

    public void delete(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format("//label[.='%s']", name)))).perform();
        driver.findElement(By.xpath(String.format("//label[.='%s']/following-sibling::button", name))).click();
    }

    public void renameTask(String oldName, String newName) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath(String.format("//label[.='%s']", oldName)))).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=''", driver.findElement(By.cssSelector("input.edit")));
        driver.findElement(By.className("new-todo")).sendKeys(String.format("%s", newName), Keys.ENTER);
    }

    public int getTodoListSize() {
        return driver.findElements(By.xpath("//ul[@class='todo-list']/li")).size();
    }

    public int getItemLeft() {
        int itemLeft = 0;
        if (driver.findElement(By.cssSelector(".todo-count strong")).isDisplayed()) {
            itemLeft = Integer.parseInt(driver.findElement(By.cssSelector(".todo-count strong")).getText());
        }
        return itemLeft;
    }

    public boolean isTaskDisplayed(String name) {
        return driver.findElement(By.xpath(String.format("//div[@class='view']/label[.='%s']", name))).isDisplayed();
    }

    public void selectTabView(String tabName) {
        driver.findElement(By.linkText(tabName)).click();
    }

}
