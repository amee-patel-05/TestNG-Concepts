package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**

 */

public class Assertions {
WebDriver a;	

		// Hard Assertions
		@Test
		public void Google() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			
			a = new ChromeDriver(options);
			
			a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			a.get("https://www.google.com/");
			Thread.sleep(2000);
			
			a.manage().window().maximize();
			Thread.sleep(2000);
			
			a.findElement(By.name("q")).sendKeys("HYR Tutorials" , Keys.ENTER);
			Thread.sleep(2000);
			
			String expectedTitle = "HYR Tutorials - Google Search";  //  display the expected title of the page
			
			String actualTitle = a.getTitle();		// display the actual title of the page

			Assert.assertEquals(actualTitle, expectedTitle , "Title is not matched");	// Compare the actual title with expected title ang print the message when test is fail
			
			Assert.assertTrue(true);		//
	
			a.quit();
			
		}
		
		// Soft Assertions
	
		@Test
		public void Login() throws InterruptedException {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

			a = new ChromeDriver(options);

			a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			a.get("https://demo.nopcommerce.com/");
			Thread.sleep(2000);

			a.manage().window().maximize();
			Thread.sleep(2000);

			a.findElement(By.linkText("Log in")).click();
			Thread.sleep(2000);

			a.findElement(By.id("Email")).sendKeys("ameepatel068@gmail.com");
			Thread.sleep(3000);

			a.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
			Thread.sleep(2000);

			SoftAssert softAssert = new SoftAssert();

			// Title Assertion
			String actualTitle = a.getTitle();
			String expectedTitle = "nopCommerce demo store"; // nopCommerce demo store. Login
			softAssert.assertEquals(actualTitle, expectedTitle, "Title is not matched");

			//URL Assertion
			String actualURL = a.getCurrentUrl();
			String expectedURL = "https://demo.nopcommerce.com/login?returnurl=%2F";
			softAssert.assertNotEquals(actualURL, expectedURL, "URL is not matched");

			//Text Assertion

			String actualText = a.findElement(By.id("Email")).getAttribute("value");
			String expectedText = "ameepatel068@gmail.com";
			softAssert.assertEquals(actualText, expectedText, "Username Text is not matched");

			// Border Assertion

			String actualBorder = a.findElement(By.id("Email")).getCssValue("border");
			String expectedBorder = "0.8px solid rgb(204, 204, 204)";
			softAssert.assertEquals(actualBorder, expectedBorder, "Border is not matched");

			//Error message Assertion

			String actualErrorMessage= a.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
			String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again. " +
					                             	      "No customer account found";
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not matched");

			a.close();
			softAssert.assertAll();
		}
	
}




