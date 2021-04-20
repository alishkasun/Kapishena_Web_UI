package Model.Pages;

import Model.BaseView;
import Model.common.Values;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.xml.ws.Action;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BaseView {

   @FindBy(xpath = ".//span[@class='title' and text()='Проекты']")
   public WebElement projects;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li[3]/ul/li[4]/a/span")
   public WebElement myProjects;

    @FindBy(xpath = ".//span[@class='title' and text()='Контрагенты']")
    public WebElement contragent;

    @FindBy(xpath = "//span[contains(.,'Контактные лица')]")
    public WebElement myContact;


    public HomePage(WebDriver driver){
       super(driver);
   }

    public void checkUrl(String baseUrl) {
        assertEquals(driver.getCurrentUrl(), Values.BASE_URL);
    }

    public AllProjectsPage moveToProject (){
        Actions action = new Actions(driver);
        action
                .moveToElement(projects)
                .build()
                .perform();
        myProjects.click();
        return new AllProjectsPage(driver);
    }

    public AllContactPage moveToContact (){
        Actions actionCon = new Actions(driver);
        actionCon
                .moveToElement(contragent)
                .build()
                .perform();
        myContact.click();
        return new AllContactPage(driver);
    }
}
