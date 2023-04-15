package HOMEWORK_Week6;

import Day9_0319.ReusableAnnotations;
import Day9_0319.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AI_06 extends ReusableAnnotations {
//make variable global
    WebDriver driver;
//create before suite method
    @BeforeSuite
    public void setUpDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }
    @Test(priority = 1)
    public void fidelisCare() {
        //navigate to fidelis care website
        driver.navigate().to("https://www.fideliscare.org/");
        //click on search element
        ReusableMethods.clickMethod(driver, "//*[@class='fal fa-search']", "Search");
        //type "get dental coverage"
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']", "get dental coverage", "dental coverage");
        //click on search element
        ReusableMethods.clickMethod(driver, "//*[@class='btn btn-primary btn-search']", "Search");
        //capture search results
        ReusableMethods.captureTextMethod(driver, "//*[@class='gsc-result-info']", "capture search results");
//split and print search number
        String searchNumber = ReusableMethods.captureTextMethod(driver, "//*[@class='gsc-result-info']", "capture search results");
        String[] searchNumberOnly = searchNumber.split(" ");
        System.out.println("Search Number: " + searchNumberOnly[1]);
//click on "get dental coverage"
        ReusableMethods.clickMethod(driver, "(//*[contains(text(),'Get Dental Coverage')])", "Get Dental Coverage");


    //end of test 1
    }

    @Test(dependsOnMethods = {"fidelisCare"})
    public void tc2() throws InterruptedException {
        //open and switch to new tab
        ReusableMethods.switchToTabByIndex(driver, "New Tab");
//enter first name
        ReusableMethods.sendKeysMethod(driver, "//*[@id='firstName']", "Hamza", "First Name");
//enter last name
        ReusableMethods.sendKeysMethod(driver, "//*[@id='lastName']", "Rizvi", "Last Name");
//enter zip code
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "11557", "Zip Code");
//enter county
        ReusableMethods.selectMethod(driver,"//*[@id='county']","Nassau","County");
//enter phone number
        ReusableMethods.sendKeysMethod(driver, "//*[@id='phoneNumber']", "5161439581", "Phone Number");
//enter email
        ReusableMethods.sendKeysMethod(driver, "//*[@id='email']", "hamza555544433323@gmail.com", "Email");
        //check contact me box
        ReusableMethods.clickMethodByIndex(driver, "//*[text()='Contact Me']", 1,"Contact me Button");
        //wait 2 secs
        Thread.sleep(2000);
        //click contact me
ReusableMethods.clickMethod(driver,"//*[@type='submit']","Contact me");

        String thankYouMessage = ReusableMethods.captureTextMethod(driver,"//*[@class='alert alert-success']","helpful hints");
        System.out.println(thankYouMessage);
        driver.close();

    }//end of test 2
    @Test(priority = 3)
    public void t3 (){
        //switch back to default tab
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        //click on login
        ReusableMethods.clickMethod(driver, "(//*[contains(text(),'Login')])", "Login");
        //click on "Member Online Portal"
        ReusableMethods.clickMethod(driver,"//*[@href='https://members.fideliscare.org/en-us/fidelislogin']","member online portal");
        //capture and print out helpful hints
String helpfulHints = ReusableMethods.captureTextMethod(driver,"//*[text()='Helpful Hints']","helpful hints");
        System.out.println(helpfulHints);
        //close the tab
driver.close();
//close browser
driver.quit();
}//end of main
}//end of class

