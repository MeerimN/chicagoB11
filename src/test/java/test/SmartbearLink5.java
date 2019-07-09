package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartbearLink5 {
    /*Create a method named	printNamesAndCities that takes	WebDriver object.
      This method should simply	print all the names in the List of All orders.
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Smartbear.loginToSmartBear(driver);
    }
    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> Allnames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        List<WebElement> allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]"));

        for(int i = 0; i < allCities.size(); i++){
            System.out.println(Allnames.get(i).getText() + " <--names, cities--> " + allCities.get(i).getText());
        }
    }
}
