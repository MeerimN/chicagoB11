package redfin;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedfinProject {
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

        driver.get("https://redfin.com");
    }

    @Test
    public void actualTitle(){

        WebElement buy = driver.findElement(By.xpath("(//a[@class='inheritColor'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(buy).build().perform();

        String expectedInTitle = "Home Buying Guide";

        if(expectedInTitle.equals("Home Buying Guide")){
            System.out.println("Title verification is PASSED!");
        }else{
            System.out.println("Title verification is FAILED!!!");
        }
        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        System.out.println(links.size());

        for(WebElement link: links){
            System.out.println(link.getText());
        }

    }
    @Test
    public void homeBuyingGuide(){

        WebElement buy = driver.findElement(By.xpath("(//a[@class='inheritColor'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(buy).build().perform();
        driver.navigate().to("https://www.redfin.com/home-buying-guide");
        WebElement learnMore = driver.findElement(By.xpath("(//h2[@class='title'])[2]"));
        Actions act = new Actions(driver);
        act.moveToElement(learnMore).build().perform();

        WebElement homeBuySteps = driver.findElement(By.xpath("(//div[@class='bg-image'])[2]"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(homeBuySteps).click().build().perform();

    }
    @Test
    public void searchHomes(){

        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
        Actions act3 = new Actions(driver);
        act3.moveToElement(searchBox).click().build().perform();
        Faker faker = new Faker();
        searchBox.sendKeys("123 Main St, Seattle, WA" +  Keys.ENTER);

        WebElement setMinPrice = driver.findElement(By.xpath("(//span[@class='value'])[1]"));
        Actions action4 = new Actions(driver);
        action4.moveToElement(setMinPrice).click().build().perform();

    }
    @AfterClass
    public void closeBrowser(){
 
        //driver.quit();
    }
}
