package cart;

import org.junit.Test;
import parentTest.ParentTest;

public class AddProductToCart extends ParentTest {

    @Test
    public void addProductToCart(){
        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Детоксил");
        storePage.clickOnButtonVkorziny();
        storePage.clickOnLinkProsmotrKorzıny();

        checkExpectedResult("",true,cartPage.isProductDisplayed());
    }

    @Test

    public void addProductToEmptyCart() {
        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.checkStatusCart();
        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Детоксил");
        storePage.clickOnButtonVkorziny();
        storePage.clickOnLinkProsmotrKorzıny();

    }


}
