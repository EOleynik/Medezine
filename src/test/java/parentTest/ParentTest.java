package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver1.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);

    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}
