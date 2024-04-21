package TestNG.Groups;

import org.testng.annotations.Test;

@Test
public class GroupDependencies {

    //  2       3          3         3         3       2
// smoke, regression, sanity, functional, load, stress

        @Test(groups = {"smoke"})
        public void TestMethod1()
        {
            System.out.println("TestMethod 1 is executed");
        }

        @Test(groups = {"regression"})
        public void TestMethod2()
        {
            System.out.println("TestMethod 2 is executed");
        }

        @Test(groups = {"sanity"})
        public void TestMethod3()
        {
            System.out.println("TestMethod 3 is executed");
        }

        @Test(groups = {"load"})
        public void TestMethod4()
        {
            System.out.println(5/0);
        }

        @Test(groups = {"stress"})
        public void TestMethod5()
        {
            System.out.println("TestMethod 5 is executed");
        }

        @Test(groups = {"functional"})
        public void TestMethod6()
        {
            System.out.println("TestMethod 6 is executed");
        }

//        @Test(dependsOnGroups = {"smoke" , "regression"})
//        public void TestMethod8()
//        {
//            System.out.println("Main TestMethod is executed");
//        }

}

