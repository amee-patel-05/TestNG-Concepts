package TestNG.ExtentReportsConcepts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

// Log different type of information to the extent report

public class LogInfoExtentReport {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("ExtentReports\\ LogInfoExtentReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        extentReports.attachReporter(sparkReporter);

        // Text - Bold / Italic
        extentReports
                .createTest("Test 1")
                .log(Status.INFO, "<b>info1</b>")
                .log(Status.INFO, "<i>info2</i>")
                .log(Status.INFO,"<b><i>info3</i></b>");

        // XML & JSON file
        // https://json.org/example.html website for example
        String xmlData = "<widget>\n" +
                "    <debug>on</debug>\n" +
                "    <window title=\"Sample Konfabulator Widget\">\n" +
                "        <name>main_window</name>\n" +
                "        <width>500</width>\n" +
                "        <height>500</height>\n" +
                "    </window>\n" +
                "    <image src=\"Images/Sun.png\" name=\"sun1\">\n" +
                "        <hOffset>250</hOffset>\n" +
                "        <vOffset>250</vOffset>\n" +
                "        <alignment>center</alignment>\n" +
                "    </image>\n" +
                "    <text data=\"Click Here\" size=\"36\" style=\"bold\">\n" +
                "        <name>text1</name>\n" +
                "        <hOffset>250</hOffset>\n" +
                "        <vOffset>100</vOffset>\n" +
                "        <alignment>center</alignment>\n" +
                "        <onMouseUp>\n" +
                "            sun1.opacity = (sun1.opacity / 100) * 90;\n" +
                "        </onMouseUp>\n" +
                "    </text>\n" +
                "</widget>";

        String jsonData = "{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    ";

        extentReports
                .createTest("XML based test")
                        .info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));

        extentReports
                .createTest("JSON based test")
                        .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

        // Collection Data (List, Set, Map)

        List<String> listData = new ArrayList<>();
        listData.add("Selenium");
        listData.add("TestNG");
        listData.add("Java");
        listData.add("Eclipse");

        Map<Integer, String>  mapData = new HashMap<>();
        mapData.put(101, "Selenium");
        mapData.put(102, "TestNG");
        mapData.put(103, "Java");
        mapData.put(104, "Eclipse");

        Set<Integer> setData = mapData.keySet();

        extentReports
                .createTest("List based test")
                        .info(MarkupHelper.createOrderedList(listData))
                        .info(MarkupHelper.createUnorderedList(listData));

        extentReports
                .createTest("set based test")
                .info(MarkupHelper.createOrderedList(setData))
                .info(MarkupHelper.createUnorderedList(setData));

        extentReports
                .createTest("map based test")
                .info(MarkupHelper.createOrderedList(mapData))
                .info(MarkupHelper.createUnorderedList(mapData));

        // Highlight any message

        extentReports
                .createTest("Highlight log Test")
                .info("This is not a highlighted message")
                .info(MarkupHelper.createLabel("This is a highlighted message", ExtentColor.AMBER));


        // Exception
        try {
            int i = 5/0;
        }catch (Exception e){
            extentReports
                    .createTest("Exception Test 1")
                    .fail(e);
        }

        Throwable t = new RuntimeException("This is a custom exception");
        extentReports
                .createTest("Exception Test 2")
                .fail(t);

        extentReports
                .createTest("Exception Test 3")
                .fail(t);


        extentReports.flush();

        Desktop.getDesktop().browse(new File("ExtentReports\\ LogInfoExtentReport.html").toURI());
    }
}
