package Crm1Test;

import Crm.Crm_1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Crm_1Test {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest1";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;
    private static WebDriverWait webDriverWait5sec;

    private static final String projectName = "ali23211";
    private static final String  businessUnitName = "Research & Development";
    private static final String curatorName = "Амелин Владимир";
    private static final String rpName = "Коблев Евгений";
    private static final String administratorName = "Амелина Светлана";
    private static final String managerName = "Юзеров Юзер";


    @BeforeAll
    static void setUpWebDriverManager(){

         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-notifications");
         options.addArguments("--disable-popup-blocking");

         driver = new ChromeDriver(options);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         webDriverWait5sec = new WebDriverWait(driver, 5);
}


    @BeforeEach
    @Tag("Login")
     void  myLogin(){
        driver.get(LOGIN_PAGE_URL);
        assertEquals(driver.getCurrentUrl(),LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        String user = loginTextInput.getAttribute("value");
        assertEquals(STUDENT_LOGIN, user);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        String password = passwordTextInput.getAttribute("value");
        assertEquals(STUDENT_PASSWORD,password);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }

    @Test
     void fillingOutProjectForms() {

        driver.findElement(By.cssSelector(".logo > a"));

        //Кликаем проекты

        driver.findElement(By.xpath("//span[contains(.,'Проекты')]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown:nth-child(3) .single:nth-child(4) .title")));
        driver.findElement(By.cssSelector(".dropdown:nth-child(3) .single:nth-child(4) .title")).click();

        // кликаем на кнопку Создать проект

        driver.findElement(By.linkText("Создать проект")).click();

        //Кликаем на поле Наименование
//        WebElement fieldProjectName = driver.findElement(By.name("crm_project[name]"));
        //     fieldProjectName.sendKeys(projectName);
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("crm_project[name]")));
//        driver.findElement(By.name("crm_project[name]")).click();

        //Наименование орагизации
        WebElement projectNameOrg = driver.findElement(By.name("crm_project[name]"));
        projectNameOrg.sendKeys(projectName);
        assertEquals(projectName, driver.findElement(By.name("crm_project[name]")).getAttribute("value"));


        //Организация
        driver.findElement(By.cssSelector(".select2-default > .select2-chosen")).click();

        driver.findElement(By.cssSelector(".select2-focused")).sendKeys("1234");

        driver.findElement(By.cssSelector(".select2-match")).click();


        //Подразделение
        driver.findElement(By.name("crm_project[businessUnit]")).click();

        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText(businessUnitName);
        assertEquals(businessUnitName, businessUnit.getFirstSelectedOption().getText());


        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText(curatorName);
        assertEquals(curatorName, curator.getAllSelectedOptions().get(3).getText());


        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText(rpName);
        assertEquals(rpName, rp.getAllSelectedOptions().get(20).getText());


        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText(administratorName);
        assertEquals(administratorName, administrator.getAllSelectedOptions().get(3).getText());


        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText(managerName);
        assertEquals(managerName, administrator.getAllSelectedOptions().get(21).getText());

        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();

    }

    @AfterEach
     void closeDriver(){
        driver.close();
    }

        @AfterAll
    static void tearDown(){
            driver.quit();
        }
}
