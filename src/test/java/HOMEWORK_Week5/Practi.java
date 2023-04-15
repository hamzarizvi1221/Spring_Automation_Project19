package HOMEWORK_Week5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practi {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone case");
        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
        driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")).get(0).click();
        WebElement quantity = driver.findElement(By.xpath("//*[@class='a-button-text a-declarative']"));
        Select quantityDropDown = new Select(quantity);
        quantityDropDown.selectByVisibleText("3");


        driver.findElement(By.xpath("//*[@class='a-button-text a-declarative']")).click();





    }
}
