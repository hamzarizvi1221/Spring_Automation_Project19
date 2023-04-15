package HOMEWORK_Week5;

import Day9_0319.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AI05 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = ReusableMethods.defineChromeDriver();
// navigate to best buy.com
        driver.navigate().to("http://bestbuy.com");
//type "iphone" in search field
        ReusableMethods.sendKeysMethod(driver, "//*[@class='search-input']", "iphone", "Search Field");
        //click on search icon
        ReusableMethods.clickMethod(driver, "//*[@class='header-search-icon']", "Search icon");

        //ReusableMethods.clickMethod(driver, "//*[@class='tb-select']","Drop down");
//capture dropdown element
       // WebElement sortBy = driver.findElement(By.xpath("//*[@class='tb-select']"));
//select dropdown
        //Select sortByDropdown = new Select(sortBy);
//select "best selling" from drop down
        //sortByDropdown.selectByVisibleText("Best Selling");
        ReusableMethods.selectMethod(driver,"//*[@class='tb-select']", "Best Selling", "drop down");
        // wait for 2 seconds
        Thread.sleep(2000);
// click on the first iphone
        driver.findElements(By.xpath("//*[@class='sku-title']")).get(0).click();

        ReusableMethods.scrollElement(driver,"//*[@class='c-button c-button-outline c-button-md c-button-block v-m-top-xs']","totalTech","totalTech");
//using scroll element, scroll to "learn about totaltech"
        //WebElement totalTech = driver.findElement(By.xpath("//*[@class='c-button c-button-outline c-button-md c-button-block v-m-top-xs']"));
       // JavascriptExecutor jse = (JavascriptExecutor) driver;
       // jse.executeScript("arguments[0].scrollIntoView(true)", totalTech);
//click add to cart
        ReusableMethods.clickMethod(driver, "//*[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button']", "Add To Cart");

//wait 3 seconds
        Thread.sleep(3000);
        //capture subtotal
        String subtotal = driver.findElement(By.xpath("//*[@class='d-flex']")).getText();
        String[] subTotalOnly = subtotal.split(":");
        //print out only amount
        System.out.println("Cart Subtotal: " + subTotalOnly[1]);
//hover on continue shopping
        //Actions mouseAction = new Actions(driver);
       // try {
            //WebElement sendTab = driver.findElement(By.xpath("//*[@class='c-button-link continue-shopping']"));
           //mouseAction.moveToElement(sendTab).perform();
       // } catch (Exception e) {
           // System.out.println("Unable to hover to Continue Shopping " + e);
       // ReusableMethods.hovermethod("", "");
//wait 2 seconds
Thread.sleep(2000);
//click on continue shopping
        } //end of sendTab exception
       // try {
           // WebElement trackingLink = driver.findElements(By.xpath("//*[@class='c-button-link continue-shopping']")).get(0);
           // mouseAction.moveToElement(trackingLink).click().perform();
       // }catch (Exception e) {
          //  System.out.println("unable to click on continue shopping: " + e);
        }// end of trackingLink exception
    //end of class
//end of main

