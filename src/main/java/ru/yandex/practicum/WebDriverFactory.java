package ru.yandex.practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getWebDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("yandex")) {
            return null;
        } else if (browserType.equalsIgnoreCase("opera")) {
            return null;
        } else {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

    }
}
