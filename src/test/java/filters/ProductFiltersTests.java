package filters;

import org.junit.Test;
import parentTest.ParentTest;

public class ProductFiltersTests extends ParentTest {

    @Test
    public void productFilterByBrand(){
        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.scrollDown(500);
        storePage.selectNameBrandFromDropDown("Дефлю");

        brandDefluPage.checkCurrentUrl();

        checkExpectedResult("",true,brandDefluPage.isLogotypeDisplayed());
    }

}
