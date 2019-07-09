package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RedfinTask {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Test(priority = 1)
    public void searchHomes() throws InterruptedException {

        driver.get("https://redfin.com");

        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
        searchBox.sendKeys("Naperville, IL");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);


        WebElement minPriceDropDown = driver.findElement(By.xpath("(//span[@data-rf-test-name='Select'])[2]"));
        minPriceDropDown.click();

        WebElement min50$ = driver.findElement(By.xpath("(//div[@class='option'])[1]"));
        Thread.sleep(2000);
        min50$.click();


        //Thread.sleep(1000);
        //String currentURL = driver.getCurrentUrl();
        //Assert.assertTrue(currentURL.contains("50k"));
        //System.out.println(currentURL);

        WebElement maxPriceDropdown = driver.findElement(By.xpath("(//span[@data-rf-test-name='Select'])[3]"));
        maxPriceDropdown.click();

        WebElement max175$ = driver.findElement(By.xpath("(//div[@class='option'])[5]"));
        Thread.sleep(2000);
        max175$.click();

    }
}