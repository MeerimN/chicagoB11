package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SmartbearLink2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // we invoking created method in other class
        Smartbear.loginToSmartBear(driver);

        //Click on Order
        WebElement orderLink = driver.findElement(By.linkText("Order")); //href use link text
        orderLink.click();

        ////locate the select dropdown webElement
        WebElement productDropdown = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        //create an object of select class and pass the dropdown webElement located
        //Select familyAlbum from product, set quantity to 2



        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        Thread.sleep(1000);
        quantity.sendKeys("2");
        WebElement album  =driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']"));
        Select selectObject = new Select(album);
        selectObject.selectByVisibleText("FamilyAlbum");

        //Fill address Info with JavaFaker
        Faker faker = new Faker();
        WebElement inputName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        inputName.sendKeys(faker.address().streetName());

        // Generate: name, street, city, state, zip code

        //street
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        inputStreet.sendKeys(faker.name().name());

        //city
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        inputCity.sendKeys(faker.address().cityName());

        //state
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        inputState.sendKeys(faker.address().cityName());

        //zip code
        WebElement zipcode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.sendKeys(faker.address().zipCode().replace("-", ""));

        //Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        //Generate card number using JavaFaker
        WebElement inputCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCard.sendKeys(faker.finance().creditCard().replace("-",""));

        //add expiration data
        WebElement data = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        data.sendKeys("10/19");

        //Click on “Process”
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //Verify success message “New order has been successfully added.”

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        String successMessageText = successMessage.getText();

        if(successMessageText.equals("New order has been successfully added.")){
            System.out.println("Success Message Verification Passed!");
        }else{
            System.out.println("Success Message Verification FAILED!!!");
        }
    }
}
