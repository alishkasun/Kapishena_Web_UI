package ModelTest;

import Model.Pages.HomePage;
import Model.common.Values;
import org.junit.jupiter.api.Test;

public class CrmTestModelContacts extends BaseTest {

    @Test
    void fillingOutProjectForms() {

        HomePage homePage = new HomePage(driver);
        homePage.checkUrl(Values.BASE_URL);
        homePage
                .moveToContact()
                .clickOnCreateNewContactButton()
                .enterDescriptionLastName(Values.PROJECT_DESCRIPTION_LAST_NAME)
                .enterDescriptionFirstName(Values.PROJECT_DESCRIPTION_FIRST_NAME)
                .enterDescriptionNameOrgContact(Values.PROJECT_DESCRIPTION_ORG_NAME_CONTACT)
                .enterDescriptionJobTitle(Values.PROJECT_DESCRIPTION_JOB_TITLE)
                .clickSubmitCon();

    }
}