package ru.yandex.practicum.scooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.WebDriverFactory;
import ru.yandex.practicum.page.MainPage;
import static org.junit.Assert.assertTrue;


//Тест заказа самоката. "Весь флоу позитивного сценария."
@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver webDriver;
    private final String name;
    private final String lastname;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String dateOrder;

    public OrderTest(String name, String lastname, String address, String station, String phoneNumber, String dateOrder) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
    }

    //Параметры, используемые в тестах на заполнение формы заказа
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Аба", "Дур", "Адрес", "Сокол", "+79998886655", "09.05.2024"},
                {"В а д и м", "СамыйУмный", "Александровский сад", "Александровский сад", "89998886655", "01.09.2024"},
        };
    }

    //Открытие бразуера для тестов
    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    //Тест оформления заказа
    @Test
    public void orderCreationTest() {
        MainPage mainPage = new MainPage(webDriver);
        //Клик по нужной кнопке "Заказать"
        mainPage.clickOrderButtonUp();
        //Заполнение формы заказа
        mainPage.fillCustomerInfoOrder(name, lastname, address, station, phoneNumber, dateOrder);

        //Клик по кнопке "Заказать" для оформления заказа
        mainPage.clickCreateOrderButton();
        //Подтверждение создания заказа
        mainPage.clickYesCreateOrderButton();

        //Проверка НАЛИЧИЯ СООБЩЕНИЯ об успешном создании заказа во всплывающем окне:
        assertTrue(mainPage.orderWindowWithMessageCheck());

    }

    //Закрытие браузера после тестов
    @After
    public void tearDown() {
        webDriver.quit();
    }

}
