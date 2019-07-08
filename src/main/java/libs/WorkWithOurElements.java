package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class WorkWithOurElements {
    WebDriver webDriver;
    Logger loger = Logger.getLogger(getClass());

    public WorkWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
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
            webElement.click();
            loger.info("Element was clicked");
        }catch (Exception e) {
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnElement(TypifiedElement webElement) {
        try {
            webElement.click();
            loger.info("Element" + " " + webElement.getName() + " " + "was clicked");
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

    public void selectTextInDropDown(TypifiedElement dropDown, String text) {
        clickOnElement(dropDown);
        clickOnElement(".//option[@value='https://medizine.eu/brands/deflu/']");
    }

    public void enterTextToInputWithReturn(TypifiedElement element, String text) {
        try{
            element.clear();
            element.sendKeys(text + "\n");
            loger.info(text + " was inputted into" + " " + element.getName());
        }catch(Exception e){
            loger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
}
