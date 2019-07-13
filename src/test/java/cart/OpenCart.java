package cart;

import org.junit.Test;
import parentTest.ParentTest;

public class OpenCart extends ParentTest {

    @Test
    public void openCart(){
        homePage.openPageWithCheckUrl();
        homePage.clickOnLinkKorzına();

        cartPage.checkCurrentUrl();

        checkExpectedResult("",true,cartPage.isNoticeDisplayed());
    }
}
