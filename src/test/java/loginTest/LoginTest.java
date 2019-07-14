package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin(){
    homePage.openPageWithCheckUrl();
    homePage.clickOnLinkMoyAccaunt();

    myAccountPage.checkCurrentUrl();
    myAccountPage.enterTextInToInputUserName("avtotest");
    myAccountPage.enterTextInToInputPass("avtotest19");
    myAccountPage.clickButtonVoiti();

    checkExpectedResult("Authorization failed, user info is not present",
            true,myAccountPage.IsUserInfoPresent());
    }

    @Test
    public void unvalidLogin(){
        myAccountPage.loginWithCred("avtotest","avtotest");

        checkExpectedResult("User info should not be present",
                false,myAccountPage.IsUserInfoPresent());
    }
}
