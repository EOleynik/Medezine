package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//a[@href='/my-account/orders/' and @class='menu-link']")
    private WebElement MoyAccaunt;
    @FindBy(xpath = ".//div[@id='site-logo-inner']")
    private WebElement logotype;

    public HomePage(WebDriver webDriver) {
        super(webDriver,"");
    }

    public void openPage() {
        try {
            webDriver.get("https://medizine.eu");
            logger.info("HomePage was opened");
        } catch (Exception e) {
            logger.error("Can not open HomePage");
            Assert.fail("Can not open HomePage");
        }
    }

    public void clickOnLinkMoyAccaunt() {
    workWithOurElements.clickOnElement(MoyAccaunt);
    }

    public boolean isLogotypePresen() {
        return workWithOurElements.isElementDisplayed(logotype);
    }
}

