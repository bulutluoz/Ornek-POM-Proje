package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverCross {

    private DriverCross() {
    }


    static WebDriver driver;


    public static WebDriver getDriver(String browser) {//chrome

        // Eğer browser olarak gelen parametrenin değeri "null" ise, yani boş bir değer geldiyse
        // o zaman güvenlik önlemi olarak, .properties dosyasından browser değerini al ve kullan
        // eğer browser'in değeri null değilse hangisi geldiyse onu kullanabilirsiniz.
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        if (driver == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {
        // Eğer driver nesnesi NULL değilse, yani hafızada varsa
        if (driver != null) {
            driver.close();  // driver'ı kapat
            driver = null;  // driver'ı hafızadan temizle.
        }
    }
}