package pages;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * Класс для взаимодействия со страницей авторизации
 */
public class AutorizationPage {

    /**
     * Приватный экземпляр драйвера
     */
    private WebDriver driver;

    /**
     * Элемент с полем для ввода логина
     */
    private WebElement loginField;

    /**
     * Элемент с полем для ввода пароля
     */
    private WebElement passwordField;

    /**
     * Элемент с кнопкой "Login"
     */
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    /**
     * Элемент с сообщением об ошибке
     */
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    /**
     * Конструктор класса
     *
     * @param driver экземпляр драйвера
     */
    public AutorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Ввод логина
     */
    @Step("Ввод логина")
    public AutorizationPage enterLogin(String login) {
        loginField = driver.findElement(By.id("user-name"));
        loginField.sendKeys(login);
        return this;
    }

    /**
     * Ввод пароля
     */
    @Step("Ввод пароля")
    public AutorizationPage enterPassword(String password) {
        passwordField = driver.findElement(By.cssSelector("input[name='password']"));
        passwordField.sendKeys(password);
        return this;
    }

    /**
     * Нажатие на кнопку "Login"
     */
    @Step("Нажатие на кнопку 'Login'")
    public void clickLogin() throws InterruptedException {
        loginButton.click();
        Thread.sleep(7000);
    }

    /**
     * Возвращение сообщения об ошибке
     */
    @Step("Возвращение сообщения об ошибке")
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}