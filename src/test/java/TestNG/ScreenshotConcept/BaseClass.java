package TestNG.ScreenshotConcept;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {

    public  static WebDriver a;
    public static String screenshotsSubFolderName;

    @BeforeTest
    public void Setup(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

        a = new ChromeDriver();

        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void screenshotCapture(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
        }
    }

    @AfterTest
    public void teardown(){

        a.quit();
    }

    public void captureScreenshot(String fileName) {

        if(screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) a;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+ screenshotsSubFolderName+"/"+fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }

    // Extra code

//    public static String captureScreenshot(String a) throws IOException {
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


