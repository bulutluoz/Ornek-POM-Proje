package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){
        // Driver class'indan obje olusturulmasini engellemek icin
        // default constructor'i yazip access modifier'ini PRIVATE yapariz
        // Bunun gibi kendisinden obje olusturulmasi kontrol altina alinan Class'lara
        // SINGLETON Class denir.
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
                case "opera":
                    OperaDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
            }

        }
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            return driver;
        }

        public static void closeDriver(){

        if (driver !=null){
            driver.close();
            driver=null;
        }
        }

    }
