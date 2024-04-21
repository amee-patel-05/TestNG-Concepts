package TestNG.Annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AnnotationsPage {
    WebDriver a;
    JavascriptExecutor js = (JavascriptExecutor) a;

    @BeforeTest
    public void InatializeBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        a = new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.manage().window().maximize();
        Thread.sleep(2000);

        System.out.println("Before Test executed");
    }

    @Test
    public void NavigateToPage() throws InterruptedException {
        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

    }

    @Test
    public void LoginDetails() throws InterruptedException
    {
        a.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(1000);

        a.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);

        WebElement login = a.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        login.submit();
        Thread.sleep(4000);

        System.out.println("Successfully executed LoginDetails method\n");
    }

    @Test
    public void NavigateToMyInfo() throws InterruptedException
    {
        //a.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
        //a.findElement(By.xpath("//span[text()='My Info']")).click();
        //a.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[6]")).click();
        a.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[6]")).click();
        Thread.sleep(4000);

        System.out.println("Successfully executed  NavigateToMyInfo method\n");
    }

    @Test
    public void VerifyMyInfo() throws InterruptedException
    {
        System.out.println(a.findElement(By.xpath("(//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding'])[1]")).isDisplayed());
        Thread.sleep(4000);

        System.out.println("Successfully executed  VerifyMyInfo method");
    }

    @AfterTest   // @AfterMethod is used when you have to close the web page after each Test method
    public void EndPage()
    {
        System.out.println("After Test executed");
        a.close();
    }

}