package Day10_0319;

import Day9_0319.ReusableMethods;
import org.openqa.selenium.WebDriver;
public class T1_Staples_ {
    public static void main(String[] args) {

        //set up chrome driver
        WebDriver driver = ReusableMethods.defineChromeDriver();

driver.navigate().to("http://bestbuy.com");
    }
}
