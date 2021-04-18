package Model.Pages;

import Model.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class NewProjectPage extends BaseView {

        @FindBy(name = "crm_project[name]")
        private WebElement projectNameOrg;

    @FindBy(css = ".select2-focused")
    private WebElement NameOrg;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnitDropDownSelect;

    @FindBy(name = "crm_project[curator]")
    private WebElement businessCurator;

    @FindBy(name = "crm_project[rp]")
    private WebElement rpName;


    @FindBy(name = "crm_project[administrator]")
    private WebElement administratorName;


    @FindBy(name = "crm_project[manager]")
    private WebElement managerName;

    @FindBy(xpath = "//button[contains(.,'Сохранить и закрыть')]")
    private WebElement submitButton;



        public NewProjectPage (WebDriver driver) {
            super(driver);
        }

    public NewProjectPage enterDescription(String description) {
        projectNameOrg.sendKeys(description);
        return this;
    }
    public NewProjectPage enterDescription_2(String description) {
        NameOrg.sendKeys(description);
        return this;
    }

    public NewProjectPage selectBusinessUnit(int value) {
        Select businessUnitDropDown = new Select(businessUnitDropDownSelect);
        businessUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage selectBusinessCurator(String value) {
        Select businessCuratorOrg = new Select(businessCurator);
        businessCuratorOrg.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage selectRpName(String value) {
        Select rpNameOrg = new Select(rpName);
        rpNameOrg.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage selectAdministratorName(String value) {
        Select administratorNameOrg = new Select(administratorName);
        administratorNameOrg.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage selectManagerName(String value) {
        Select  managerNameOrg = new Select( managerName);
        managerNameOrg.selectByValue(String.valueOf(value));
        return this;
    }

    public AllProjectsPage clickSubmit() {
        submitButton.click();
        return new AllProjectsPage(driver);
    }


    }


