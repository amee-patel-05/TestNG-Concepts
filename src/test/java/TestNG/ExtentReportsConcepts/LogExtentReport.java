package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.reporters.FailedReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

// Different Log level

public class LogExtentReport {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\LogExtentReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        extentReports.attachReporter(sparkReporter);

//        When you execute the code result will be in following order:
//        Fail
//        Skip
//        Warning
//        Pass
//        Info

        extentReports
                .createTest("Test 1")
                .log(Status.FAIL, "fail1")
                .log(Status.INFO, "info1")
                .log(Status.PASS, "pass1")
                .log(Status.WARNING, "warning1")
                .log(Status.SKIP, "skip1")
                .log(Status.INFO, "info2")
                .log(Status.WARNING, "Warning2")
                .log(Status.SKIP, "skip2")
                .log(Status.FAIL, "fail2")
                .log(Status.PASS, "pass2");

        extentReports.flush();
        Desktop.getDesktop().browse(new File("ExtentReports\\LogExtentReport.html").toURI());
    }
}
