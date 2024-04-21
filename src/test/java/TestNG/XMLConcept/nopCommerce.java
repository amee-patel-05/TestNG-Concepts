package TestNG.XMLConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 // Use nopCommerce.xml file

public class nopCommerce {
	WebDriver a ;
	JavascriptExecutor js = (JavascriptExecutor) a;
	
	@Test
	public void LaunchApp() throws InterruptedException
	{
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
	}
	
	@Test
	public void RegisterUser() throws InterruptedException
	{
		a.findElement(By.linkText("Register")).click();
		Thread.sleep(2000);
		
		System.out.println("URL of the page: "+a.getCurrentUrl());
		Thread.sleep(2000);
	}
	
	@Test
	public void PersonalDetails() throws InterruptedException
	{

		WebElement details = a.findElement(By.id("gender-female"));
		js.executeScript("arguments[0].scrollIntoView", details);
		Thread.sleep(2000);
		
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
		
		System.out.println("Successfully register new user");
		Thread.sleep(2000);

	}
	
	@Test
	public void LoginPage() throws InterruptedException
	{
		a.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
	}
	@Test
	public void LoginUser() throws InterruptedException
	{	
		a.findElement(By.id("Email")).sendKeys("ameepatel251@gmail.com");
		Thread.sleep(2000);
		
		a.findElement(By.name("Password")).sendKeys("Amee@5597");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);

		a.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		Thread.sleep(2000);
		
		System.out.println("Title of the page: "+a.getTitle());
		Thread.sleep(2000);

	}
	
	@Test
	public void MyAccount() throws InterruptedException
	{
		WebElement account = a.findElement(By.xpath("//a[@class='ico-account']"));
		account.click();
		Thread.sleep(4000);
		
	}
	
	@Test
	public void VerifyPersonalDetails() throws InterruptedException
	{
		WebElement details = a.findElement(By.xpath("//div[@class='form-fields']"));
		System.out.println(details.isDisplayed());
		Thread.sleep(2000);

	}
	@Test
	public void CloseMethod()
	{
		a.close();
	}
}
