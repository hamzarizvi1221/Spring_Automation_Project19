package Day8_0318;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class handlingTabs {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
//define the chrome driver that you will use for automation test
//option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

//navigate to yahoo home page
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);

//click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
//click on second shop for a plan
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()='Shop for a Plan']")).click();

        Thread.sleep(2000);

//click on find a doctor
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();

//call the window handles in array list and switch to the new tab
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
//switch to the new tab by index of 1
        driver.switchTo().window(tabs.get(1));

//enter zipcode on the location field
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11218");
    }

}
