package filters;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static pages.ParentPage.configProperties;

@RunWith(Parameterized.class)
public class SortingProductWithFiltrsTestWithExcel extends ParentTest {
    String checkBox, nameBrand;

    public SortingProductWithFiltrsTestWithExcel(String checkBox,String nameBrand) {
        this.checkBox = checkBox;
        this.nameBrand = nameBrand;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit1.xls");
        return new SpreadsheetData(spreadsheet,"SortingByBrand").getData();
    }

    @Test
    public void sortingProductByBrands() throws InterruptedException {
        homePage.openPageWithCheckUrl();
        homePage.scrollDown(1500);
        homePage.clickOnLinkPerejtiVkatalog();

        storePage.checkCurrentUrl();
        storePage.clickOnElementToolbarFiltr();
        storePage.checkStatusCheckBox(checkBox);
        storePage.scrollByVisibleElementPrimenitFiltr();
        storePage.clickOnButtonPrimenitFiltr();

       checkExpectedResult("",true,storePage. checkProductsBrand(nameBrand));
    }

}
