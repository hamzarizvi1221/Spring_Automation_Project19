package HOMEWORK_Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Assingment_2_Week2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        ArrayList <String> Sports = new ArrayList<>();
        Sports.add("Basketball");
        Sports.add("Football");
        Sports.add("Soccer");
        Sports.add("Baseball");

        for (int i= 0; i<Sports.size(); i++){

            driver.navigate().to("http://www.bing.com");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//* [@name='q']")).sendKeys(Sports.get(i));

            driver.findElement(By.xpath("//*[@name='search']")).submit();

            Thread.sleep(2000);

            String result = driver.findElement(By.xpath("//*[@id='sb_form_go']")).getText();

            String[] arrayResult = result.split(" ");
            System.out.println("For" +Sports.get(i) + "the search number is " + arrayResult[i]);





        }

    }
}
