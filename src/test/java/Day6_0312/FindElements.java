package Day6_0312;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.mlcalc.com");

        driver.findElement(By.xpath("//*[@name='ma']")).clear();
        driver.findElement(By.xpath("//*[@name='ma']")).sendKeys("250000");

        driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        Thread.sleep(1500);

        String result = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();

        System.out.println("Monthly Payment: " + result);

        String result2 = driver.findElements(By.xpath("//*[@style ='font-size: 32px']")).get(1).getText();
        System.out.println("Total 360 payment is " + result2);


    }

}
