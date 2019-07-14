package filters;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class ProductFiltersTests extends ParentTest {

    @Test
    public void productFilterByBrand(){
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
    public void productFilterByBrandAndPrice() {
        homePage.openPageWithCheckUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.scrollDown(500);
        storePage.selectNameBrandFromDropDown("Дефлю");
        storePage.scrollDown(50);
        storePage.clickOnElementToolbarFiltr();
//      storePage.scrollByVisibleElementFıltrPoTsene(); // это я верну когда уберут рекламу (после 22.07)
        storePage.enterTextInToInputOt("100");
        storePage.enterTextInToInputDo("120");
        storePage.clickOnButtonPrimenit();

       checkExpectedResult("Product of another brand","Дефлю",
               storePage.getNameBrand());
       checkExpectedResult("Price of goods outside the specified range",storePage.checkPrice("100","120"));
    }


}
