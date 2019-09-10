package cart;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentTest.ParentTest;

public class DeleteProductFromCart extends ParentTest {


    @Test
    public void deleteProductsAfterAdding() throws InterruptedException {
        homePage.openPageWithCheckUrl();
        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Велмен");

        storePage.clickOnButtonVkorziny();

        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Детоксил");

        storePage.clickOnButtonVkorziny();

        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Велвумен");

        storePage.clickOnButtonVkorziny();

        homePage.clickOnLinkKorzına();

        cartPage.checkCurrentUrl();
        cartPage.checkAddProductToCart();
        cartPage.deletUntilPresent();

    checkExpectedResult("Cart is not empty",
            true,cartPage.isNoticeDisplayed());
    }


    @Test
    public void cleanTheCartAfterLogin() throws InterruptedException {
        myAccountPage.loginWithCred("avtotest@i.ua", "avtotest19");
        myAccountPage.IsUserInfoPresent();

        homePage.clickOnLinkKorzına();

        cartPage.checkCurrentUrl();
        cartPage.cleanTheCart();

        checkExpectedResult("Cart is not empty",
                true,cartPage.isNoticeDisplayed());
    }
}
