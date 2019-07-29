package filters;

import org.junit.Test;
import parentTest.ParentTest;

public class ProductFiltersTests extends ParentTest {

    @Test
    public void sortingProductByBrand(){
        homePage.openPageWithCheckUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.scrollDown(500);
        storePage.selectNameBrandFromDropDown("Дефлю");

        brandDefluPage.checkCurrentUrl();

        checkExpectedResult("Brand logo is not displayed",true,
                brandDefluPage.isLogotypeDisplayed());
    }

    @Test
    public void sortingProductByBrandAndPrice() {
        homePage.openPageWithCheckUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.scrollDown(500);
        storePage.selectNameBrandFromDropDown("Дефлю");
        storePage.clickOnElementToolbarFiltr();
        storePage.enterTextInToInputOt("100");
        storePage.enterTextInToInputDo("120");
        storePage.clickOnButtonPrimenit();

       checkExpectedResult("Product of another brand","Дефлю",
               storePage.checkBrand("Дефлю"));
       checkExpectedResult("Price of goods outside the specified range",
               storePage.checkPrice("100","120"));
    }


}
