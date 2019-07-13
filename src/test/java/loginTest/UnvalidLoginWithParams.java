package loginTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class UnvalidLoginWithParams extends ParentTest {
    String userName, pass;

    public UnvalidLoginWithParams(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parametrs are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object [][]{
                {"avtotest","avtotest"},
                {"avtotest","pass"},
                {"login","pass"}
        });
    }

    @Test
    public void unvalidLogin() {
        myAccountPage.loginWithCred(userName, pass);

        checkExpectedResult("Avatar should not be present"
                , false
                , myAccountPage.IsUserInfoPresent());
    }

}
