package Crm1Test;

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

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Crm_2Test {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest1";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;
    private static WebDriverWait webDriverWait5sec;

    private static final String lastName = "Капишена";
    private static final String firstName = "Алина";
    private static final String jobTitle = "инженер";

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
    void fillingOutProjectFormsContact() {

        //Кликаем Контактные лица
        driver.findElement(By.cssSelector(".first > .unclickable > .title")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Контактные лица')]")));

        driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]")).click();

        driver.findElement(By.xpath("(//a[contains(text(),'Создать контактное лицо')])[3]")).click();

        //Фамилия
        WebElement lastNameOrg = driver.findElement(By.name("crm_contact[lastName]"));
        lastNameOrg.sendKeys(lastName);
        assertEquals(lastName, driver.findElement(By.name("crm_contact[lastName]")).getAttribute("value"));

        //Имя
        WebElement firstNameOrg = driver.findElement(By.name("crm_contact[firstName]"));
        firstNameOrg.sendKeys(firstName);
        assertEquals(firstName, driver.findElement(By.name("crm_contact[firstName]")).getAttribute("value"));

        //driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Алина");

        //Организация

        driver.findElement(By.cssSelector(".select2-arrow")).click();

        driver.findElement(By.cssSelector(".select2-focused")).sendKeys("1234");

        driver.findElement(By.cssSelector(".select2-match")).click();

        //Должность
        WebElement jobTitleOrg = driver.findElement(By.name("crm_contact[jobTitle]"));
        jobTitleOrg.sendKeys(jobTitle);
        assertEquals(jobTitle, driver.findElement(By.name("crm_contact[jobTitle]")).getAttribute("value"));

        //driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("инженер");


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
