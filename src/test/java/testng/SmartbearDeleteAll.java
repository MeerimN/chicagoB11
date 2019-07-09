package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.Smartbear;

import java.util.concurrent.TimeUnit;

/**
 * Smartbear	delete	all1.
 * 1.Open browser
 * 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 * 3.Enter username: “Tester”
 * 4.Enter password: “test”
 * 5.Click to Login button
 * 6.Click to CheckAll
 * 7.Run a loop to make sure all the checkboxes are checked
 * 8.Click “Delete Selected”
 * 9.Assert “List of orders is empty. In order to add new order use this link.“ text is displayed
 */

public class SmartbearDeleteAll {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void before(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Smartbear.loginToSmartBear(driver);
    }

    @Test
    public void deleteAll(){

        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();

        WebElement deleteAllchecked = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteAllchecked.click();

    }

    @AfterClass
    public void closeBrowser(){

        //driver.quit();
    }
}
