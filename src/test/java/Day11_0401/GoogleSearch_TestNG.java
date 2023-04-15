package Day11_0401;

import Day9_0319.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearch_TestNG {
    WebDriver driver;

    @BeforeSuite
    public void setUpDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }
    @Test

    public void GoogleSearchNumber(){
        driver.navigate().to("http://google.com");

        ReusableMethods.sendKeysMethod(driver,"//*[@name='q']","BMW","Search Field");

        ReusableMethods.submitMethod(driver,"//*[@name='btnK']","Google Search");

        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']","Search Results");

        String [] arrayResult = result.split(" ");
        System.out.println("Search Number for BMW: " + arrayResult[1]);

//quit the driver
        //@AfterSuite
       // public void quitSession(){
       //    driver.quit();
        }//end of after suite

    }


