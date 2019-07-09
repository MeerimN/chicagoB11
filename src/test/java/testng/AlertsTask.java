package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsTask {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }
    @Test
    public void pumpUp() throws InterruptedException {

        WebElement clickAlerts = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clickAlerts.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You successfuly clicked an alert";
        Assert.assertEquals(actualText,expectedText, "Texts in first does not match!");

    }
    @Test(priority = 1)
    public void pumpUp2() throws InterruptedException {

        WebElement clickConfirm = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clickConfirm.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        String actualText = driver.findElement(By.id("result")).getText();
        System.out.println(actualText);
        String expectedText = "You clicked: Ok";
        Assert.assertTrue(actualText.equals(expectedText), "Texts in second test does not match!");

    }
    @Test(priority = 2)
    public void pumpUp3() throws InterruptedException {

        WebElement clickPrompt = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
        clickPrompt.click();



        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys("Hello");
        alert.accept();

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You entered: Hello";
        Assert.assertEquals(actualText,expectedText, "Texts in third does not match!");

    }
}
