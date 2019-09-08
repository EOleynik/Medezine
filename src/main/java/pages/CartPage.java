package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ParentPage {

    @FindBy(xpath = ".//p[@class='cart-empty woocommerce-info']")
    private WebElement notice;
    @FindBy(xpath = ".//a[contains(text(),'Детоксил')]")
    private WebElement product;
    @FindBy(xpath = ".//tbody/tr[1]/td[@class='product-remove']")
    private WebElement remove;

    public CartPage(WebDriver webDriver) {
        super(webDriver, "cart/");
    }

    public boolean isNoticeDisplayed() {
        return workWithOurElements.isElementDisplayed(notice);
    }

    public boolean isProductDisplayed() {
        return workWithOurElements.isElementDisplayed(product);
    }


    public void checkAddProductToCart() {
        CartPage cartPage = new CartPage(webDriver);
        Assert.assertFalse("Cart is empty ", cartPage.isNoticeDisplayed());
    }

    public void checkStatusCart() {
        workWithOurElements.isElementDisplayed(notice);
           }

    public boolean isElementInCart(WebElement webElement) {
        return workWithOurElements.isElementDisplayed(".//tbody/tr[1]/td[@class='product-remove']");
    }

    public void deletUntilPresent() throws InterruptedException {
        int counter = 0;
        while (isElementInCart(remove)) {
            workWithOurElements.clickOnElement(".//tbody/tr[1]/td[@class='product-remove']");
            Thread.sleep(4000);
            logger.info((counter + 1) + " " + "Element was deletted");
            if (counter > 100){
                Assert.fail("There are more than 100 elements. ");
            }
            counter++;
        }
    }

    public void cleanTheCart() {
        if(isNoticeDisplayed()== false)
        try {
            deletUntilPresent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }else
        {logger.info("cart is empty");
        }
}}
