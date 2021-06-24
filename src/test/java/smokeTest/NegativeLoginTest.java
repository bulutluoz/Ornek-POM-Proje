package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    @Test
    public void yanlisSifreTest(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));

        //test data yanlis password : manager1!

        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_wrong_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.loginButonu.click();

        Assert.assertTrue(koalaResortPage.girisYapilamadiElementi.isDisplayed());

        Driver.closeDriver();
    }
    @Test
    public void yanlisKullaniciTest(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_wrong_username"));

        //test data yanlis password : manager1!

        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.loginButonu.click();

        Assert.assertTrue(koalaResortPage.girisYapilamadiElementi.isDisplayed());

        Driver.closeDriver();
    }
    @Test
    public void yanlisSifreVeKullaniciAdiTest(){
        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //		login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_wrong_username"));

        //test data yanlis password : manager1!

        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_wrong_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.loginButonu.click();

        Assert.assertTrue(koalaResortPage.girisYapilamadiElementi.isDisplayed());

        Driver.closeDriver();
    }
}
