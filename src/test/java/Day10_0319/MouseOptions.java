package Day10_0319;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseOptions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://www.usps.com");

        Thread.sleep(2000);

        Actions mouseAction = new Actions(driver);

        try {
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseAction.moveToElement(sendTab).perform();
        }catch (Exception e) {
            System.out.println("Unable to hover to Send Tab: " + e);
        }//end of send tab

        try {
            WebElement trackingLink = driver.findElements(By.xpath("//*[text()='Tracking']")).get(0);
            mouseAction.moveToElement(trackingLink).click().perform();
        }catch (Exception e) {
            System.out.println("unable to click on Tracking: " + e);
        }
        try {
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));

            mouseAction.moveToElement(trackingField).click().sendKeys("12345678").perform();
        }catch (Exception e) {
            System.out.println("unable to type on Tracking Input: " + e);
        }
    }
}
