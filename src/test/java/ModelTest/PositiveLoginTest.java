package ModelTest;

import Model.Pages.LoginPage;
import Model.common.Values;
import org.junit.jupiter.api.Test;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
           .enterLogin(Values.STUDENT_LOGIN)
            .enterPassword(Values.STUDENT_PASSWORD)
            .clickLoginButton()
            .checkUrl(Values.BASE_URL);
    }
}
