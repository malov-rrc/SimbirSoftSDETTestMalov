package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс для взаимодействия со страницей корзины
 */
public class BucketPage {

    /**
     * Приватный экземпляр драйвера
     */
    private WebDriver driver;

    /**
     * Элемент с кнопкой "Checkout"
     */
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;


    /**
     * Конструктор класса
     *
     * @param driver экземпляр драйвера
     */
    public BucketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    /**
     * Нажатие на кнопку "Checkout"
     */
    @Step("Нажатие на кнопку 'Checkout'")
    public void clickCheckoutButton() throws InterruptedException {
        checkoutButton.click();
        Thread.sleep(7000);
    }
}