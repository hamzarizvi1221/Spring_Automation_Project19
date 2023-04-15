package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_googleHome {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to ("https://google.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");
driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
//System.out.println("Search results: " + result);
//print out only the number
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number: " + arrayResult[1]);
    }

}
