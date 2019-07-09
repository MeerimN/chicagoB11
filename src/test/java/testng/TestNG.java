package testng;



import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class running!");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("AfterClass running... ");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod running...");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod running...");
    }

    @Test
    public void firstTest(){
        System.out.println("This is the first test running.");

        Assert.assertEquals("a", "a", "First test a b is failed!");
        Assert.assertEquals(5, 5, "Age verification Failed!");
    }

    @Test
    public void secondTest(){
        System.out.println("This is the second test running.");
    }
    @Test
    public void titleTest(){
        String actualTitle = "Google - Apples";
        String expectedTitleContains = "Apples";

        Assert.assertTrue(actualTitle.contains(expectedTitleContains), "Actual title does not contain expected value.");
    }

    @Test
    public void onPurposeFail(){
        Assert.fail("This is on purpose fail.");

    }
}
