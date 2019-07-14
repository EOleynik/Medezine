package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected HomePage homePage;
    protected MyAccountPage myAccountPage;
    protected StorePage storePage;
    protected BrandDefluPage brandDefluPage;
    protected CartPage cartPage;


    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver1.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        storePage = new StorePage(webDriver);
        brandDefluPage = new BrandDefluPage(webDriver);
        cartPage = new CartPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean expectedResult, boolean actualResult){
        Assert.assertEquals(message,expectedResult,actualResult);
    }

    public void checkExpectedResult(String message, String expectedResult, String actualResult){
        Assert.assertEquals(message,expectedResult,actualResult);
    }

    public void checkExpectedResult(String message,Double expectedResult,Double actualResult){
        Assert.assertEquals(message,expectedResult,actualResult);
    }

    public void checkExpectedResult (String message, boolean getPrice){
        Assert.assertTrue(message, getPrice);
    }

}
