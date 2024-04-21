package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DemoReport {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\DemoReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        extentReports.attachReporter(sparkReporter);

        ExtentTest test1 = extentReports.createTest("Test 1");
        test1.pass("This is passed");

        ExtentTest test2 = extentReports.createTest("Test 2");
        test2.log(Status.FAIL, "This is failed");

        extentReports.createTest("Test 3").skip("This is skipped");

        extentReports.flush();

        Desktop.getDesktop().browse(new File("ExtentReports\\DemoReport.html").toURI());
    }


//    public static String captureScreenshot(WebDriver a) throws IOException {
//
//        String  FileSeparator = System.getProperty("file.separator");
//        String Extent_report_path = "." + FileSeparator + "Reports";
//        String ScreenshotPath = Extent_report_path + FileSeparator + "screenshots";
//        File sourceFile = ((TakesScreenshot) a).getScreenshotAs(OutputType.FILE);
//        String screenshotName = "screenshot" + Math.random() + ".png";
//        String screenshotpath = ScreenshotPath+FileSeparator+screenshotName;
//        FileUtils.copyFile(sourceFile,new File(screenshotpath));
//        return "." + FileSeparator + "screenshots" + FileSeparator + screenshotName;

//        TakesScreenshot ts = (TakesScreenshot) a;
//        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File("...\\TestNGConcepts\\screenshots\\" + filename);
//        FileUtils.copyFile(sourceFile,destinationFile);
        //System.out.println("Screenshot saved successfully");
    }


