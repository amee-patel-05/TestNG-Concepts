package TestNG.Annotations;

import org.testng.annotations.*;

// Sample Annotations example

public class Annotations1 {

    @Test
    public void AnnotationTestMethod()
    {
        System.out.println("Display the annotation test method");
    }

    @BeforeTest
    public void BeforeTest()
    {
        System.out.println("Display the Before test");
    }

    @AfterTest
    public void AfterTest()
    {
        System.out.println("Display the After test");
    }

    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("Display the Before method");
    }

    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("Display the After method");
    }

    @BeforeClass
    public void BeforeClass()
    {
        System.out.println("Display the Before class");
    }

    @AfterClass
    public void AfterClass()
    {
        System.out.println("Display the After class");
    }

    @BeforeSuite
    public void BeforeSuite()
    {
        System.out.println("Display the Before suite");
    }

    @AfterSuite
    public void AfterSuite()
    {
        System.out.println("Display the After suite");
    }
}

