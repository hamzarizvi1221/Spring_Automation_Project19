package HOMEWORK_Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TEST {

    public static void main(String[] args) throws InterruptedException {

        // part of the WebDriverManager library
        WebDriverManager.chromedriver().setup();

        // define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

        //set up the ArrayList of sports
        ArrayList<String>sports = new ArrayList<>();
        sports.add("Football");
        sports.add("Baseball");
        sports.add("Basketball");
        sports.add("Soccer");

        //iterate through the list of sports and print search number for each sport
        for (int i=0; i<sports.size(); i++){

            // navigate to bing home page
            driver.navigate().to("https://www.bing.com");

            // wait for 2 seconds
            Thread.sleep(2000);

            // enter keyword football to search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            // click on bing search icon
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            // wait 2 seconds for new page
            Thread.sleep(2000);

            //capture search results
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
// print only number
            String [] arrayResult = result.split(" ");
            System.out.println("For " + sports.get(i) + ", the search number is " + arrayResult [1]);
        } // end of loop

        }
}
