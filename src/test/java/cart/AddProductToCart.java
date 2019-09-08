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
        homePage.clickOnIconPoisk();
        homePage.enterTextInToInputPoisk("Детоксил");

        storePage.clickOnButtonVkorziny();
        storePage.clickOnLinkProsmotrKorzıny();

        checkExpectedResult("Product not added to cart",true,cartPage.isProductDisplayed());
    }

    @Test
    public void addProductAfterLogin(){

        myAccountPage.loginWithCred("avtotest@i.ua", "avtotest19");
        myAccountPage.IsUserInfoPresent();

        homePage.clickOnInputBystryiPoısk();
        homePage.enterTextInToInputBystryiPoisk("Детоксил");

        storePage.clickOnButtonVkorziny();

        checkExpectedResult("Product doesn't added to cart",true,cartPage.isProductDisplayed());

    }

}
