package tests;

import config.ConfigManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutorizationPage;

/**
 * Класс для работы с кейсом 2
 */
@Epic("Saucedemo")
public class SaucedemoNegative extends BaseTest {

    /**
     * Переменные из конфиг-файла
     */
    private final String loginNegative = ConfigManager.getInstance().getProperty("loginNegative");
    private final String passwordNegative = ConfigManager.getInstance().getProperty("passwordNegative");
    private final String expectedErrorMessage = ConfigManager.getInstance().getProperty("expectedErrorMessage");


    /**
     * Метод для проверки кейса 2
     */
    @Test
    @Description(value = "Кейс 2. Проверка сообщения об ошибке при попытке ввода логина на несуществующего пользователя")
    @Feature("Кейс 2. Проверка сообщения об ошибке при попытке ввода логина на несуществующего пользователя")
    public void case2Negative() throws InterruptedException {
        // Создание экземпляра страницы
        AutorizationPage autorizationPage = new AutorizationPage(driver);

        // Авторизация
        autorizationPage.enterLogin(loginNegative)
                .enterPassword(passwordNegative)
                .clickLogin();

        // Сверяем фактический и ожидаемый результаты
        Assert.assertEquals(autorizationPage.getErrorMessage(), expectedErrorMessage);
    }
}