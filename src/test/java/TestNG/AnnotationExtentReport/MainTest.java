package TestNG.AnnotationExtentReport;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MainTest extends BaseTest{

    WebDriver a;
    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "OrangeHRM", groups = {"smoke"})
    public void OrangeHRM() throws InterruptedException
    {
        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

        a.manage().window().maximize();
        Thread.sleep(2000);

        extentTest.info("Navigate to Orange HRM page");

        a.findElement(By.name("username")).sendKeys("Admin123");
        Thread.sleep(1000);

        a.findElement(By.name("password")).sendKeys("admin");
        Thread.sleep(1000);

        WebElement login = a.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        login.submit();
        Thread.sleep(3000);

        // Text Assertion
        String actualText = a.findElement(By.name("username")).getAttribute("value");
        String expectedText = "Admin123";
        softAssert.assertEquals(actualText, expectedText, "Username Text is not matched");
        softAssert.assertAll();

        extentTest.pass("Assertion is pass for OrangeHRM username value ");
    }

    @Test(testName = "ToolsQA", groups = {"sanity", "regression"})
    public void ToolsQA() throws InterruptedException {

        a.get("https://demoqa.com/login");
        Thread.sleep(3000);

        a.manage().window().maximize();
        Thread.sleep(2000);

        extentTest.info("Navigate to Tools QA page");

        JavascriptExecutor js = (JavascriptExecutor) a;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
//
////        a.findElement(By.id("userName")).sendKeys("ameepatel251@gmail.com");
////        Thread.sleep(1000);
////
////        a.findElement(By.id("password")).sendKeys("Amee@5597");
////        Thread.sleep(1000);
////
////        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
////        Thread.sleep(1000);
////
////        a.findElement(By.id("login")).click();
////        Thread.sleep(3000);

        // Title Assertion
        String actualTitle = a.getTitle();
        String expectedTitle = "DemoQA";
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is not matched");
        softAssert.assertAll();

        extentTest.pass("Assertion is pass for ToolsQA title");
    }

    @Test(testName = "eCommerce", groups = {"smoke", "functional"})
    public void eCommerce() throws InterruptedException {

        a.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        Thread.sleep(3000);

        a.manage().window().maximize();
        Thread.sleep(2000);

        extentTest.info("Navigate to eCommerce page");

        WebElement mail = a.findElement(By.id("Email"));
        mail.clear();

        mail.sendKeys("admin@yourstore.com");
        Thread.sleep(1000);

        a.findElement(By.id("Password")).sendKeys("abc");
        Thread.sleep(1000);

        a.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        softAssert.assertFalse(true, "Password is incorrect");
        softAssert.assertAll();

        extentTest.fail("Assertion is fail for eCommerce password field ");
    }

    @Test(testName = "Google", groups = {"sanity", "smoke"})
    public void Google() throws InterruptedException {

        a.get("https://www.google.com/");
        Thread.sleep(3000);

        a.manage().window().maximize();
        Thread.sleep(2000);

        extentTest.info("Navigate to Google page");

        a.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
        Thread.sleep(2000);

        String expectedTitle = "HYR Tutorials  ";  //  display the expected title of the page

        String actualTitle = a.getTitle();        // display the actual title of the page

        softAssert.assertEquals(actualTitle, expectedTitle, "Title is not matched");    // Compare the actual title with expected title ang print the message when test is fail

        softAssert.assertAll();

        extentTest.pass("Assertion is fail for Google title ");

    }
}
