package HOMEWORK_Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI_03 {
    public static void main(String[] args) throws InterruptedException {

        //create an Array List to store 3 different real zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10503");
        zipCode.add("10803");
        zipCode.add("11557");

            WebDriverManager.chromedriver().setup();

            //set your chrome options arguments for your web driver
            ChromeOptions options = new ChromeOptions();

            //add --kiosk for mac maximize
            options.addArguments("--kiosk");

            //add incognito mode to option
            options.addArguments("incognito");
            WebDriver driver = new ChromeDriver(options);

            //iteration loop thru the zip codes
        for (int i = 0; i < zipCode.size(); i++) {

            // navigate to weightwatchers.com
            driver.navigate().to("http://www.weightwatchers.com");

            // wait for 2 seconds
            Thread.sleep(2000);

            //click on find a workshop link using contains
            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();

            //click on In person link
            driver.findElement(By.xpath("//*[text()='In-Person']")).click();

            //wait for 2 seconds
            Thread.sleep(2000);

            //clear the field
            driver.findElement(By.xpath("//*[@class='input input-3TfT5']")).clear();

            //enter zipcodes
            driver.findElement(By.xpath("//*[@class='input input-3TfT5']")).sendKeys(zipCode.get(i));

            // click on search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();

            //wait 2 seconds
            Thread.sleep(2000);

            //Click on a specific studio link based on the value of i
            ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//a[@class='linkUnderline-1_h4g']")));
            driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));

            if (i == 0) {
                studioLink.get(1).click();
            } else if (i == 1) {
                studioLink.get(2).click();
            } else if (i == 2) {
                studioLink.get(0).click();

            }
            // wait 2 seconds
            Thread.sleep(2000);

            //capture studio addresses
            ArrayList<WebElement> studioAddress = new ArrayList<>(driver.findElements((By.xpath("//*[@class='address-2PZwW']"))));
            String address = studioAddress.get(0).getText();

            // print out address for studios
            System.out.println("Studio Address for zip code " + zipCode.get(i) + ": " + address);

            // scroll down to the schedule table
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0,1000)");

            //capture entire table
            ArrayList<WebElement> scheduleTable = new ArrayList<>(driver.findElements((By.xpath("//*[@id='studioWorkshopSchedule']"))));
            String schedule = scheduleTable.get(0).getText();

            //print out workshop schedule
            System.out.println("Workshop Schedule for zip code " + zipCode.get(i) + ": " + schedule);

        }//end of loop

            // quit the driver
            driver.quit();

        }// end of main


        }// end of class



