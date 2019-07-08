package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.logging.Logger;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//a[@href='/my-account/orders/' and @class='menu-link']")
    private Link moyAccaunt;
    @FindBy(xpath = ".//div[@id='site-logo-inner']")
    private WebElement logotype;
    @FindBy(xpath = ".//li[@id='menu-item-3315']")
    private Link katalog;
    @FindBy(xpath = "//ul[@id='menu-main-menu-2']/li[5]")
    private Link korzina;
    @FindBy(xpath = ".//div[@class='wps_add_to_cart']")
    private Button vKorziny;
    @FindBy(xpath = ".//li[@class='search-toggle-li']")
    private Link iconPoisk;
    @FindBy(xpath = ".//input[@id='s']")
    private Link inputPoisk;

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
    workWithOurElements.clickOnElement(moyAccaunt);
    }

    public boolean isLogotypeDisplayed() {
        return workWithOurElements.isElementDisplayed(logotype);
    }

    public void clickOnLinkKatalog() {
        workWithOurElements.clickOnElement(katalog);
    }

    public void clickOnLinkKorzına() {
        workWithOurElements.clickOnElement(korzina);
    }

    public void clickButtonVKorziny() {
        workWithOurElements.clickOnElement(vKorziny);
    }

    public void clickOnIconPoisk() {
        workWithOurElements.clickOnElement(iconPoisk);
    }

    public void enterTextInToInputPoisk(String text) {
        workWithOurElements.enterTextToInputWithReturn(inputPoisk, text);
    }
}

