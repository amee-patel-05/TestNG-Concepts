package TestNG.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OptionalParameters {

    WebDriver a;
    //JavascriptExecutor js = (JavascriptExecutor) a;

    @Parameters("browserName")
    @BeforeTest
    public void InitializeBrowser(@Optional("chrome") String browserName) throws InterruptedException {
        switch(browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                a = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                a = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                a = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser is not valid");
                break;
        }

        a.manage().window().maximize();
        Thread.sleep(2000);

        System.out.println("Before Test executed");
    }

    @Parameters("url")
    @Test
    public void NavigateToPage(String url) throws InterruptedException {
        a.get(url);
        Thread.sleep(2000);

    }

    @Parameters({"username" , "password"})
    @Test
    public void LoginDetails(String username, String password) throws InterruptedException
    {
        a.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(1000);

        a.findElement(By.name("password")).sendKeys(password);
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
        boolean actualValue = a.findElement(By.xpath("(//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding'])[1]")).isDisplayed();
        Assert.assertTrue(actualValue);
        Thread.sleep(4000);

        System.out.println("Successfully executed  VerifyMyInfo method");
    }

    @Test
    public void VerifyLogin() throws InterruptedException
    {
        WebElement login = a.findElement(By.xpath("(//p[@class='oxd-userdropdown-name'])"));
        Assert.assertTrue(login.isDisplayed());
        Thread.sleep(2000);
        System.out.println(login.getText());
        Thread.sleep(2000);

        System.out.println("Successfully executed  VerifyLogin method\n");
    }

    @AfterTest
    public void EndPage()
    {
        System.out.println("After Test executed");
        a.close();
    }
}
