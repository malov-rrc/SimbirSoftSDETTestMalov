package tests;

import config.ConfigManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutorizationPage;
import pages.BucketPage;
import pages.CheckoutPage;
import pages.ProductsPage;


/**
 * Класс для работы с кейсом 1
 */
@Epic("Saucedemo")
public class SaucedemoPositive extends BaseTest {

    /**
     * Переменные из конфиг-файла
     */
    private final String loginPositive = ConfigManager.getInstance().getProperty("loginPositive");
    private final String passwordPositive = ConfigManager.getInstance().getProperty("passwordPositive");
    private final String checkoutInputFields = ConfigManager.getInstance().getProperty("checkoutInputFields");
    private final String expectedUrl = ConfigManager.getInstance().getProperty("expectedUrl");
    private final String expectedMessage = ConfigManager.getInstance().getProperty("expectedMessage");

    /**
     * Метод для проверки кейса 1
     */
    @Test
    @Description(value = "Кейс 1. Проверка успешной покупки")
    @Feature("Кейс 1. Проверка успешной покупки")
    public void case1Positive() throws InterruptedException {
        // Создание экземпляров страниц
        AutorizationPage autorizationPage = new AutorizationPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        BucketPage bucketPage = new BucketPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Авторизация
        autorizationPage.enterLogin(loginPositive)
                .enterPassword(passwordPositive)
                .clickLogin();

        // Действия на странице Products
        productsPage.clickAddToCart()
                .clickBucketButton();

        // Действия на странице корзины
        bucketPage.clickCheckoutButton();

        // Действия на странице "Checkout"
        checkoutPage.enterFields(checkoutInputFields, checkoutInputFields, checkoutInputFields)
                .clickContinueButton();

        checkoutPage.clickFinishButton();

        // Сверяем фактический и ожидаемый результаты
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(checkoutPage.getMessage(), expectedMessage);
    }
}