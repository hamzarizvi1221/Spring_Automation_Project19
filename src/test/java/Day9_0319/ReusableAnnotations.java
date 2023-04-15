package Day9_0319;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReusableAnnotations {
    //you need to make your WebDriver driver variable static since we are calling it to our test class
    public static WebDriver driver;
public static ExtentReports reports;
    public static ExtentTest logger;

    //set before suite annotation method
    @BeforeSuite
    public void setDriver(){
        driver = ReusableMethods.defineChromeDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);
    }//end of before suite
@BeforeMethod
public void getTestName (Method methodName){
        logger = reports.startTest(methodName.getName());

}
    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }//end of after suite

    }


