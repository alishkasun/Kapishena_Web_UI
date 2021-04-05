package Crm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Crm_2 {


    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

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
        sleep(5000);
        driver.findElement(By.cssSelector(".first > .unclickable > .title")).click();

        sleep(5000);
        driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]")).click();

        sleep(5000);
        driver.findElement(By.xpath("(//a[contains(text(),'Создать контактное лицо')])[3]")).click();

        //Фамилия
//        sleep(5000);
//        driver.findElement(By.name("crm_contact[lastName]")).click();

        sleep(2000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Капишена");

//        sleep(5000);
//        driver.findElement(By.name("crm_contact[lastName]")).click();

        //Имя

        sleep(2000);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Алина");

        //Организация
        sleep(5000);
        driver.findElement(By.cssSelector(".select2-arrow")).click();

        sleep(2000);
        driver.findElement(By.cssSelector(".select2-focused")).sendKeys("1234");

        sleep(5000);
        driver.findElement(By.cssSelector(".select2-match")).click();

        //Должность
        sleep(2000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("инженер");

        sleep(5000);
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();


        driver.quit();
    }
}
