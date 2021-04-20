package EvernoteTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenoteTest2 {

    private static final String LOGIN_PAGE_URL = "https://evernote.com/intl/ru/";
    private static WebDriver driver;
    private static final String projectNameLog = "alishkasun@mail.ru";
    private static final String projectPasswordLog = "galileo";
    private static final String evoTitle = "Lesson1";
    private static final String evoText = "Я учусь";

    @BeforeAll
    static void setUpWebDriverManager(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    void myLoginEvo() {
        driver.get(LOGIN_PAGE_URL);
        assertEquals(driver.getCurrentUrl(),LOGIN_PAGE_URL);

        //Войти
        driver.findElement(By.linkText("Войти")).click();

        //Логинимся
        WebElement projectNameLogEvo = driver.findElement(By.cssSelector("#username"));
        projectNameLogEvo.sendKeys(projectNameLog);
        assertEquals(projectNameLog, driver.findElement(By.cssSelector("#username")).getAttribute("value"));

        driver.findElement(By.cssSelector("#loginButton")).click();

        WebElement projectPasswordLogEvo = driver.findElement(By.cssSelector("#password"));
        projectPasswordLogEvo.sendKeys(projectPasswordLog);
        assertEquals(projectPasswordLog , driver.findElement(By.cssSelector("#password")).getAttribute("value"));

        driver.findElement(By.cssSelector("#loginButton")).click();

        // Убираем окно с обновлениями

        driver.findElement(By.className("_2B9LL_OBdYaX4kwsrCNAJe")).click();

        driver.findElement(By.cssSelector(".wUBGPuRifGLfhCnZb8HqO > g > path:nth-child(1)")).click();

        driver.switchTo().frame("qa-COMMON_EDITOR_IFRAME");

        // кликаем на Название
        driver.findElement(By.cssSelector(".\\_3wdDa")).click();

      //  driver.findElement(By.cssSelector(".\\_3wdDa")).sendKeys("Lesson1");// driver.switchTo().defaultContent();
        WebElement evoTitleLesson = driver.findElement(By.cssSelector(".\\_3wdDa"));
        evoTitleLesson.sendKeys(evoTitle);
        assertEquals(evoTitle, driver.findElement(By.cssSelector(".\\_3wdDa")).getAttribute("value"));

        driver.findElement(By.cssSelector("#en-note")).click();

       // driver.findElement(By.cssSelector("#en-note")).sendKeys("Я учусь");
        WebElement evoTextLesson = driver.findElement(By.cssSelector("#en-note"));
        evoTextLesson.sendKeys(evoText);
        assertEquals(evoText, driver.findElement(By.cssSelector("#en-note")).getAttribute("value"));

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#qa-NAV_HOME > .CWUfwyPerYximB8JPVb69")).click();

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
