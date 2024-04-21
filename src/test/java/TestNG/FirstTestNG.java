package TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Two test method for two different page

public class FirstTestNG {
	
	@Test
	public void TestMethodOrangeHRM() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	
		WebDriver a = new ChromeDriver();
		
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		
		a.manage().window().maximize();
		Thread.sleep(1000);
		
		System.out.println("Title of the page: " +a.getTitle());
		Thread.sleep(2000);
		
		a.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(1000);
		
		a.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);

		WebElement login = a.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		login.submit();
		Thread.sleep(5000);
		
		a.close();
	}
	
	@Test
	public void TestMethodToolsQA() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	
		WebDriver a = new ChromeDriver();
		
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		a.get("https://demoqa.com/login");
		Thread.sleep(1000);
		
		a.manage().window().maximize();
		Thread.sleep(1000);
		
		System.out.println("Title of the page: " +a.getTitle());
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor)a;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		
		a.findElement(By.id("userName")).sendKeys("ameepatel251@gmail.com");
		Thread.sleep(1000);
		
		a.findElement(By.id("password")).sendKeys("Amee@5597");
		Thread.sleep(1000);

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		
		a.findElement(By.id("login")).click();
		Thread.sleep(5000);

		System.out.println("Successfully executed TestNG");
		a.close();

		
	}

}
