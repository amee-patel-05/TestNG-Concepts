package TestNG.ScreenshotConcept;

import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.IOException;

public interface ListenerClass extends ITestNGListener {
    void onTestFailure(ITestResult result) throws IOException;

}
