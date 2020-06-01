package pageObject;

import Commons.CommonActions;
import Commons.Footer;
import Commons.Header;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends CommonActions {
    Header header;
    Footer footer;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        initElement();
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @FindBy(id = "log_u")
    WebElement email;

    @FindBy(id = "log_p")
    WebElement password;

    @FindBy(id = "login")
    WebElement btn_login;

    @Step
    public void enterYourUserName(String input_email){
        typeText(email,input_email);
    }

    @Step
    public void enterYourPassword(String input_pass){
        typeText(password,input_pass);
    }

    @Step
    public void clickOnLogin(){
        clickOn(btn_login);
    }

    @Step
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    @Step
    public void verifyLaunchingOnLoginPage(){
        VerifyTests.verify("Log in | Pizza GoGo", getLoginPageTitle());
    }

    public void clearEmailField(){
        clearField(email);
    }

    public void clearPasswordField(){
        clearField(password);
    }

}
