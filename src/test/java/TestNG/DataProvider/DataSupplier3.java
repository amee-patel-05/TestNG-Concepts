package TestNG.DataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

// read the data from the excel file, create array, store value in the array

public class DataSupplier3 {

    @DataProvider(name ="LoginDetails")
    public Object[][] getData() throws IOException {

        FileInputStream fileinput = new FileInputStream("..\\TestNGConcepts\\resources\\DataProvider3.xlsx");  // getting data from excel file

        XSSFWorkbook workbook = new XSSFWorkbook(fileinput);	// get workbook instance for XLS file

        XSSFSheet sheet = workbook.getSheet("LoginData");		// Get first sheet form workbook

        System.out.println("No of rows in excel sheet : "+sheet.getLastRowNum()); // display the rows without header

        int rows = sheet.getPhysicalNumberOfRows();  	// display the rows with header
        int columns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows-1][columns]; // Create the array to specify the size of rows and columns
       for (int i=0 ; i < rows-1 ; i++)
       {
            for (int j=0 ; j < columns ; j++)
            {
                DataFormatter df = new DataFormatter();  // Convert any data type to string data type no need to define individual datatype

                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));  // Store the data into array
                //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
           System.out.println( );
       }

        workbook.close();
       fileinput.close();

        //        for (String[] dataArr : data){
//            System.out.println(Array.toString(dataArr));
//        }

        return data;
    }
}
