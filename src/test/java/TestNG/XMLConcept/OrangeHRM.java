package TestNG.XMLConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Use OrangeHRM.xml file

public class OrangeHRM {
	WebDriver a;
	
	@Test
	public void LaunchApp() throws InterruptedException
	{
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
		
		System.out.println("Title of the page : "+a.getTitle());
		Thread.sleep(2000);

		System.out.println("Successfully executed Launchapp method");
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

		System.out.println("Successfully executed LoginDetails method");
	}
	
	@Test
	public void NavigateToMyInfo() throws InterruptedException
	{
		//a.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
		//a.findElement(By.xpath("//span[text()='My Info']")).click();
		//a.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[6]")).click();
		a.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[6]")).click();
		Thread.sleep(4000);

		System.out.println("Successfully executed  NavigateToMyInfo method");
	}
	
	@Test
	public void VerifyMyInfo() throws InterruptedException
	{
		System.out.println(a.findElement(By.xpath("(//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding'])[1]")).isDisplayed());
		Thread.sleep(4000);

		System.out.println("Successfully executed  VerifyMyInfo method");
	}
	
	@Test
	public void VerifyLogin() throws InterruptedException
	{
		WebElement login = a.findElement(By.xpath("(//p[@class='oxd-userdropdown-name'])"));
		System.out.println(login.isDisplayed());
		Thread.sleep(2000);
		System.out.println(login.getText()); 
		Thread.sleep(2000);

		System.out.println("Successfully executed  VerifyLogin method\n");
	}
	
	@Test
	public void NavigateToAdmin() throws InterruptedException
	{
		a.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")).click();
		Thread.sleep(3000);

		System.out.println("Successfully executed  NavigateToAdmin method");
	}
	
	@Test
	public void UserManagement() throws InterruptedException
	{
		a.findElement(By.xpath("//li[contains(@class, '--visited')]")).click();
		Thread.sleep(2000);

		System.out.println("Successfully executed  UserManagement method");
	}

	@Test
	public void ClickOnUser() throws InterruptedException
	{
		a.findElement(By.xpath("//a[text()='Users']")).click();
		Thread.sleep(2000);

		System.out.println("Successfully executed  ClickOnUser method");

	}
	
	@Test
	public void VerifyUsersDetails() throws InterruptedException 
	{
		System.out.println(a.findElement(By.xpath("(//div[@class='orangehrm-container'])\n")).isDisplayed());
		Thread.sleep(2000);

		System.out.println("Successfully executed  VerifyUsersDetails method");

	}

	@Test
	public void CloseMethod()
	{
		a.close();
	}
}
