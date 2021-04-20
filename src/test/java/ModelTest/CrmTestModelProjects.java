package ModelTest;

import Model.Pages.HomePage;
import Model.common.Values;
import org.junit.jupiter.api.*;

public class CrmTestModelProjects extends BaseTest {


    @Test
    void fillingOutProjectForms() {

        HomePage homePage = new HomePage(driver);
        homePage.checkUrl(Values.BASE_URL);
        homePage
                .moveToProject()
                .clickOnCreateNewProjectButton()
                .enterDescription(Values.PROJECT_DESCRIPTION)
                .enterDescription_2(Values.PROJECT_DESCRIPTION_2)
                .selectBusinessUnit(Values.BUSINESS_UNIT)
                .selectBusinessCurator(Values.BUSINESS_CURATOR)
                .selectRpName(Values.RM_NAME)
                .selectAdministratorName(Values.ADMINISTRATOR_NAME)
                .selectManagerName(Values.MANAGER_NAME)
                .clickSubmit();

    }
}
