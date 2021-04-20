package ModelTest;

import Model.Pages.LoginPage;
import Model.common.Values;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
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
