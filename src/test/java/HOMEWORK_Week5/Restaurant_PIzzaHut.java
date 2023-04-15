package HOMEWORK_Week5;

import Day9_0319.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Restaurant_PIzzaHut {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.pizzahut.com");

        ReusableMethods.clickMethod(driver, "//*[@class='jss100']", "find deals");

        ReusableMethods.clickMethod(driver, "//*[@class='jss100']", "find deals");


    }}
