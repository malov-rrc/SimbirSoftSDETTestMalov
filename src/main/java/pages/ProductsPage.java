package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс для взаимодействия со страницей Prosucts
 */
public class ProductsPage {

    /**
     * Приватный экземпляр драйвера
     */
    private WebDriver driver;

    /**
     * Элемент с кнопкой "AddToCart"
     */
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack'][1]")
    private WebElement addToCartButton;

    /**
     * Элемент с кнопкой корзины
     */
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement bucketButton;

    /**
     * Конструктор класса
     *
     * @param driver экземпляр драйвера
     */
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    /**
     * Нажатие на кнопку "AddToCart"
     */
    @Step("Нажатие на кнопку 'AddToCart'")
    public ProductsPage clickAddToCart() {
        addToCartButton.click();
        return this;
    }

    /**
     * Нажатие на кнопку корзины
     */
    @Step("Нажатие на кнопку корзины")
    public void clickBucketButton() throws InterruptedException {
        bucketButton.click();
        Thread.sleep(7000);
    }
}
