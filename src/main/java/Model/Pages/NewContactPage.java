package Model.Pages;

import Model.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewContactPage extends BaseView {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastNameOrg;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstNameOrg;

    @FindBy(css = ".select2-focused")
    private WebElement NameOrgContact;


    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement JobTitle;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement submitButtonCon;

    public NewContactPage (WebDriver driver) {
        super(driver);
    }

    public NewContactPage enterDescriptionLastName(String description) {
        lastNameOrg.sendKeys(description);
        return this;
    }

    public NewContactPage enterDescriptionFirstName(String description) {
        firstNameOrg.sendKeys(description);
        return this;
    }

    public NewContactPage enterDescriptionNameOrgContact(String description) {
        NameOrgContact.sendKeys(description);
        return this;
    }

    public NewContactPage enterDescriptionJobTitle(String description) {
        JobTitle.sendKeys(description);
        return this;
    }

    public AllContactPage clickSubmitCon() {
        submitButtonCon.click();
        return new AllContactPage(driver);
    }


}
