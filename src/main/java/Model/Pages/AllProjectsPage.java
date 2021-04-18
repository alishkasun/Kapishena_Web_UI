package Model.Pages;

import Model.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllProjectsPage extends BaseView {

    //@FindBy(linkText = "Создать проект")
    private WebElement createNewProjectButton = driver.findElement(By.linkText("Создать проект"));

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
        return new NewProjectPage(driver);
    }

//    public AllProjectsPage checkNewProjectPopUp() {
//        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
//            "div[class='message']"))).getText();
//        assertTrue(message.contains("Заявка на расход сохранена"));
//        return this;
//    }

}
