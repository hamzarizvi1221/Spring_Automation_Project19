package Day9_0319;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableMethods {
    public static WebDriver defineChromeDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        return driver;

    }

    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element: " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);

        }


    }        //end of click method

    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Succesfully entered a value on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element" + elementName + ": " + e);
        }

    }  //end of sendkey

    public static String captureTextMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element: " + elementName + ": " + e);
        }
        return result;

    }

    public static void selectMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
            System.out.println("Successfully selected element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select dropdown " + elementName + ":" + e);
        }
    }

    public static void scrollElement(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", element);
            System.out.println("Successfully scrolled to element: ");

        } catch (Exception e) {
            System.out.println("Unable to scroll in to view" + elementName + ":" + e);
        }
    }

    public static void hovermethod (WebDriver driver, String xpath, String elementName) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Actions hover = new Actions (driver);

    try{
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    hover.moveToElement(element);

    System.out.println("Successfully hovered over element: " + elementName);
    } catch (Exception e) {
    System.out.println("Unable to hover over element " + elementName + ": " + e);
    }
    }
    //submit action is one of the type of void method
    public static void submitMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ": " + e);
        }
    }//end of submit method
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName){
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element  " + elementName + " " + e);
        }//end of exception
    }//end of verifyBooleanStatement
    public static void switchToTabByIndex(WebDriver driver,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        java.util.ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        try{
           // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully opens and switches to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to Successfully open and switch to " + elementName + ": " + e);
        }
    }//end of submit method
    //click method by index
    public static void clickMethodByIndex(WebDriver driver, String xpath, int index, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }//end of exception
    }//end of click method by index
    //click method by index
    public static void captureTextByIndex(WebDriver driver, String xpath, int index, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).getText();
            System.out.println("Successfully captured  element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable capture element " + elementName + ": " + e);
        }//end of exception
    }//end of click method by index
    public static void scrollByPixel (WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("scroll()", element);

            System.out.println("Successfully scrolled by pixel to element: ");

        } catch (Exception e) {
            System.out.println("Unable to scroll by pixel" + elementName + ":" + e);
        }
    }
}

