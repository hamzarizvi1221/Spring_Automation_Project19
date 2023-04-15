package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Xpathcontains {
    public static void main(String[] args) throws InterruptedException {
        //Set up your driver thru web browser manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to yahoo.com
        driver.navigate().to("http://www.yahoo.com");

        // stay on for 2 seconds
        Thread.sleep(2000);

        //click on finance
        driver.findElement(By.xpath("//a[contains(text(),'Finance')]")).click();

    }
}
