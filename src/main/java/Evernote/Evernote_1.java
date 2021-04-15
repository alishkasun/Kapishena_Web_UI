package Evernote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Evernote_1 {

        private static final String LOGIN_PAGE_URL = "https://evernote.com/intl/ru/";

        private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
        public static void main(String[] args) throws InterruptedException {

            driver.get(LOGIN_PAGE_URL);

             //Войти
            sleep(5000);
            driver.findElement(By.linkText("Войти")).click();

            //Логинимся
            sleep(2000);
            driver.findElement(By.cssSelector("#username")).sendKeys("alishkasun@mail.ru");

            driver.findElement(By.cssSelector("#loginButton")).click();

            sleep(2000);
            driver.findElement(By.cssSelector("#password")).sendKeys("galileo");


            driver.findElement(By.cssSelector("#loginButton")).click();


            System.out.println("Авторизация прошла успешно");
            driver.close();
            driver.quit();
        }
    }

