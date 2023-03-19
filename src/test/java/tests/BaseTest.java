package tests;

import config.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Общий класс с настройками для всех тестов
 */
public class BaseTest {

    /**
     * Экземпляр драйвера
     */
    protected static WebDriver driver;

    /**
     * Переменные из конфиг-файла
     */
    private final String url = ConfigManager.getInstance().getProperty("url");

    /**
     * Метод для создания настроек для всех тестов, вызывается перед выполнением каждого теста
     */
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

    /**
     * Метод для действий после каждого теста
     */
    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}