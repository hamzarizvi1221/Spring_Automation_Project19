package HOMEWORK_Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class AI_04_1 {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add full screen option for mac
        options.addArguments("--kiosk");

        // add incognito option
        options.addArguments("incognito");

        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("California");
        destinations.add("Chicago");

        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);

        ArrayList<String> childAges = new ArrayList<>();
        childAges.add("Under 1");
        childAges.add("1");
        childAges.add("2");

        for (int i = 0; i < destinations.size(); i++) {
            for (int j = 0; j < adults.get(i); j++) {

                driver.navigate().to("https://www.hotels.com/");
                Thread.sleep(2000);

                try{
                    WebElement destinationInput = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                    destinationInput.click();
                    destinationInput.sendKeys(destinations.get(i));
                    System.out.println("Successfully entered destination input");
                }catch (Exception e) {
                    System.out.println("Unable to enter a value in destination field. " + e);
                }//end of exception for home value


                //clear and enter a interest rate
                try{
                    WebElement interestRate = driver.findElement(By.xpath("//*[@name='param[interest_rate]']"));
                    interestRate.clear();
                    interestRate.sendKeys("2.5");
                    System.out.println("Successfully entered interest rate on the field");
                }catch (Exception e) {
                    System.out.println("Unable to enter a value on Interest Rate field. " + e);
                }//end of exception for interest rate

                //select start month
                try{
                    WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
                    Select dropDown = new Select(strMonth);
                    dropDown.selectByVisibleText("Apr");
                    System.out.println("Successfully Selected Month from the dropdown");
                }catch (Exception e) {
                    System.out.println("Unable to select a value Start Month drop down. " + e);
                }//end of exception for start month


            }
        }
    }
}


