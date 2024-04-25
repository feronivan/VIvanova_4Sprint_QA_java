package ru.yandex.practicum.scooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.WebDriverFactory;
import ru.yandex.practicum.page.MainPage;


//Проверка кнопки «Заказать». Вторая кнопка.
public class OrderButtonCheck {
    private WebDriver webDriver;

    //Открытие браузера для теста
    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    //Тест кнопки
    @Test
    public void orderButtonCheck() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOrderButtonDown();
    }

    //Закрытие браузера после теста
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
