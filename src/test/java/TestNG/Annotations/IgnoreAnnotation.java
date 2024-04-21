package TestNG.Annotations;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore         // Ignore annotation at class level
public class IgnoreAnnotation {

    @Test
    public void method1(){

        System.out.println("Method 1 is executed");
    }

    @Ignore                     // Ignore annotation at method level
    @Test
    public void method2(){

        System.out.println("Method 2 is executed");
    }

    @Test
    public void method3(){

        System.out.println("Method 3 is executed");
    }

    @Test
    public void method4(){

        System.out.println("Method 4 is executed");
    }

    @Test
    public void method5(){

        System.out.println("Method 5 is executed");
    }
}
