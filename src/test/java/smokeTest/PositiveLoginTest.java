package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    // http://qa-environment.koalaresorthotels.com adresine git
    //		login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void positiveLoginTest() {
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage = new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));

        //test data password : Manager1!

        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        koalaResortPage.loginButonu.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("kr_basarili_giris_url"));

        Driver.closeDriver();
    }
}
