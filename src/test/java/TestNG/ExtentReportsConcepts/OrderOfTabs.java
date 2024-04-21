package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OrderOfTabs {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\ OrderOfTabs.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        // Remove the Author information & Change the Order of the tabs
        sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.CATEGORY,
                ViewName.DEVICE,
                ViewName.EXCEPTION,

        }).apply();

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

        extentReports
                .createTest("Test 3", "This is a Test 3")
                .assignCategory("Regression")
                .assignDevice("Firefox 120")
                .assignAuthor("Mitesh")
                .skip("This is a skipped test");

        extentReports
                .createTest("Test 4", "This is a Test 4")
                .assignAuthor("Suresh", "Rakesh", "Mitesh")
                .assignCategory("Smoke", "Sanity", "Functional")
                .assignDevice("Chrome 120", "Firefox 118", "Edge 115")
                .warning("This is a warning test");

        Throwable t = new RuntimeException("This is a custom exception");
        extentReports
                .createTest("Exception Test 2")
                .fail(t);

        extentReports.flush();

        Desktop.getDesktop().browse(new File("ExtentReports\\ OrderOfTabs.html").toURI());
    }

}
