package TestNG.Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustomListeners.class)    // Listener at class level
public class ListenerTest {

    @Test
    public void TestMethod1(){

        System.out.println("This is a Test Method 1");

    }

    @Test
    public void TestMethod2(){

        System.out.println("This is a Test Method 2");
        Assert.assertTrue(false);

    }

    @Test(timeOut = 500)
    public void TestMethod3() throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("This is a Test Method 3");

    }

    @Test(dependsOnMethods = "TestMethod3")
    public void TestMethod4(){

        System.out.println("This is a Test Method 4");

    }

}
