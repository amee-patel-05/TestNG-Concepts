package TestNG.ExtentReportsConcepts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SystemEnvironmentInfo {

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver a = new ChromeDriver();
//
//        Capabilities capabilities = ((RemoteWebDriver)a).getCapabilities();
//
//        System.out.println(capabilities.getBrowserName());   // display the browser name
//
//        System.out.println(capabilities.getBrowserVersion());   // display the browser version

//        a.close();

//        System.getProperties().list(System.out);  // all the system properties display

        System.out.println(System.getProperty("os.name"));      // OS name

        System.out.println("Java version: "+System.getProperty("java.version"));  // Java version


    }
}
