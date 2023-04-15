package Day12;

import Day2_022623.ArrayList;
import Day9_0319.ReusableAnnotations;
import Day9_0319.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T1_ReusableAnnotation extends ReusableAnnotations {
    @Test(priority = 1)
    public void searchForIphone() {
        ArrayList<String> phones = new ArrayList<>();
        phones.add("iphone");
        phones.add("samsung");
        for (int i = 0; i < phones.size(); i++) {
            driver.navigate().to("https://www.yahoo.com");
            //enter iphone on search field
            ReusableMethods.sendKeysMethod(driver, "//*[@name='p']", phones.get(i), "Search Field");
            //click on search icon
            ReusableMethods.clickMethod(driver, "//*[@id='ybar-search']", "Search Icon");
            String result = ReusableMethods.captureTextMethod(driver, "//span[@class=' fz-14 lh-22']", "Search Results");
            String[] arrayResult = result.split(" ");
            System.out.println("Search Number for " + phones.get(i) + " is " + arrayResult[1]);
        }//end of loop
    }//end of test 1

    @Test(priority = 2)
    public void captureResultOnAboutPage() {
        //scroll to the bottom
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,4000)");
        ReusableMethods.clickMethod(driver, "//*[text()='About this page']", "About This page Link");
        String result = ReusableMethods.captureTextMethod(driver, "//h1[contains(text(),'Filter and refine ')]", "Results");
        System.out.println("Result: " + result);
    }//end of test 2
}