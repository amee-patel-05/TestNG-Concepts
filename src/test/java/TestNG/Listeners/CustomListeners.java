package TestNG.Listeners;
import org.testng.*;
import org.testng.ITestResult;

// IConfigurationListener , IListenerAnnotations, IListener, ITestNGListener, ITest, ITestContext, ITestResult, ItemListener
//ITestListener, InstallationListener, IterationListener
//ISuiteListener TestListenerAdapter


public class CustomListeners implements ITestListener
{

    // Invoked before running all the test methods belonging to the classes inside the <test> tag and calling all their Configuration methods.
    @Override
    public void onStart(ITestContext context)
    {
        System.out.println("Start Test execution "+context.getName());
    }

    //Invoked after all the test methods belonging to the classes inside the <test> tag have run and all their Configuration methods have been called.
    @Override
    public void onFinish(ITestContext context)
    {
        System.out.println("Finish Test Execution "+context.getName());
    }

    //Invoked each time before a test will be invoked.
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Start Test "+result.getName());
    }

    //Invoked each time a test is skipped.
    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Skip Test "+result.getName());
    }

    //Invoked each time a test succeeds.
    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Pass Test "+result.getName());
    }

    //Invoked each time a test fails.
    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Failed Test "+result.getName());
    }

    //Invoked each time a test fails due to a timeout
    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {
        System.out.println("Timeout of test execution "+result.getName());
    }

    //Invoked each time a method fails but has been annotated with successPercentage and this failure still keeps it within the success percentage requested.
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }
}
