package theInternet;

import org.testng.annotations.*;

import java.sql.SQLOutput;

public class ExampleTest {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before suite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("Before test");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before method");
    }


    @Test
    void tc01() {
        System.out.println("test 1");
    }

    @Test
    void tc02() {
        System.out.println("test 2");
    }

    @Test
    void tc03() {
        System.out.println("test 3");
    }

    @Test
    void tc04() {
        System.out.println("test 4");
    }

    @Test
    void tc05() {
        System.out.println("test 5");
    }

    @AfterMethod
    void AfterMethod() {
        System.out.println("After method");
    }

    @AfterClass
    void AfterClass() {
        System.out.println("After class");
    }

    @AfterTest
    void AfterTest() {
        System.out.println("After test");
    }

    @AfterSuite
    void AfterSuite() {
        System.out.println("After suite");
    }
}
