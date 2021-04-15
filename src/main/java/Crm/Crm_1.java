package Crm;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class Crm_1 {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space";
    private static final String STUDENT_LOGIN = "Applanatest1";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;
    private static  WebDriverWait webDriverWait5sec;


    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriverWait5sec = new WebDriverWait(driver, 5);
    }
    public static void main(String[] args) throws InterruptedException {

        //Логинимся
        driver.get(LOGIN_PAGE_URL);
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        Thread.sleep(2000);

        //new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[contains(@class, 'login-body')]")));

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
        Thread.sleep(5000);


        driver.findElement(By.cssSelector(".logo > a"));
        //Кликаем проекты

        driver.findElement(By.xpath("//span[contains(.,'Проекты')]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown:nth-child(3) .single:nth-child(4) .title")));

        driver.findElement(By.cssSelector(".dropdown:nth-child(3) .single:nth-child(4) .title")).click();
     //   new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".dropdown:nth-child(3) .single:nth-child(4) .title")));

        // кликаем на кнопку Создать проект

        driver.findElement(By.linkText("Создать проект")).click();

        //Кликаем на поле Наименование
        sleep(5000);
        driver.findElement(By.name("crm_project[name]")).click();

        //Наименование орагизации

        driver.findElement(By.name("crm_project[name]")).sendKeys("ali1");


        //Организация
        sleep(5000);
        driver.findElement(By.cssSelector(".select2-default > .select2-chosen")).click();

        driver.findElement(By.cssSelector(".select2-focused")).sendKeys("1234");

        driver.findElement(By.cssSelector(".select2-match")).click();


        //Подразделение
        sleep(3000);
        driver.findElement(By.name("crm_project[businessUnit]")).click();

        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");


        Select curator = new Select(driver.findElement(By.name("crm_project[curator]"))) ;
        curator.selectByVisibleText("Амелин Владимир");


        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText("Коблев Евгений");

        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Амелина Светлана");

        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Юзеров Юзер");

        sleep(2000);
        //driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();


        driver.close();
        driver.quit();
    }
}

