package pageObject;

import Commons.CommonActions;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends CommonActions {

    public AccountPage(WebDriver driver){
        this.driver  = driver;
        initElement();
    }

    @FindBy(xpath = "//div[6]/div/a/span[1]")
    WebElement text_logOut;

    @FindBy(xpath = "//*[@id='tabpanel_1']/div/div/div[1]")
    WebElement text_incorrectCrediential;

    public String getTextOfEnteringIncorrectCredential(){
        return getText(text_incorrectCrediential);
    }

    public String getTextOfLogOut(){
        return getText(text_logOut);
    }

    //Sometimes it navigate to accountpage
    public void verifyingLaunchingOnAccountPage(){
        VerifyTests.verify("Log out",getTextOfLogOut());
    }

    public void verifyErrorMsgOfEnteringIncorrectCredential(){
        VerifyTests.verify("Incorrect account details.",
                getTextOfEnteringIncorrectCredential());
    }
}
