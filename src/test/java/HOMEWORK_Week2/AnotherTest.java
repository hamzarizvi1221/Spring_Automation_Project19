package HOMEWORK_Week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AnotherTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        ArrayList<String> sports = new ArrayList<>();
        sports.add("Football");
        sports.add("Baseball");
        sports.add("Basketball");
        sports.add("Soccer");

        for (int i = 0; i < sports.size(); i++) {

            driver.navigate().to("https://www.youtube.com");

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys(sports.get(i));

            driver.findElement(By.xpath("//*[@id='search_input']")).submit();

            Thread.sleep(2000);

            String result = driver.findElement(By.xpath("//*[@id='style-scope yt-formatted-string bold']")).getText();

            String[] arrayResult = result.split(" ");
            System.out.println("For " + sports.get(i) + ", the view number is " + arrayResult[1]);


        }

    }
}
