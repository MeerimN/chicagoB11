package testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OrderOfThings {

    @Ignore
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running");
    }
    @Test(priority = 1, dependsOnMethods = "secondTest")
    public void firstTest(){
        System.out.println("First test is running");
    }
    @Test(priority =2)
    public void secondTest(){
        System.out.println("Second test is running");
    }
    @Test(priority = -3)
    public void thirdTest(){
        System.out.println("Third test is running");
    }
}
