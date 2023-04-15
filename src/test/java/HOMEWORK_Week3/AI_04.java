package HOMEWORK_Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI_04 {
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

        ArrayList<String> state = new ArrayList<>();
        state.add("New York");
        state.add("California");
        state.add("Chicago");

for (int i = 0; i < state.size(); i++){

    //navigate to hotels home page
    driver.navigate().to("https://www.hotels.com");

    Thread.sleep(1500);

    try {
        WebElement location = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
        location.click();
    }catch (Exception e) {
        System.out.println("unable to interact with element" + e);

        try {
            WebElement searchField = driver.findElement(By.xpath("//*@class='destination_form_field']"));
            searchField.sendKeys(state.get(i));

        } catch (Exception exception) {
            System.out.println("Unable to click on search field" + exception);
            Thread.sleep(1000);

            try {
                WebElement people = driver.findElement(By.xpath("//*[@data-stid='open-room-picker']"));
                people.click();

            } catch (Exception exception1) {
                System.out.println("Unable to click on number of travelers" + e);
            }
            Thread.sleep(1000);
            ArrayList<Integer> adults = new ArrayList<>();
            adults.add(1);
            adults.add(2);
            adults.add(3);

            WebElement button = driver.findElement(By.xpath("//*[@class='utik-step-input-button']"));
            button.click();
            Thread.sleep(1000);

            for (int j = 0; j < adults.get(i); j++) {
                driver.findElements(By.xpath("//*[@class='utik-step-input-button']")).get(1).click();
            }

        }

    }
}
    }}




