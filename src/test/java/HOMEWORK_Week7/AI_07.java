package HOMEWORK_Week7;

import Day9_0319.ReusableAnnotations;
import Day9_0319.ReusableMethods;
import Day9_0319.ReusableMethods_logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AI_07 extends ReusableAnnotations {
    @BeforeSuite
    public void defineReport(){
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);
    }//end of before suite
    @Test(priority = 1)
    public void searchForAgent() throws InterruptedException {
        //navigate to google home
        logger.log(LogStatus.INFO,"Navigate to shelter Home page");
        driver.navigate().to("https://www.shelterinsurance.com");
        //type the zip code 11557 on search field
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='findAgentInput']","11557",logger,"Search Field");
        //hit find on search field
        ReusableMethods_logger.clickMethod(driver,"//*[@class='button findAgentBtn']",logger,"find button");
    }//end of test 1
    @Test(priority = 2)
    public void selectAgent(){
        //Select first agent
        ReusableMethods.clickMethodByIndex(driver,"//div[@class='three columns agentName']/a[1]",0," First Agent");
        // capture agent info and print
        String result = ReusableMethods_logger.captureTextMethod(driver,"//div[@class='seven columns ourAgencyData']/div/div[4]",logger,"address of firm");
        System.out.println("Address of firm:" + result);
    }//end of test 2
@Test (priority =3)
    public void getQuote() throws InterruptedException {
        //request a quote
        ReusableMethods_logger.clickMethod(driver,"//*[@class='large button red agentGetQuoteBtn']",logger,"request quote");
    //select type
        ReusableMethods_logger.selectMethod(driver,"//*[@id='product']","Auto","select product");
        //select state
        ReusableMethods_logger.selectMethod(driver,"//*[@id='policyState']","Ohio","Select state");
        //click on continue
        ReusableMethods_logger.clickMethod(driver,"//div[@class='columns six']/a[@class='button']",logger,"continue");
        //click on "no"
        ReusableMethods_logger.clickMethod(driver,"//*[@id='hasActivePolicies2']",logger,"no current policies");

        Thread.sleep(5000);
    }
    @Test(priority = 4)
    public void enterInformation () throws InterruptedException {
        //enter first name
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='firstName']","Hamza",logger,"First name");
        //enter last name
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='lastName']","Rizvi",logger,"Last name");
        //enter address
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='addressLineOne']","7201-6901 Pinewood Dr",logger,"Address Line 1");
        //enter city
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='city']","Columbus",logger,"City");
        //enter state
        ReusableMethods.selectMethod(driver,"//*[@id='state']","Ohio","State");
        //enter zip code
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='zipCode']","11557",logger,"zip code");
        //enter county
        ReusableMethods.selectMethod(driver,"//*[@id='county']","Clinton","county");
        //enter dob
      ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='dateOfBirth']","12211999",logger,"DOB");
      //click no
       ReusableMethods_logger.clickMethod(driver,"//*[@id='isSR22Required2']",logger,"click 'no'");
       Thread.sleep(5000);
       //continue
ReusableMethods_logger.clickMethod(driver,"//*[@class='columns six']/a",logger,"continue");



    }
@Test (priority = 5)
    public void changeLocation () throws InterruptedException {
        // go back to home page
        ReusableMethods_logger.clickMethod(driver,"//*[@alt='Shelter Insurance']",logger,"home page");
        //click on more search options
        ReusableMethods_logger.clickMethodByIndex(driver,"//*[@class='link-row']/a[@href='/CA/agent/search']",0,logger,"More Search Options");
        //change location to St. Louis, missouri
        ReusableMethods_logger.clickMethod(driver,"//*[@id='changeLocation']",logger,"change location");
        ReusableMethods_logger.clickMethod(driver,"//li[@style='clear: left;'][4]",logger,"missouri");
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@class='columns eight phone-three']/input[@id='city']","St. Louis","columbus");
        //click find
        ReusableMethods_logger.clickMethod(driver,"//*[@id='search']/i",logger,"find");






    }
    @Test(priority = 6)
    public void getOfficeInformation (){
        //click on the first agent
        ReusableMethods_logger.clickMethod(driver,"//*[@class='three columns agentName']/a[@href='/CA/agent/BILLNEWHOUSE']",logger,"First Agent");
        //capture agent details/office hours and print
      String agencyDetails = ReusableMethods_logger.captureTextMethod(driver,"//*[@class='seven columns ourAgencyData']","Agency Details");
       String officeHours = ReusableMethods_logger.captureTextMethod(driver,"//*[@id='agentOfficeContent']","Office Hours");
        System.out.println("Agency Details:"+ agencyDetails);
        System.out.println("Office Hours:" + officeHours);

    }
    @AfterSuite
    public void writeBacktoReport(){
        //end the logger for tests
        reports.endTest(logger);
        reports.flush();
    }//end of after suite
}
