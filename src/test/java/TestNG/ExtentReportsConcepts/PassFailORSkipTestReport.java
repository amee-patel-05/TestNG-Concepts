package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

// ShortCuts in Extent Report

//p - Show passed tests
//f - Show failed tests
//s - Show skiped tests
//w - Show warning tests
//esc - clear filters
//down-arrow - scrolldown
//up-arrow - scrollup
//l - switch theme
//t - test
//c - tag
//d - dashboard

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PassFailORSkipTestReport {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("ExtentReports\\AllTestReport.html");

        ExtentSparkReporter sparkReporter_fail = new ExtentSparkReporter("ExtentReports\\FailedTestReport.html");
        sparkReporter_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();

        ExtentSparkReporter sparkReporter_skipandwarning = new ExtentSparkReporter("ExtentReports\\Skip&WarningTestReport.html");
        sparkReporter_skipandwarning.filter().statusFilter().as(new Status[] {
                Status.SKIP,
                Status.WARNING
        }).apply();

        extentReports.attachReporter(sparkReporter_all,sparkReporter_fail,sparkReporter_skipandwarning);

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

        Desktop.getDesktop().browse(new File("ExtentReports\\AllTestReport.html").toURI());

        Desktop.getDesktop().browse(new File("ExtentReports\\FailedTestReport.html").toURI());

        Desktop.getDesktop().browse(new File("ExtentReports\\Skip&WarningTestReport.html").toURI());
    }

}
