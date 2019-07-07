package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkWithOurElements {
    WebDriver webDriver;
    Logger loger = Logger.getLogger(getClass());

    public WorkWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToInput (WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            loger.info(text + " was inputted into input");
        }catch(Exception e){
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            loger.info("Element was clicked");
        } catch (Exception e) {
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(String locator) {
        try{
            clickOnElement(webDriver.findElement(By.xpath(locator)));
            loger.info("Element was clicked");
        }catch (Exception e) {
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try{
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
