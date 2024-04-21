package TestNG.Groups;

import org.testng.annotations.Test;
//  2       3          3         3         3       2
// smoke, regression, sanity, functional, load, stress

@Test(groups = {"all"})
public class Groups1 {

    @Test(groups = {"smoke"})
   public void TestMethod1()
   {
       System.out.println("TestMethod 1 is executed");
   }

   @Test(groups = {"regression" , "functional"})
   public void TestMethod2()
   {
       System.out.println("TestMethod 2 is executed");
   }

   @Test(groups = {"sanity" , "regression" , "functional"})
   public void TestMethod4()
   {
       System.out.println("TestMethod 4 is executed");
   }

   @Test(groups = {"load"})
    public void TestMethod5()
    {
        System.out.println("TestMethod 5 is executed");
    }

    @Test(groups = {"stress"})
    public void TestMethod6()
    {
        System.out.println("TestMethod 6 is executed");
    }

    @Test(groups = {"load" , "stress"})
    public void TestMethod7()
    {
        System.out.println("TestMethod 7 is executed");
    }

    @Test(groups = {"sanity" , "functional" , "load"})
    public void TestMethod8()
    {
        System.out.println("TestMethod 8 is executed");
    }

    @Test(groups = {"smoke" , "regression" , "sanity"})
    public void TestMethod9()
    {
        System.out.println("TestMethod 9 is executed");
    }

    @Test
    public void TestMethod10()
    {
        System.out.println("TestMethod 10 is executed");
    }
}
