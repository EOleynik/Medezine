package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class StorePage extends ParentPage {

    @FindBy(xpath = ".//li[@id='menu-item-3315']")
    private TextBlock katalog;

    public StorePage(WebDriver webDriver) {
        super(webDriver, "store/");
    }

    public void selectNameBrandFromDropDown(String nameBrand) {
    workWithOurElements.selectTextInDropDown(katalog,nameBrand);

    }
}
