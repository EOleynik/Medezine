package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class WorkWithOurElements {
    WebDriver webDriver;
    Logger loger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;

    public WorkWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver,2);
        wait15 = new WebDriverWait(webDriver,5);
    }

    public void enterTextToInput (TypifiedElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            loger.info(text + " was inputted into" + " " + element.getName());
        }catch(Exception e){
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(WebElement webElement) {
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            loger.info("Element was clicked");
        }catch (Exception e) {
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(TypifiedElement webElement) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            loger.info("Element" + " " + webElement.getName() + " " + "was clicked");
        } catch (Exception e) {
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(String locator) {
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
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

    public void selectTextInDropDown(TypifiedElement dropDown, String nameBrand) {
        clickOnElement(dropDown);
        clickOnElement(".//option[contains(text(),'"+nameBrand+"')]");
    }

    public void enterTextToInputWithReturn(TypifiedElement element, String text) {
        try{
            element.clear();
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);
            loger.info(text + " was inputted into" + " " + element.getName());
        }catch(Exception e){
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void ScrollByPixel (Integer pix) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy (0," + pix + ")");
    }

}
