package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class StorePage extends ParentPage {

    @FindBy(xpath = "//*[@id='pwb_dropdown_widget-2']")
    private TextBlock brands;
    @FindBy(xpath = ".//button[@class='single_add_to_cart_button button alt']")
    private Button buttonVkorziny;
    @Name("prosmotrKorzıny")
    @FindBy(xpath = ".//a[@class='added_to_cart wc-forward']")
    private Link prosmotrKorzıny;
    @FindBy(xpath = ".//a[@class='oceanwp-off-canvas-filter']")
    private Link filtr;
    @FindBy(xpath = ".//input[@value='deflu']")
    private CheckBox deflu;
    @FindBy(xpath = ".//h4[text()='Фильтр по цене']")
    private WebElement fıltrPoTsene;
    @FindBy(xpath = ".//input[@id='product-search-filter-min-price-0']")
    private TextBlock inputOt;
    @FindBy(xpath = ".//input[@id='product-search-filter-max-price-0']")
    private TextBlock inputDo;
    @FindBy(xpath = ".//button[@class='button']")
    private Button buttonPrimenit;
    @FindBy(xpath = ".//button[text()='Применить фильтр']")
    private WebElement primenitFiltr;

    public StorePage(WebDriver webDriver) {
        super(webDriver, "store/");
    }

    public void selectNameBrandFromDropDown(String nameBrand) {
        workWithOurElements.selectTextInDropDown(brands, nameBrand);
    }

    public void clickOnButtonVkorziny() {
        workWithOurElements.clickOnElement(buttonVkorziny);
    }

    public void clickOnLinkProsmotrKorzıny() {
        workWithOurElements.clickOnElement(prosmotrKorzıny);
    }

    public void scrollDown(Integer pix) {
        workWithOurElements.scrollByPixel(pix);
    }

    public void clickOnElementToolbarFiltr() {
        workWithOurElements.clickOnElement(filtr);
    }

    public void scrollByVisibleElementFıltrPoTsene() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        fıltrPoTsene = (WebElement) webDriver.findElement(By.xpath(".//button[text()='Применить фильтр']"));
        js.executeScript("arguments [0] .scrollIntoView ();", fıltrPoTsene);
    }

    public void enterTextInToInputOt(String value1) {
        workWithOurElements.enterTextToInput(inputOt, value1);
    }

    public void enterTextInToInputDo(String value2) {
        workWithOurElements.enterTextToInput(inputDo, value2);
    }

    public void clickOnButtonPrimenit() {
        workWithOurElements.clickOnElement(buttonPrimenit);
    }

    public String checkBrand(String nameBrand) {
        return (webDriver.findElement
                (By.xpath(".//a[contains(text(),'" + nameBrand + "')]")
                ).getText().split(" ")[0]);
    }

    public boolean checkPrice(String value1, String value2) {
        if (Double.parseDouble(webDriver.findElement
                (By.xpath(".//ul[@class='woo-entry-inner clr']/li[@class='inner']/span")
                ).getText().split(" ")[0]) > Double.parseDouble(value1)) {
            if (Double.parseDouble(webDriver.findElement
                    (By.xpath(".//ul[@class='woo-entry-inner clr']/li[@class='inner']/span")
                    ).getText().split(" ")[0]) < Double.parseDouble(value2)) {
                return true;
            }
        }
        return false;
    }

    public double getPrice() {
        return (Double.parseDouble(webDriver.findElement
                (By.xpath(".//ul[@class='woo-entry-inner clr']/li[@class='inner']/span")
                ).getText().substring(0, 6)));
    }

    public void checkStatusCheckBox(String checkBox) {
        if (webDriver.findElement(By.xpath
                (".//div[@class='pwb-filter-products']//ul//li//*[contains(@value,'" + checkBox + "')]")).isSelected()) {
        } else webDriver.findElement(By.xpath
                (".//div[@class='pwb-filter-products']//ul//li//*[contains(@value,'" + checkBox + "')]")).click();
    }


    public void scrollByVisibleElementPrimenitFiltr() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        primenitFiltr = (WebElement) webDriver.findElement(By.xpath(".//button[text()='Применить фильтр']"));
        js.executeScript("arguments [0] .scrollIntoView ();", primenitFiltr);
    }

    public void clickOnButtonPrimenitFiltr() {
        workWithOurElements.clickOnElement(primenitFiltr);
    }

    public boolean checkProductsBrand(String nameBrand) {
        ArrayList<WebElement> arrayList = new ArrayList<WebElement>();
        arrayList.addAll(webDriver.findElements
                (By.xpath(".//a[contains(text(),'" + nameBrand + "')]")));
         for (int i = 0; i < arrayList.size(); i++)
         {Assert.assertEquals(nameBrand,arrayList.get(i).getText().split(" ")[0]);
        }
        return true;
    }


}
