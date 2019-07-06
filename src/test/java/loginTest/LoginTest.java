package loginTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver webDriver;
    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver1.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void validLogIn(){


        webDriver.get("https://medizine.eu/");

        webDriver.findElement(By.xpath(".//li[@id='menu-item-3048']")).click();
        webDriver.findElement(By.xpath(".//input[@id='username']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='username']")).sendKeys("avtotest");

        webDriver.findElement(By.xpath(".//input[@id='password']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("avtotest19");

        webDriver.findElement(By.xpath(".//button[@name='login']")).click();

        HomePage homePage = new HomePage(webDriver);

        Assert.assertTrue("User-info is not present",homePage.IsUserInfoPresent());


    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}
