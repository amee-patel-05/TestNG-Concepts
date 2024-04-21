package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Attributes {
    WebDriver a;

    // time out

    @Test(timeOut = 3000)
    public void TestMethod1(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

        a=new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        a.manage().window().maximize();

        a.close();
    }

    // To check the exception is thrown error or not
    // expectedExceptions attribute

    @Test(expectedExceptions = {NoSuchElementException.class, TimeoutException.class})
    public void TestMethod2(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

        a=new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        a.manage().window().maximize();

        a.findElement(By.id("ABCD")).click();

        a.close();
    }

    // Invocation Count Attribute  to repeat the method such as for loop

    @Test(invocationCount = 5)
    public void TestMethod3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        a= new ChromeDriver();

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://randomuser.me/");
        Thread.sleep(2000);

        a.findElement(By.xpath("//li[@data-label='name']")).click();
        System.out.println("Name is: "+a.findElement(By.id("user_value")).getText());
        Thread.sleep(1000);

        a.findElement(By.xpath("//li[@data-label='email']")).click();
        System.out.println("Email Address is:  "+a.findElement(By.id("user_value")).getText());
        Thread.sleep(1000);

        a.close();
    }

    // Invocation timeout  - assign the time for the test method execution

    @Test(invocationCount = 5, invocationTimeOut = 10000)
    public void TestMethod4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        a= new ChromeDriver();

        a.get("https://randomuser.me/");
        Thread.sleep(2000);

        a.findElement(By.xpath("//li[@data-label='name']")).click();
        System.out.println("Name is: "+a.findElement(By.id("user_value")).getText());
        Thread.sleep(1000);

        a.findElement(By.xpath("//li[@data-label='email']")).click();
        System.out.println("Email Address is:  "+a.findElement(By.id("user_value")).getText());
        Thread.sleep(1000);

        a.close();
    }

    // threadPoolSize attribute is used in invocation  for thread-out

    @Test(invocationCount = 5, threadPoolSize = 2)
    public void TestMethod5() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        a= new ChromeDriver();

        a.get("https://randomuser.me/");
        Thread.sleep(2000);

        a.findElement(By.xpath("//li[@data-label='name']")).click();
        System.out.println("Name is: "+a.findElement(By.id("user_value")).getText());
        Thread.sleep(1000);

        a.findElement(By.xpath("//li[@data-label='email']")).click();
        System.out.println("Email Address is:  "+a.findElement(By.id("user_value")).getText());
        Thread.sleep(1000);

        a.close();
    }


}
