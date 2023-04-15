package HOMEWORK_Week5;

import Day9_0319.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AI_05 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = ReusableMethods.defineChromeDriver();
// navigate to best buy website
        driver.navigate().to("http://bestbuy.com");
//type "iphone" in search field
        ReusableMethods.sendKeysMethod(driver, "//*[@class='search-input']", "iphone", "Search Field");
        //click on search icon
        ReusableMethods.clickMethod(driver, "//*[@class='header-search-icon']", "Search icon");
        // select best selling from dropdown
        ReusableMethods.selectMethod(driver,"//*[@class='tb-select']", "Best Selling", "drop down");
      //wait for 2 secs
        Thread.sleep(2000);
        //click on first link
        driver.findElements(By.xpath("//*[@class='sku-title']")).get(0).click();
        //scroll to learn about total tech
        ReusableMethods.scrollElement(driver,"//*[@class='c-button c-button-outline c-button-md c-button-block v-m-top-xs']","totalTech","totalTech");
// click on add to cart
        ReusableMethods.clickMethod(driver, "//*[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button']", "Add To Cart");
//wait 3 seconds
        Thread.sleep(3000);
        //capture subtotal
        String subtotal = driver.findElement(By.xpath("//*[@class='d-flex']")).getText();
        String[] subTotalOnly = subtotal.split(":");
        //print out only amount
        System.out.println("Cart Subtotal: " + subTotalOnly[1]);





    }
}
