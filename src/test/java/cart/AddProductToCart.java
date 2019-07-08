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
}
