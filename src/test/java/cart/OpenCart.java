package cart;

import org.junit.Test;
import parentTest.ParentTest;

public class OpenCart extends ParentTest {

    @Test
    public void openingEmptyCart(){
        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.clickOnLinkKorzına();

        cartPage.checkCurrentUrl();

        checkExpectedResult("",true,cartPage.isNoticeDisplayed());
    }
}
