package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class MyAccountPage extends ParentPage {

    @FindBy(xpath = ".//input[@id='username']")
    private TextInput InputUserName;
    @FindBy(xpath = ".//input[@id='password']")
    private TextInput InputPass;
    @FindBy(xpath = ".//button[@name='login']")
    private Button ButtonVoiti;
    @FindBy(xpath = ".//div[@class='user-info']")
    private WebElement userInfo;
    @FindBy(xpath = ".//input[@id='reg_email']")
    private TextInput InputEmail;
    @FindBy(xpath = ".//button[@name='register']")
    private Button buttonRegistrasiia;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver, "my-account/orders/");
    }

    public void enterTextInToInputUserName(String login) {
        workWithOurElements.enterTextToInput(InputUserName, login);
    }

    public void enterTextInToInputPass(String pass) {
        workWithOurElements.enterTextToInput(InputPass,pass);
    }

    public void clickButtonVoiti() {
        workWithOurElements.clickOnElement(ButtonVoiti);
    }

    public boolean IsUserInfoPresent() {
        return workWithOurElements.isElementDisplayed(userInfo);
    }

    public void enterTextInToInputEmail(String Email) {
        workWithOurElements.enterTextToInput(InputEmail,Email);
    }

    public void clickButtonRegıstratcia() {
        workWithOurElements.clickOnElement(buttonRegistrasiia);
    }

    public void loginWithCred(String userName, String pass) {
        HomePage homePage = new HomePage(webDriver);
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);

        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.clickOnLinkMoyAccaunt();

        myAccountPage.checkCurrentUrl();
        enterTextInToInputUserName(userName);
        enterTextInToInputPass(pass);
        clickButtonVoiti();
    }


}
