package homePage;

import org.junit.Test;
import parentTest.ParentTest;

public class OpenHomePageTest extends ParentTest {

    @Test
    public void openHomePage(){
       homePage.openPage();
       homePage.checkCurrentUrl();

       checkExpectedResult("Can not open Home page",
               true,homePage.isLogotypeDisplayed());
    }
}
