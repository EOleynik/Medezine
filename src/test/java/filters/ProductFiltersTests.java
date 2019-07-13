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

        checkExpectedResult("",true,brandDefluPage.isLogotypeDisplayed());
    }

    @Test
    public void productFilterByBrandAndPrice(){
        homePage.openPageWithCheckUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.scrollDown(500);
        storePage.selectNameBrandFromDropDown("Дефлю");
        storePage.scrollDown(50);
        storePage.clickOnElementToolbarFiltr();
//      storePage.scrollByVisibleElementFıltrPoTsene();
        storePage.enterTextInToInputOt("100");
        storePage.enterTextInToInputDo("120");
        storePage.clickOnButtonPrimenit();

        checkExpectedResult("Product of another brand","Дефлю",
                storePage.getNameBrand());
        checkExpectedResult("Error",107.50 ,storePage.getPrice());
    }


}
