package TestNG.AnnotationExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

     WebDriver a;
    public static String screenshotsSubFolderName;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @Parameters("browserName")
    @BeforeTest
    public void Setup(ITestContext context, @Optional("chrome") String browserName)throws InterruptedException{

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
        Thread.sleep(3000);

        Capabilities capabilities = ((RemoteWebDriver)a).getCapabilities();

        String device = capabilities.getBrowserName() + " " + capabilities.getBrowserVersion();

        String author = context.getCurrentXmlTest().getParameter("author");

        extentTest = extentReports.createTest(context.getName());

        extentTest.assignAuthor(author);

        extentTest.assignDevice(device);
        System.out.println("Before Test executed");



    }

    // For Listener
//    @AfterMethod
//    public void screenshotCapture(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
//        }
//    }

    @AfterMethod
    public void CheckStatus(Method m, ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String screenshotPath = null;
            screenshotPath = captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");

            extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            extentTest.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS){

            extentTest.pass(m.getName() + "is passed");

        }
        extentTest.assignCategory(m.getAnnotation(Test.class).groups());
    }

    @AfterTest
    public void teardown() {

        a.quit();
    }

    @BeforeSuite
    public void InitialiseExtentReport(){
        ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("ExtentReports\\AnnotationAllTest.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter_all);

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));

        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

    }

    @AfterSuite
    public void generateExtentReport() throws IOException {

        extentReports.flush();

        Desktop.getDesktop().browse(new File("ExtentReports\\AnnotationAllTest.html").toURI());

    }

    public String captureScreenshot(String fileName) {

        if (screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) a;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/" + screenshotsSubFolderName + "/" + fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
        return fileName;
    }
}
