package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void validLogIn(){
        File file = new File("./src/drivers/chromedriver1.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://medizine.eu/");

        webDriver.findElement(By.xpath(".//li[@id='menu-item-3048']")).click();
        webDriver.findElement(By.xpath(".//input[@id='username']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='username']")).sendKeys("avtotest");

        webDriver.findElement(By.xpath(".//input[@id='password']")).clear();
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("avtotest19");

        webDriver.findElement(By.xpath(".//button[@name='login']")).click();

        Assert.assertTrue("User-info is not present",webDriver.findElement
                (By.xpath(".//div[@class='user-info']")).isDisplayed());

        webDriver.quit();



    }
}
