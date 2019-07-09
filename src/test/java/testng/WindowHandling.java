package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowHandling {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");

    }
    @Test
    public void windowHandleTest() {
        String mainHandle = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        for (String handle : driver.getWindowHandles()) {
            if(!handle.equals(mainHandle)){
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }
        }
    }
}
