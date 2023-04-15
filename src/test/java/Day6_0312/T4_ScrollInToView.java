package Day6_0312;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_ScrollInToView {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
//add maximize for windows
//options.addArguments("start-maximized");
//add --kiosk for mac
//options.addArguments("--kiosk");
//add incognito mode to option
        options.addArguments("incognito");
//add options to run your driver on the background(headless)
//options.addArguments("headless");

//define the chrome driver that you will use for automation test
//option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

//navigate to yahoo home page
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

//scroll in to the calculate button and se that as the initial point of the page
        WebElement calculate = driver.findElement(By.xpath("//*[@value='Calculate']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",calculate);
    }

}
