package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import javax.lang.model.element.Element;

public class StorePage extends ParentPage {

    @FindBy(xpath = "//*[@id='pwb_dropdown_widget-2']")
    private TextBlock brands;
    @FindBy(xpath = ".//button[@class='single_add_to_cart_button button alt']")
    private Button buttonVkorziny;
    @FindBy(xpath = ".//a[@class='added_to_cart wc-forward']")
    private Link prosmotrKorzıny;

    public StorePage(WebDriver webDriver) {
        super(webDriver, "store/");
    }

    public void selectNameBrandFromDropDown(String nameBrand) {
    workWithOurElements.selectTextInDropDown(brands,nameBrand);

    }

//    public void ScrollByVisibleElement() {
//    JavascriptExecutor js = (JavascriptExecutor) webDriver;
//    brands = (TextBlock) webDriver.findElement (By.xpath("//*[@id='pwb_dropdown_widget-2']"));
//    js.executeScript ("arguments [0] .scrollIntoView ();", brands);
//}


    public void clickOnButtonVkorziny() {
        workWithOurElements.clickOnElement(buttonVkorziny);
    }

    public void clickOnLinkProsmotrKorzıny() {
        workWithOurElements.clickOnElement(prosmotrKorzıny);
    }

    public void scrollDown(Integer pix) {
        workWithOurElements.ScrollByPixel(500);
    }
}
