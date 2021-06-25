package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

   public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//td[@class='navFooterDescItem']")
    public List<WebElement> tumDataWebelementList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "(//tr[1])//td")
    public List<WebElement> birinciSatirElementleri;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;


    @FindBy (xpath = "//div[@class='sg-col-inner']")
    public WebElement sonucYazisiElementi;

    public void enAltaGit(){
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
    }

    //AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda
    // bana hucredeki yaziyi getirecek bir method olusturun

    public String hucreYazisiGetir(int satir,int sutun){

        String hucreXpath="//tr["+satir+"]//td["+sutun+"]";

        String hucredekiYazi=Driver.getDriver().findElement(By.xpath(hucreXpath)).getText();
        return hucredekiYazi;
    }

}
