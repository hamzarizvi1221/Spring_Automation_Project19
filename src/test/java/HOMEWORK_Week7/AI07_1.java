package HOMEWORK_Week7;

import Day9_0319.ReusableAnnotations;
import Day9_0319.ReusableMethods;
import Day9_0319.ReusableMethods_logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AI07_1 extends ReusableAnnotations {
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void defineReport(){
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);
    }//end of before suite

    @Test(priority = 1)
    public void TC1(){
        //give a name to the test
        logger = reports.startTest("Find potential agents");
        //navigate to shelter home insurance homepage
        logger.log(LogStatus.INFO,"navigate to shelter home insurance homepage");
        driver.navigate().to("https://www.shelterinsurance.com/#");
        //type the zipcode 45056 on search field
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='findAgentInput']","45056",logger,"Zip Code");
        //hit find
        ReusableMethods_logger.clickMethod(driver,"//*[@class='button findAgentBtn']",logger,"Find");
    }//end of test 1
@Test (priority = 2)
    public void TC2(){
        logger = reports.startTest("Find exact agent");
        //Click on the first agent that comes up
    //ReusableMethods_logger.clickMethodByIndex(driver,"//*[@class='three columns agentName']/a[1]",logger,"");
    }
}
