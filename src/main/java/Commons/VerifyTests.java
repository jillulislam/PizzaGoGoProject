package Commons;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class VerifyTests {

    public static void verify(String expected, String actual){
        Assert.assertEquals(expected,actual);
    }
}
