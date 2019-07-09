package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenTest2 {
    public static void main(String[] args) {


        System.out.println("hello");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        Faker faker = new Faker();

        driver.findElement(By.name("q")).sendKeys(faker.name().name() + Keys.ENTER);
    }
}
