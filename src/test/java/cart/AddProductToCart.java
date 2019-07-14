package cart;

import org.junit.Test;
import parentTest.ParentTest;

public class AddProductToCart extends ParentTest {

    @Test
    public void addProductToCart(){
        homePage.openPageWithCheckUrl();
        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Детоксил");
        storePage.clickOnButtonVkorziny();
        storePage.clickOnLinkProsmotrKorzıny();

        checkExpectedResult("",true,cartPage.isProductDisplayed());
    }

    @Test

    public void addProductToEmptyCart() {
        homePage.openPageWithCheckUrl();
        homePage.checkStatusCart();
        homePage.clickOnIconPoisk();  // мы остаемся на страничке Cart
        homePage.enterTextInToInputPoisk("Детоксил");


        storePage.clickOnButtonVkorziny();
        storePage.clickOnLinkProsmotrKorzıny();

        checkExpectedResult("Product not added to cart",true,cartPage.isProductDisplayed());
    }


}
