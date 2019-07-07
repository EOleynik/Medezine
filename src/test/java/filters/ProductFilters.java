package filters;

import org.junit.Test;
import parentTest.ParentTest;

public class ProductFilters extends ParentTest {

    @Test
    public void productFilterByBrand(){
        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.selectNameBrandFromDropDown("Дефлю");

        brendDefluPage.checkCurrentUrl();

        checkExpectedResult("",true,brendDefluPage.isLogotypeDisplayed());
    }

}
