package Model;

import org.openqa.selenium.By;

public enum ProjectSubMenuButtons implements SubMenuButtons {

    PROJECTS_REQUEST("//div[@id='main-menu']/ul/li[3]/ul/li[4]/a/span");

    private final By by;

    ProjectSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
