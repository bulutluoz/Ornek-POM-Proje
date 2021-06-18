package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class D22_IlkClass {

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

    }
}
