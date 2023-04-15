package Day13;

import Day9_0319.ReusableMethods_logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static Day9_0319.ReusableAnnotations.driver;
import static Day9_0319.ReusableAnnotations.logger;

public class staplesExample extends ReusableMethods_logger {
    @Test(priority = 1)
    public void searchForCricket(){
        logger.log(LogStatus.PASS.INFO,"Navigate to Staples home page");
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com");

        //type on search field using sendkeys method
        ReusableMethods_logger.sendKeysMethod(driver,"//*[@id='searchInput']","iphone",logger,"Search Field");

        //click on the search icon
        ReusableMethods_logger.clickMethod(driver,"//*[@class='search-bar-input__searchIcon']",logger,"Search Icon");
    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchNumber() throws InterruptedException {
        //click on first image by index
        ReusableMethods_logger.clickMethodByIndex(driver,"//*[@class='standard-tile__image standard-tile__image_hover']",0,logger,"Iphone Image");

        //click on add to the cart button
        ReusableMethods_logger.clickMethodByIndex(driver,"//*[@id='ctaButton']",0,logger,"Add to cart");

        //capture the starting price and print it out
        Thread.sleep(3000);
        String result = ReusableMethods_logger.captureTextMethod(driver,"//*[contains(text(),'starting at')]",logger,"Starting Price");
        System.out.println("Iphone result is " + result);
        logger.log(LogStatus.INFO,"Iphone result is " + result);
    }//end of test 2
    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method

    //click action is one of the type of void method
    public static void clickMethodByIndex(WebDriver driver,String xpath,int index,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method by index
}
