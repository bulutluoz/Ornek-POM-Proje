package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseCross {

    protected WebDriver driver;

    // @Optinal : Eğer browser diye herhangi bir
    // parametre gelmezse bile burası çalışsın diyoruz.

    // Bize parametre olarak browser gelecek(gelirse)
    // Biz de o parametreyi kullanacağız.
    // Bu paramatre, xml dosyasından gelecek

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){
        driver = DriverCross.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){

        //DriverCross.closeDriver();
    }

}