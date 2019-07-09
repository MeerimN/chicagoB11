package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class IFramePractice {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.getWindowHandle();
        for(String window: driver.getWindowHandles()){
            driver.switchTo().window(window);


        }

        /**
         * Create a	new	class called: IframePractice
         * 2.Create	new	test and make set ups
         * 3.Go	to	:http://practice.cybertekschool.com/iframe
         * 4.Assert:“Your content goes here.”Text is displayed.
         * 5.Assert:“An	iFrame	containing the	TinyMCE	WYSIWYG	Editor
         */

    }
    @Test
    public void iframeTest(){

        driver.switchTo().frame("mce_0_ifr");
        String actualtextInsideFrame = driver.findElement(By.xpath("//p")).getText();

        String expectedText = "Your content goes here.";

        Assert.assertEquals(actualtextInsideFrame,expectedText, " text inside iframe is not matching");

        driver.switchTo().parentFrame();

        String actualHeaderText = driver.findElement(By.xpath("//h3")).getText();

        String expectedHeaderText ="An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualHeaderText, expectedHeaderText, "header text is not matching");

    }
}
