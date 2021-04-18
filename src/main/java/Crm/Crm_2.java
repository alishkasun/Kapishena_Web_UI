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

public class Crm_2 {


    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space";
    private static final String STUDENT_LOGIN = "Applanatest1";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;
    private static  WebDriverWait webDriverWait5sec;

    static {
        WebDriverManager.chromedriver().setup();

        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
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

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
        Thread.sleep(5000);


        //Кликаем Контактные лица
        sleep(2000);
        driver.findElement(By.cssSelector(".first > .unclickable > .title")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Контактные лица')]")));

        driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]")).click();

        driver.findElement(By.xpath("(//a[contains(text(),'Создать контактное лицо')])[3]")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Капишена");

        //Имя

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Алина");

        //Организация
        sleep(5000);
        driver.findElement(By.cssSelector(".select2-arrow")).click();

        sleep(2000);
        driver.findElement(By.cssSelector(".select2-focused")).sendKeys("1234");

        driver.findElement(By.cssSelector(".select2-match")).click();

        //Должность
        sleep(2000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("инженер");

        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();

        driver.close();
        driver.quit();
    }
}
