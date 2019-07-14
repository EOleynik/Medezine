package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandDefluPage extends ParentPage {

    @FindBy(xpath = ".//img[@src='https://medizine.eu/wp-content/uploads/Brands/deflu-min.jpg']")
    private WebElement logotypeDeflu;

    public BrandDefluPage(WebDriver webDriver) {
        super(webDriver, "brands/deflu/");
    }


    public boolean isLogotypeDisplayed() {
        return workWithOurElements.isElementDisplayed(logotypeDeflu);
    }
}
