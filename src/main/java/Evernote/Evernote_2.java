package Evernote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class Evernote_2 {
    private static final String LOGIN_PAGE_URL = "https://evernote.com/intl/ru/";
    private static final String LOGIN = "alishkasun@mail.ru";
    private static final String PASSWORD = "galileo";
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
        driver.findElement(By.linkText("Войти")).click();

        WebElement loginTextInput = driver.findElement(By.cssSelector("#username"));
        loginTextInput.sendKeys(LOGIN);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#loginButton")).click();

        WebElement passwordTextInput = driver.findElement(By.cssSelector("#password"));
        passwordTextInput.sendKeys(PASSWORD);
        Thread.sleep(2000);


        driver.findElement(By.cssSelector("#loginButton")).click();

        System.out.println("Авторизация прошла успешно");

        // Убираем окно с обновлениями
        sleep(2000);
        driver.findElement(By.className("_2B9LL_OBdYaX4kwsrCNAJe")).click();

        driver.findElement(By.cssSelector(".wUBGPuRifGLfhCnZb8HqO > g > path:nth-child(1)")).click();


        driver.switchTo().frame("qa-COMMON_EDITOR_IFRAME");

        // кликаем на Название
        sleep(2000);
        driver.findElement(By.cssSelector(".\\_3wdDa")).click();
        driver.findElement(By.cssSelector(".\\_3wdDa")).sendKeys("Lesson1");// driver.switchTo().defaultContent();

        System.out.println("Запись Lesson1 создана");

        driver.findElement(By.cssSelector("#en-note")).click();
        driver.findElement(By.cssSelector("#en-note")).sendKeys("Я учусь");
        driver.switchTo().defaultContent();

        System.out.println("Запись Я учусь... создана");

        driver.findElement(By.cssSelector("#qa-NAV_HOME > .CWUfwyPerYximB8JPVb69")).click();

        driver.close();
        driver.quit();
    }
}

