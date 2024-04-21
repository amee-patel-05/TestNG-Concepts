package TestNG.ExtentReportsConcepts;


// Extent Report configuration using Java JSON and XML
//Change the Theme
//Change the Report Name
//Change the Document Title
//Change the date and time stamp format
//Apply the CSS
//Run the javascript

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ConfigurationJsonJavaXml {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver a = new ChromeDriver();

        Capabilities capabilities = ((RemoteWebDriver)a).getCapabilities();

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\ConfigurationJsonJavaXml.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        ExtentSparkReporterConfig config =  sparkReporter .config();

        // Java

        config.setTheme(Theme.DARK);
        config.setDocumentTitle("Document Title");
        config.setReportName("Attribute Report");
        config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        config.setCss(".badge-primary {background-color:#dd88cd}");
        config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));

        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

        extentReports.setSystemInfo("Browser", capabilities.getBrowserName() + " " + capabilities.getBrowserVersion());

        extentReports.setSystemInfo("App URL", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        extentReports.setSystemInfo("Username", "Admin");

        extentReports.setSystemInfo("Password", "admin123");


//        sparkReporter.loadJSONConfig(new File("resources\\extent-reports-config.json")); // open the json file
//        sparkReporter.loadXMLConfig(new File("resources\\extent-reports-config.xml"));   // open the xml file

        extentReports.attachReporter(sparkReporter);

        extentReports
                .createTest("Test 1", " This is a Test 1")
                .assignAuthor("Rakesh")
                .assignCategory("Sanity")
                .assignDevice("Chrome 122")
                .pass("This is a passed test");

        extentReports
                .createTest("Test 2", "This is a Test 2")
                .assignAuthor("Suresh")
                .assignCategory("Smoke")
                .assignDevice("Edge 100")
                .fail("This is a failed test");

        extentReports.flush();

        a.close();

        Desktop.getDesktop().browse(new File("ExtentReports\\ConfigurationJsonJavaXml.html").toURI());

    }

}
