package Model.Pages;

import Model.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllContactPage extends BaseView {
    private WebElement createNewContactButton = driver.findElement(By.xpath("(//a[contains(text(),'Создать контактное лицо')])[3]"));

    public AllContactPage(WebDriver driver) {
        super(driver);
    }

    public NewContactPage clickOnCreateNewContactButton() {
        createNewContactButton.click();
        return new NewContactPage(driver);
    }
}
