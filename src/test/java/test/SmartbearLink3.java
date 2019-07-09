package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SmartbearLink3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // we invoking created method in other class
        Smartbear.loginToSmartBear(driver);

        WebElement date = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));

        String dateText = date.getText();

        if(dateText.equals("01/05/2010")){
            System.out.println("Susan McLaren date verification PASSED!");
        }else{
            System.out.println("Susan McLaren date verification FAILED!!!");
        }
    }
}
