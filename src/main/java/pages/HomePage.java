package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class HomePage extends ParentPage{

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("https://medizine.eu/");
            logger.info("HomePage was opened");
        } catch (Exception e) {
            logger.error("Can not open HomePage");
            Assert.fail("Can not open HomePage");
        }
    }

        public boolean IsUserInfoPresent () {
            try {
                return webDriver.findElement(By.xpath(".//div[@class='user-info']")).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }

