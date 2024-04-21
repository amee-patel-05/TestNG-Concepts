package TestNG.DataProvider;

import org.testng.annotations.DataProvider;

// Use this class data for Data Provider 2 class
public class DataSupplier2 {

    @DataProvider(name = "LoginDetails")
    public Object[][] LoginData()
    {
        Object[][] data = new Object[6][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";

        data[1][0] = "Admin";
        data[1][1] = "test123";

        data[2][0] = "Admin12";
        data[2][1] = "admin123";

        data[3][0] = "Admin123";
        data[3][1] = "admin123123";

        data[4][0] = " ";
        data[4][1] = " ";

        return data;
    }
}
