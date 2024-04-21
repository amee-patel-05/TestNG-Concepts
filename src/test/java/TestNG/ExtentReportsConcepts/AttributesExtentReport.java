package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// Different Attributes available for a test in  extent reports
// Author    (Name of the Testcases created person)
// Category  (Group)
// Device    (browser Name)

public class AttributesExtentReport {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\ AttributesExtentReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

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

        extentReports.flush();

        Desktop.getDesktop().browse(new File("ExtentReports\\ AttributesExtentReport.html").toURI());
    }

}
