package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class D22_ReusableMethodsWebList {


@Test
    public void test01(){

    Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

    AmazonPage amazonPage=new AmazonPage();
    List<WebElement> tumDatalarWebelement = amazonPage.tumDataWebelementList;

    System.out.println(ReusableMethods.getElementsText(tumDatalarWebelement));


    System.out.println("===================");


    System.out.println(ReusableMethods.getElementsText(amazonPage.tumDataWebelementList));

}


}
