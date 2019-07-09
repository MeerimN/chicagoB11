package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InputOfTags {
    /*
     * Print out number of <input> tags on the same page.
     * Print the value of "type" attribute of each <input> tag.
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        driver.get("https://www.openxcell.com/");

        List<WebElement> inputs = driver.findElements(By.xpath("//body//input"));
        System.out.println(inputs.size());


        for (WebElement input: inputs) {
            System.out.println(input.getAttribute("type"));

        }
    }
}
