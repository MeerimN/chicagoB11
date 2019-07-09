package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * Create a	method named "verifyOrder" that takes WebDriver object and	String(name).
 * This	method should verify if	given name given name exists in orders.
 */

public class SmartbearLink4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Smartbear.loginToSmartBear(driver);

    }
    public static void verifyOrderNames(WebDriver driver, String giveName){
        List<WebElement> Allnames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for (WebElement name: Allnames){
            if(name.getText().equals(giveName)){
                System.out.println(giveName + " exists in the table. Name verification PASSED!");
                return;
            }
        }
        System.out.println(giveName + " does not exists in the table. Name verification FAILED!!!");
    }
}
