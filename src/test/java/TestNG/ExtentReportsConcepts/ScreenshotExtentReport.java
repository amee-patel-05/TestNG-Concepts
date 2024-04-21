package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String;


// Attach screenshot to the extent report


public class ScreenshotExtentReport {
    public  static WebDriver a;

    public static void main(String[] args) throws IOException, InterruptedException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\ScreenshotExtentReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        extentReports.attachReporter(sparkReporter);

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

        a = new ChromeDriver();

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        a.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);

        a.manage().window().maximize();
        Thread.sleep(1000);

        // Test level screenshot

        String base64code = captureScreenshot();
        String path = captureScreenshot("OrangeHRM.jpg");

        extentReports
                .createTest("Screenshot Test 1","This is for attaching the screenshot to the test at test level")
                .info("This is a info message")
                .addScreenCaptureFromBase64String(base64code);

        extentReports
                .createTest("Screenshot Test 2","This is for attaching the screenshot to the test at test level")
                .info("This is a info message")
                .addScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage");  // media, string

        //multiple screenshot at test level
        extentReports
                .createTest("Screenshot Test 3","This is for attaching the screenshot to the test at test level")
                .info("This is a info message")
                .addScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage1")  // media, string
                .addScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage2")
                .addScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage3")
                .addScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage4");

        extentReports
                .createTest("Screenshot Test 4","This is for attaching the screenshot to the test at test level")
                .info("This is a info message")
                .addScreenCaptureFromPath(path);

        extentReports
                .createTest("Screenshot Test 5","This is for attaching the screenshot to the test at test level")
                .info("This is a info message")
                .addScreenCaptureFromPath(path, "OrangeHRM Homepage");

        //multiple screenshot at test level
        extentReports
                .createTest("Screenshot Test 6","This is for attaching the screenshot to the test at test level")
                .info("This is a info message")
                .addScreenCaptureFromPath(path, "OrangeHRM Homepage1")   // media, string
                .addScreenCaptureFromPath(path, "OrangeHRM Homepage2")
                .addScreenCaptureFromPath(path, "OrangeHRM Homepage3")
                .addScreenCaptureFromPath(path, "OrangeHRM Homepage4");

        // Log level screenshot

        extentReports
                .createTest("Screenshot Test 7","This is for attaching the screenshot to the test at log level")
                .info("This is a info message")
                .fail(createScreenCaptureFromBase64String(base64code).build())
                .fail(createScreenCaptureFromBase64String(base64code,"OrangeHRM Homepage").build());

        extentReports
                .createTest("Screenshot Test 8","This is for attaching the screenshot to the test at log level")
                .info("This is a info message")
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "OrangeHRM Homepage").build());

        extentReports
                .createTest("Screenshot Test 9","This is for attaching the screenshot to the test at log level")
                .info("This is a info message")
                .fail("This is info for base64 code", MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
                .fail("This is info for base64 code", MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage").build());

        extentReports
                .createTest("Screenshot Test 10","This is for attaching the screenshot to the test at log level")
                .info("This is a info message")
                .fail("This is info for file path", MediaEntityBuilder.createScreenCaptureFromPath(path).build())
                .fail("This is info for file path", MediaEntityBuilder.createScreenCaptureFromPath(path, "OrangeHRM Homepage").build());

        Throwable t = new Throwable("This is throwable exception");
        extentReports
                .createTest("Screenshot Test 9","This is for attaching the screenshot to the test at log level")
                .info("This is a info message")
                .fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
                .fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "OrangeHRM Homepage").build());

        extentReports
                .createTest("Screenshot Test 10","This is for attaching the screenshot to the test at log level")
                .info("This is a info message")
                .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
                .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "OrangeHRM Homepage").build());

        extentReports.flush();

        a.close();

        Desktop.getDesktop().browse(new File("ExtentReports\\ScreenshotExtentReport.html").toURI());
    }

    public static String captureScreenshot() {

        TakesScreenshot takesScreenshot = (TakesScreenshot) a;

        String base64code= takesScreenshot.getScreenshotAs(OutputType.BASE64);

        System.out.println("Screenshot saved successfully");

        return base64code;
    }
    public static String captureScreenshot(String fileName) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) a;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/" +fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");

        return destFile.getAbsolutePath();
    }
}

