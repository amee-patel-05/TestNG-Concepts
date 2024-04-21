package TestNG.ScreenshotConcept;

import org.testng.ITestResult;

import java.io.IOException;

public class ITestListener extends BaseClass implements ListenerClass {

    @Override
     public void onTestFailure(ITestResult result) throws IOException {

        System.out.println(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName());

        captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
    }

}
