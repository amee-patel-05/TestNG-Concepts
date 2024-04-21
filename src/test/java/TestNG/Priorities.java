package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Priorities {

    // LaunchApp, RegisterUser, LoginUser, SearchTheProduct, AddToCart, SignOut
    WebDriver a;
    JavascriptExecutor js = (JavascriptExecutor) a;

    @Test(priority=0)
    public void LaunchApp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        options.addArguments("--remote-allow-origins=*");

        a = new ChromeDriver(options);

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://demo.nopcommerce.com/");
        Thread.sleep(2000);

        a.manage().window().maximize();
        Thread.sleep(2000);

        System.out.println("Title of the page : "+a.getTitle());
        Thread.sleep(2000);

        System.out.println("Launchapp method executed");
    }

    @Test(priority=1, enabled = false)
    public void RegisterUser() throws InterruptedException {

        a.findElement(By.linkText("Register")).click();
        Thread.sleep(2000);

        System.out.println("URL of the page: "+a.getCurrentUrl());

        WebElement details = a.findElement(By.id("gender-female"));
       /* js.executeScript("arguments[0].scrollIntoView", details);
        Thread.sleep(2000);*/

        details.click();
        Thread.sleep(2000);

        a.findElement(By.name("FirstName")).sendKeys("Amee");
        Thread.sleep(2000);

        a.findElement(By.id("LastName")).sendKeys("Patel");
        Thread.sleep(2000);

        WebElement day = a.findElement(By.name("DateOfBirthDay"));
        Select Bday = new Select(day);
        Bday.selectByValue("5");
        Thread.sleep(2000);

        WebElement month = a.findElement(By.name("DateOfBirthMonth"));
        Select Bmonth = new Select(month);
        Bmonth.selectByVisibleText("May");
        Thread.sleep(2000);

        WebElement year = a.findElement(By.name("DateOfBirthYear"));
        Select Byear = new Select(year);
        Byear.selectByValue("1997");
        Thread.sleep(2000);

        WebElement mail = a.findElement(By.id("Email"));
        mail.sendKeys("ameepatel251@gmail.com");
        Thread.sleep(2000);

		/*WebElement company = a.findElement(By.id("Company"));
		js.executeScript("arguments[0].scrollIntoView",company);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);*/

        a.findElement(By.id("Password")).sendKeys("Amee@5597");
        Thread.sleep(2000);

        a.findElement(By.name("ConfirmPassword")).sendKeys("Amee@5597");
        Thread.sleep(2000);

        WebElement register = a.findElement(By.id("register-button"));
        register.submit();
        Thread.sleep(2000);

        System.out.println("RegisterUser method executed");
        Thread.sleep(2000);

    }
    @Test(priority=2)
    public void LoginUser() throws InterruptedException {
        a.findElement(By.linkText("Log in")).click();
        Thread.sleep(2000);

        a.findElement(By.id("Email")).sendKeys("ameepatel251@gmail.com");
        Thread.sleep(2000);

        a.findElement(By.name("Password")).sendKeys("Amee@5597");
        Thread.sleep(2000);

        /*js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);*/

        a.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        Thread.sleep(2000);

        System.out.println("Title of the page: "+a.getTitle());
        Thread.sleep(2000);

        System.out.println("LoginUser method executed");
    }

    @Test(priority=3)
    public void SearchTheProduct() throws InterruptedException {

        WebElement electronics = a.findElement(By.linkText("Electronics"));  // Mouse hover on the Electronics tab
        electronics.click();
        Thread.sleep(2000);

        a.findElement(By.linkText("Cell phones")).click(); // Click on the Cell phones button
        Thread.sleep(2000);

        a.findElement(By.linkText("List")).click();         // Click on the View mode List items
        Thread.sleep(1000);

        WebElement sortby = a.findElement(By.id("products-orderby"));
        Select sort = new Select(sortby);
        sort.selectByValue("10");        // Select the price low to high sorting option

        a.findElement(By.xpath("//a[@class='product-picture']")).click();       // CLick on  the phone
        //a.findElement(By.tagName("a")).click();
        Thread.sleep(2000);

        System.out.println("Display the Selected Mobile Phone Details: "+a.findElement(By.xpath("(//div[@class='overview'])[1]")).isDisplayed());
        Thread.sleep(2000);

        System.out.println("Search The Product method Executed");
        Thread.sleep(2000);
    }

    @Test(priority=4)
    public void AddToCart() throws InterruptedException {

        a.findElement(By.id("add-to-cart-button-18")).click();  // CLick on the Add to Cart
        Thread.sleep(1000);

        a.findElement(By.linkText("Shopping cart")).click();  // Click on the shopping cart menu
        Thread.sleep(1000);

        System.out.println("Display the Added device details:  "+a.findElement(By.xpath("//div[@class='table-wrapper']")).isDisplayed());

        System.out.println("Add To Cart method executed");
    }

    @Test(priority=5)
    public void SignOut(){

        a.close();

        System.out.println("Signout method executed");
    }
}
