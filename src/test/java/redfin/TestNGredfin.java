package redfin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestNGredfin {

    @Test
    public void byMeerim() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://redfin.com");
        WebElement buy = driver.findElement(By.xpath("(//a[@class='inheritColor'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(buy).build().perform();


        Thread.sleep(2000);
        //#1 Scenario
        //Navigating driver to => "Home Buying Guide" which is inside of the Buy box
        //Scrolling down and up the "Home Buying Guide" page
        driver.navigate().to("https://www.redfin.com/home-buying-guide");
        WebElement learnMore = driver.findElement(By.xpath("(//h2[@class='title'])[2]"));
        Actions act = new Actions(driver);
        act.moveToElement(learnMore).build().perform();
        driver.close();


        //#2 Scenario
        //At "Home Buying Guide" page opening => "How to buy a Home in 7 steps"
        WebElement homeBuySteps = driver.findElement(By.xpath("(//div[@class='bg-image'])[2]"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(homeBuySteps).click().build().perform();


        //#3 Scenario
        //In opened "How to buy a Home in 7 steps" => Find video and play the video
        //Make double click and see the video
        //return back to "How to buy a Home in 7 steps" page
        //In opened "How to buy a Home in 7 steps" => Go to "Search box"
        //"Search box" <= input <= Naperville, IL => Enter

        WebElement video = driver.findElement(By.xpath("//div[@class='section-row clickable ']"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(video).click().build().perform();
        //driver.findElement(By.linkText("https://www.youtube.com/watch?v=11oithCm_CM")).click();
        driver.navigate().back();


        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
        Actions act3 = new Actions(driver);
        act3.moveToElement(searchBox).click().build().perform();
        searchBox.sendKeys("Naperville, IL" + Keys.ENTER);

        //#4
        WebElement setMinPrice = driver.findElement(By.xpath("(//span[@class='value'])[1]"));
        Actions action4 = new Actions(driver);
        action4.moveToElement(setMinPrice).click().build().perform();

//        WebElement setMaxPrice = driver.findElement(By.xpath("(//span[@class='container'])[1]"));
//        Actions action5 = new Actions(driver);
//        action5.moveToElement(setMaxPrice).click().build().perform();




    }
//    public void byMeerim2(){
//        driver.navigate().to();
//    }
}
