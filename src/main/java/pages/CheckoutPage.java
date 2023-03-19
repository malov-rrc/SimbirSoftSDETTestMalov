package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс для взаимодействия со страницей "Checkout"
 */
public class CheckoutPage {

    /**
     * Приватный экземпляр драйвера
     */
    private WebDriver driver;

    /**
     * Элемент с полем "FirstName"
     */
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    /**
     * Элемент с полем "LastName"
     */
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    /**
     * Элемент с полем "ZipCode"
     */
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;

    /**
     * Элемент с кнопкой "Continue"
     */
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    /**
     * Элемент с кнопкой "Finish"
     */
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    /**
     * Элемент с сообщением на странице
     */
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement finishMessage;


    /**
     * Конструктор класса
     *
     * @param driver экземпляр драйвера
     */
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    /**
     * Заполнение полей "FirstName", "LastName", "ZipCode"
     */
    @Step("Заполнение полей 'FirstName', 'LastName', 'ZipCode'")
    public CheckoutPage enterFields(String firstName, String lastName, String zipCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    /**
     * Нажатие на кнопку "Continue"
     */
    @Step("Нажатие на кнопку 'Continue'")
    public void clickContinueButton() throws InterruptedException {
        continueButton.click();
        Thread.sleep(7000);
    }

    /**
     * Нажатие на кнопку "Finish"
     */
    @Step("Нажатие на кнопку 'Finish'")
    public void clickFinishButton() throws InterruptedException {
        finishButton.click();
        Thread.sleep(7000);
    }

    /**
     * Возвращение надписи на конечной странице
     */
    @Step("Возвращение надписи на конечной странице")
    public String getMessage() {
        return finishMessage.getText();
    }
}