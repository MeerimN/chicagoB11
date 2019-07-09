package test;
/*
   1.Open	browser
   2.Go	to	website:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
   3.Enter username: “Tester”
   4.Enter password: “test”
   5.Click to Login button
   6.Print out count of all the links on landing page
   7.Print out each link text on this page
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Smartbear {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement login = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement submit = driver.findElement(By.id("ctl00_MainContent_login_button"));

        login.sendKeys("Tester");
        password.sendKeys("test");
        submit.click();


        List<WebElement> listOflinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("The number of links on this page: " + listOflinks.size());


        for (WebElement link: listOflinks) {
            System.out.println(link.getText()); //this will print out the object reference
        }
    }
    public static void loginToSmartBear(WebDriver driver){

        WebElement login = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement submit = driver.findElement(By.id("ctl00_MainContent_login_button"));

        login.sendKeys("Tester");
        password.sendKeys("test");
        submit.click();
    }
}
