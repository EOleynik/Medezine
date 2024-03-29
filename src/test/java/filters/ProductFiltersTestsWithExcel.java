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
public class ProductFiltersTestsWithExcel extends ParentTest {

String nameBrand, value1, value2;

    public ProductFiltersTestsWithExcel(String nameBrand, String value1, String value2) {
        this.nameBrand = nameBrand;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1} and {2}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit1.xls");
        return new SpreadsheetData(spreadsheet, "FilterByBrandAndPrice").getData();
    }

    @Test
    public void productFilterByBrandAndPrice(){
        homePage.openPageWithCheckUrl();
        homePage.clickOnLinkKatalog();

        storePage.checkCurrentUrl();
        storePage.scrollDown(500);
        storePage.selectNameBrandFromDropDown(nameBrand);
        storePage.clickOnElementToolbarFiltr();
        storePage.enterTextInToInputOt(value1);
        storePage.enterTextInToInputDo(value2);
        storePage.clickOnButtonPrimenit();

        checkExpectedResult("Product of another brand",nameBrand,
                storePage.checkBrand(nameBrand));
        checkExpectedResult("Price of goods outside the specified range",
                storePage.checkPrice(value1,value2));
    }



}
