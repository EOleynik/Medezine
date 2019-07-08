package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

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

    public void mouseDown() {
        Locatable mouseDownItem = (Locatable) webDriver.findElement
                (By.xpath("//*[@id='ocean_social-2']"));

        Mouse mouse = ((HasInputDevices) webDriver).getMouse();
        mouse.mouseDown(mouseDownItem.getCoordinates());
    }

    public void clickOnButtonVkorziny() {
        workWithOurElements.clickOnElement(buttonVkorziny);
    }

    public void clickOnLinkProsmotrKorzıny() {
        workWithOurElements.clickOnElement(prosmotrKorzıny);
    }
}
