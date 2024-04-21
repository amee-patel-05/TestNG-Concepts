package TestNG.ParallelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTest2 {
    WebDriver a;

    @Test
    public void LoginDetails() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        options.addArguments("--remote-allow-origins=*");

        a = new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        a.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(1000);

        a.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);

        WebElement login = a.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        login.submit();
        Thread.sleep(4000);

        Assert.assertEquals(a.getTitle(), "OrangeHRM");
        Thread.sleep(5000);

        System.out.println("Title of the page is matched");
    }

    @AfterTest
    public void teardown(){
        a.close();
    }
}
