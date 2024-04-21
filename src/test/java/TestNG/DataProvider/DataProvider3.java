package TestNG.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

// User the Data Supplier 3 class to read the Excel file for login details

public class DataProvider3 {
    WebDriver a;

    @Test(dataProvider = "LoginDetails" , dataProviderClass = DataSupplier3.class)
    public void Login(String userName, String Password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        options.addArguments("--remote-allow-origins=*");

        a = new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        a.manage().window().maximize();
        Thread.sleep(2000);

        a.findElement(By.name("username")).sendKeys(userName);
        Thread.sleep(1000);

        a.findElement(By.name("password")).sendKeys(Password);
        Thread.sleep(1000);

        WebElement login = a.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        login.submit();
        Thread.sleep(2000);

        System.out.println("login successfully done: "+a.findElement(By.xpath("(//p[@class='oxd-userdropdown-name'])")).isDisplayed());

        a.close();
    }

}
