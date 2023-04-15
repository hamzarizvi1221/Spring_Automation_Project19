package Day11_0401;

import Day9_0319.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_GoogleSearch_TestNG_Priorities {
    WebDriver driver;

    @BeforeSuite
    public void setUpDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }

    @Test()

    public void searchForBMW() {
        driver.navigate().to("http://google.com");

        ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "BMW", "Search Field");

        ReusableMethods.submitMethod(driver, "//*[@name='btnK']", "Google Search");
    }

    @Test(dependsOnMethods = {"searchForBMW"})
    public void CaptureSearchNumberforBMW(){

    String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
    String[] arrayResult = result.split(" ");
        System.out.println("Search Number for BMW: "+arrayResult[1]);




    }
}
