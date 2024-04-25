package ru.yandex.practicum.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class MainPage {
    private final WebDriver webDriver;

    //Главная страница. Кнопка "Заказать" верхняя:
    private final By orderButtonUpLocator = By.xpath("//div[contains(@class, 'Header')]/button[text()='Заказать']");
    //Главная страница. Кнопка "Заказать" нижняя:
    private final By orderButtonDownLocator = By.xpath("//div[contains(@class, 'Home')]/button[text()='Заказать']");
    //Форма заказа. Поле ввода "Имя":
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    //Форма заказа. Поле ввода "Фамилия":
    private final By lastnameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    //Форма заказа. Поле ввода "Адрес":
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Форма заказа. Поле ввода "Станция метро":
    private final By metroInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    //Форма заказа. Локатор для поиска станций метро:
    private final String stationItemLocator = "//div[text()='%s']";
    //Форма заказа. Поле ввода "Телефон":
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Форма заказа. Кнопка "Далее", ведущая к переходу к заполнению второй части формы заказа:
    private final By nextButtonLocator = By.xpath("//button[text()='Далее']");
    //Форма заказа. Поле ввода "Когда привезти самокат":
    private final By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Форма заказа. Выпадающий список "Срок аренды":
    private final By rentPeriodInputLocator = By.xpath("//div[@class='Dropdown-placeholder']");
    //Форма заказа. Локатор срока аренды "двое суток":
    private final By twoDaysRentMenuLocator = By.xpath("//div[text()='двое суток']");
    //Форма заказа. Кнопка "Заказать", что под формой заказа:
    private final By createOrderButtonLocator = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Форма заказа. Кнопка "Да" для подтверждения оформления заказа:
    private final By yesCreateOrderButtonLocator = By.xpath("//button[text()='Да']");
    //Форма заказа. Всплывающего окна с сообщением об успешном создании заказа:
    private final By orderWindowLocator = By.xpath("//div[@class='Order_Modal__YZ-d3']");
    //Cookies. Кнопка соглашающаяся с куки "да все привыкли":
    private final By cookiesButtonLocator = By.xpath("//button[text()='да все привыкли']");
    //Главная страница. Локатор вопросов выпадающего списка в разделе «Вопросы о важном»:
    private final String questionLocator = "accordion__heading-%s";
    //Главная страница. Локатор ответов выпадающего списка в разделе «Вопросы о важном»:
    private final String answerLocator = "//div[contains(@id, 'accordion__panel-')][.='%s']";



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Проверка кнопки "Заказать" верхней:
    public void clickOrderButtonUp() {
        WebElement orderButtonUp = webDriver.findElement(orderButtonUpLocator);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderButtonUp));
        orderButtonUp.click();
    }

    //Проверка кнопки "Заказать" нижней:
    public void clickOrderButtonDown() {
        WebElement orderButtonDown = webDriver.findElement(orderButtonDownLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", orderButtonDown);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderButtonDown));
        orderButtonDown.click();
    }

    //Заполнение формы заказа
    public void fillCustomerInfoOrder(String name, String lastname, String address, String station, String phoneNumber, String dateOrder) {

        //Ввод в поле "Имя"
        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);

        //Ввод в поле "Фамилия"
        WebElement lastnameInput = webDriver.findElement(lastnameInputLocator);
        lastnameInput.sendKeys(lastname);

        //Ввод в поле "Адрес"
        WebElement addressInput = webDriver.findElement(addressInputLocator);
        addressInput.sendKeys(address);

        //Клик по полю "Станция метро"
        WebElement metroInput = webDriver.findElement(metroInputLocator);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(metroInput));
        metroInput.click();
        metroInput.sendKeys(station);
        //Ввод в поле "Станция метро"
        WebElement metroStation = webDriver.findElement(By.xpath(String.format(stationItemLocator, station)));
        //Скролл до введенной станции
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", metroStation);
        //Выбор введенной станции
        metroStation.click();

        //Ввод в поле "Телефон"
        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phoneNumber);

        //Кнопка "Далее", ведущая к переходу к заполнению второй части формы заказа:
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();

        //Ввод в поле "Когда привезти самокат"
        WebElement dateInput = webDriver.findElement(dateInputLocator);
        dateInput.sendKeys(dateOrder, Keys.ENTER);

        //Клик по полю "Срок аренды"
        WebElement rentPeriodInput = webDriver.findElement(rentPeriodInputLocator);
        rentPeriodInput.click();
        //Выбор срока аренды
        WebElement twoDaysRentMenu = webDriver.findElement(twoDaysRentMenuLocator);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(twoDaysRentMenu));
        twoDaysRentMenu.click();
    }


    //Закрытие окна с Cookies
    public void closeCookies() {
        webDriver.findElement(cookiesButtonLocator).click();
    }

    //Выбор вопроса в выпадающем списке в разделе «Вопросы о важном»:
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(format(questionLocator, index)));
        //Скролл до выпадающего списка в разделе «Вопросы о важном»:
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        //Ожидание кликабельности выпадающего списка в разделе «Вопросы о важном»:
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //Сравнение соответствия ответов в выпадающем списке в разделе «Вопросы о важном»:
    public boolean answerInDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }

    //Кнопка "Заказать", что под формой заказа:
    public void clickCreateOrderButton() {
        WebElement createOrderButton = webDriver.findElement(createOrderButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(createOrderButton));
        createOrderButton.click();
    }

    //Подтверждение оформления заказа:
    public void clickYesCreateOrderButton() {
        WebElement yesCreateOrderButton = webDriver.findElement(yesCreateOrderButtonLocator);
        yesCreateOrderButton.click();
    }

    //Проверка наличия всплывающего окна с сообщением об успешном создании заказа:
    public boolean orderWindowCheck() {
        return webDriver.findElement(orderWindowLocator).isDisplayed();
    }

}