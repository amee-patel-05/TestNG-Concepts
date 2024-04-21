package TestNG.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

// Parallel execution of the test data

public class DataProvider4 {

    WebDriver a;

    @Test(dataProvider = "LoginDetails")
    public void Login(String userName, String Password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        options.addArguments("--remote-allow-origins=*");

        a = new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

//        a.manage().window().maximize();
//        Thread.sleep(2000);

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

    @DataProvider(name = "LoginDetails" , parallel = true)
    public Object[][] LoginData() throws InterruptedException {
        Object[][] data = new Object[5][2];
        data[0][0] = "Admin123";
        data[0][1] = "admin123123";

        Thread.sleep(1000);

        data[1][0] = "Admin";
        data[1][1] = "test123";

        Thread.sleep(1000);

        data[2][0] = "Admin12";
        data[2][1] = "admin123";

        Thread.sleep(1000);

        data[3][0] = "Admin";
        data[3][1] = "admin123";

        Thread.sleep(1000);

        data[4][0] = " ";
        data[4][1] = " ";

        return data;
    }
}
