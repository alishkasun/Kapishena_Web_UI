package Model.Pages;

import Model.BaseView;
import Model.common.Values;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {


    @FindBy(id = "prependedInput")
    public WebElement loginInput;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login() {
        driver.get(Values.BASE_URL + Values.LOGIN_PATH);

        LoginPage loginPage = new LoginPage(driver);


        loginPage.loginInput.sendKeys(Values.STUDENT_LOGIN);
        loginPage.passwordInput.sendKeys(Values.STUDENT_PASSWORD);

        loginPage.submitButton.click();
    }

    @Step(value = "Enter login {login}")
    public LoginPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step(value = "Enter password {password}")
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step(value = "Click login button")
    public HomePage clickLoginButton() {
        submitButton.click();
        return new HomePage(driver);
    }

}
