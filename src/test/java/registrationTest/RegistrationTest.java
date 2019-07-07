package registrationTest;

import org.junit.Test;
import parentTest.ParentTest;

public class RegistrationTest extends ParentTest {

    @Test
    public void validRegistration (){
        homePage.openPage();
        homePage.checkCurrentUrl();
        homePage.clickOnLinkMoyAccaunt();

        myAccountPage.checkCurrentUrl();
        myAccountPage.enterTextInToInputEmail("avtotest@ukr.net");
        myAccountPage.clickButtonRegıstratcia();

        checkExpectedResult("Registration failed, user info is not present",
                true,myAccountPage.IsUserInfoPresent());
    }

}
