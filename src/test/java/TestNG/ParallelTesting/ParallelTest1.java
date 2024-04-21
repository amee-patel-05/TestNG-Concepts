package TestNG.ParallelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTest1 {
    WebDriver a;

    @Test
    public void LogoTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        a= new ChromeDriver();

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

//        a.manage().window().maximize();
//        Thread.sleep(2000);

        WebElement logo = a.findElement(By.xpath("//img[@alt='orangehrm-logo']"));
        System.out.println("Logo is display or not: "+logo.isDisplayed());
        Thread.sleep(5000);

    }

    @Test
    public void TitleOfPage() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();

        a= new ChromeDriver();

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

//        a.manage().window().maximize();
//        Thread.sleep(2000);

        Assert.assertEquals(a.getTitle(), "OrangeHRM");
        Thread.sleep(5000);

        System.out.println("Title of the page is matched");
    }

    @AfterTest
    public void teardown(){
        a.close();
    }

}
