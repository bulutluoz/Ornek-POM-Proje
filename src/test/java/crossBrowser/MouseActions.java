package crossBrowser;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class MouseActions extends TestBaseCross {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.partialLinkText("Today")).click();

    }

}
