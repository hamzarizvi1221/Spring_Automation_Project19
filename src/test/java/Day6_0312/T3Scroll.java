package Day6_0312;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3Scroll {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //navigate to yahoo home page
//navigate to yahoo home page
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

//scroll to the bottom to click on mortgage rate
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//scroll using pixels
        jse.executeScript("scroll(0,3000)");

        Thread.sleep(1000);

//scrolling back up again
        jse.executeScript("scroll(0,-3000)");

        Thread.sleep(1500);

//scroll down again using pixels
        jse.executeScript("scroll(0,3000)");

//click on mortgage rate link
        driver.findElements(By.xpath("//a[text()='Mortgage Rates']")).get(1).click();

    }
}
