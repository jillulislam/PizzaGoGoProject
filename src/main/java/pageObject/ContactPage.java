package pageObject;

import Commons.CommonActions;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;

public class ContactPage extends CommonActions {

    public ContactPage (WebDriver driver){
        this.driver = driver;
        initElement();
    }

    public String getTitleOfContactPage(){
        return driver.getTitle();
    }

    public void verifyLaunchingOnContactPage(){
        VerifyTests.verify("Contact Pizza GoGo",getTitleOfContactPage());
    }
}
