package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.regex.Pattern;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//a[@href='/my-account/orders/' and @class='menu-link']")
    private Link moyAccaunt;
    @FindBy(xpath = ".//div[@id='site-logo-inner']")
    private WebElement logotype;
    @FindBy(xpath = ".//li[@id='menu-item-3315']")
    private Link katalog;
    @FindBy(xpath = "//ul[@id='menu-main-menu-2']/li[5]")
    private Link korzina;
    @FindBy(xpath = ".//li[@class='search-toggle-li']")
    private Link iconPoisk;
    @FindBy(xpath = ".//input[@id='s']")
    private Link inputPoisk;
    @FindBy(xpath = ".//a[@href='/store/']")
    private WebElement perejtiVkatalog;
    @FindBy(xpath = ".//input[@id='product-search-field-0']")
    private TextBlock inputBystryiPoisk;

    public HomePage(WebDriver webDriver) {
        super(webDriver,"");
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

    public void clickOnIconPoisk() {
        workWithOurElements.clickOnElement(iconPoisk);
    }

    public void enterTextInToInputPoisk(String text) {
        workWithOurElements.enterTextToInputWithReturn(inputPoisk, text);
    }

    public void checkStatusCart() {
            workWithOurElements.clickOnElement(korzina);
            CartPage cartPage = new CartPage(webDriver);
            cartPage.checkCurrentUrl();
            Assert.assertTrue("Cart is not empty",cartPage.isNoticeDisplayed());
    }

    public void openPageWithCheckUrl() {
        try{
            webDriver.get("https://medizine.eu");
            logger.info("HomePage was opened");
            logger.info(expectedUrl);
            logger.info(webDriver.getCurrentUrl());
            Assert.assertEquals("",
                    Pattern.matches(expectedUrl,webDriver.getCurrentUrl()),true);
        }catch (Exception e) {
                logger.error("Can not open HomePage");
                Assert.fail("Can not open HomePage");
        }
    }

    public void clickOnLinkPerejtiVkatalog() {
        workWithOurElements.clickOnElement(perejtiVkatalog);
    }

    public void scrollDown(Integer pix) {
        workWithOurElements.scrollByPixel(pix);
    }

    public void clickOnInputBystryiPoısk() {workWithOurElements.clickOnElement(inputBystryiPoisk);
    }

    public void enterTextInToInputBystryiPoisk(String text) {
        workWithOurElements.enterTextToInputWithReturn(inputBystryiPoisk,text);
    }
}

