package Model;

import Model.Pages.AllContactPage;
import Model.Pages.AllProjectsPage;
import org.openqa.selenium.WebDriver;

public class ProjectSubMenu extends SubMenu {

    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ProjectsSubMenuButtons) {
            switch ((ProjectsSubMenuButtons) buttons) {
                case PROJECTS_REQUEST:
                    driver.findElement(((ProjectsSubMenuButtons) buttons).getBy()).click();
                    return new AllProjectsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }

    @Override
    public BaseView clickSubMenuButtonCon(SubMenuButtons buttons) {
        if (buttons instanceof ProjectsSubMenuButtons) {
            switch ((ProjectsSubMenuButtons) buttons) {
                case COUNTER_PARTIES:
                    driver.findElement(((ProjectsSubMenuButtons) buttons).getBy()).click();
                    return new AllContactPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }

}
