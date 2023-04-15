package HOMEWORK_Week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BH_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to ("https://www.bhphotovideo.com/");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();


    }
}
