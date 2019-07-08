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
        storePage.mouseDown();
        storePage.selectNameBrandFromDropDown("Дефлю");

        brandDefluPage.checkCurrentUrl();

        checkExpectedResult("",true,brandDefluPage.isLogotypeDisplayed());
    }

}
