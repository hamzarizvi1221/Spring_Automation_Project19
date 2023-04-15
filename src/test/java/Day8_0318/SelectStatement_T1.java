package Day8_0318;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectStatement_T1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://mortgagecalculator.org");

        Thread.sleep(2000);

        WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));

        Select startMonthDropdown = new Select(strMonth);

        startMonthDropdown.selectByVisibleText("Apr");




        
        
    }// end of main

}// end of class
