package todomvc;

import common.Browser;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TodoMvcPage;

public class TodoMVCTest extends TestBase {
    TodoMvcPage todoMvcPage;

    @BeforeClass
    void setup() {
        Browser.open("chrome");
        todoMvcPage = new TodoMvcPage();
        todoMvcPage.open();
    }

    @Test
    void createNewTodoSuccessfull() {
        int numberTodoListBefore = todoMvcPage.getTodoListSize();
        int countItemBefore = todoMvcPage.getItemLeft();
        todoMvcPage.createNewTask("task 1");
        int numberTodoListAfter = todoMvcPage.getTodoListSize();
        int countItemAfter = todoMvcPage.getItemLeft();
        Assert.assertTrue(todoMvcPage.isTaskDisplayed("task 1"));
        Assert.assertEquals(numberTodoListAfter - numberTodoListBefore, 1);
        Assert.assertEquals(countItemAfter - countItemBefore, 1);
    }

    @Test
    void markATodoCompleted() {
        todoMvcPage.createNewTask("task 1");
        todoMvcPage.markCompleted("task 1");
        todoMvcPage.selectTabView("Completed");
        Assert.assertTrue(todoMvcPage.isTaskDisplayed("task 1"));
    }

    @Test
    void deleteATodoSuccessfully() {
        todoMvcPage.createNewTask("task 1");
        int numberTodoListBefore = todoMvcPage.getTodoListSize();
        todoMvcPage.delete("task 1");
        int numberTodoListAfter = todoMvcPage.getTodoListSize();
        Assert.assertEquals(numberTodoListBefore - numberTodoListAfter, 1);
    }

    @Test
    void editTodoSuccessfully() {
        todoMvcPage.createNewTask("task 1");
        todoMvcPage.renameTask("task 1", "task 2");
        Assert.assertTrue(todoMvcPage.isTaskDisplayed("task 2"));
    }
}
