package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ParentPage {

    @FindBy(xpath = ".//p[@class='cart-empty']")
    private WebElement notice;
    @FindBy(xpath = ".//a[contains(text(),'Детоксил')]")
    private WebElement product;

    public CartPage(WebDriver webDriver) {
        super(webDriver, "cart/");
    }

    public boolean isNoticeDisplayed() {
        return workWithOurElements.isElementDisplayed(notice);
    }

    public boolean isProductDisplayed() {
        return workWithOurElements.isElementDisplayed(product);
    }


}
