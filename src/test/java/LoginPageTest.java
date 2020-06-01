import Commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.AccountPage;
import pageObject.LoginPage;
import pageObject.MenuPage;
import ru.yandex.qatools.allure.annotations.Title;

public class LoginPageTest extends Configuration {

    LoginPage loginPage = new LoginPage(driver);
    AccountPage accountPage = new AccountPage(driver);
    MenuPage menuPage = new MenuPage(driver);

    @Before
    public void openUrl(){
        loginPage.openUrl("https://www.pizzagogo.co.uk/login");
    }

    @Title("Log in with correct user name and correct password")
    @Test
    public void loginWithCorrectCredential(){
        loginPage.clearEmailField();
        loginPage.enterYourUserName("test200@test.com");
        loginPage.clearPasswordField();
        loginPage.enterYourPassword("Test12345");
        loginPage.clickOnLogin();
        menuPage.verifyLaunchingOnMenuPage();
    }

    @Title("Log in with correct user name and incorrect password")
    @Test
    public void loginWithCorrectUserNameAndIncorrectPassword(){
        loginPage.clearEmailField();
        loginPage.enterYourUserName("test200@test.com");
        loginPage.clearPasswordField();
        loginPage.enterYourPassword("test1237");
        loginPage.clickOnLogin();
        accountPage.verifyErrorMsgOfEnteringIncorrectCredential();
    }

    @Title("Log in with incorrect user name and correct password")
    @Test
    public void loginWithIncorrectUserNameAndCorrectPassword(){
        loginPage.clearEmailField();
        loginPage.enterYourUserName("est100@test.com");
        loginPage.clearPasswordField();
        loginPage.enterYourPassword("test1233");
        loginPage.clickOnLogin();
        accountPage.verifyErrorMsgOfEnteringIncorrectCredential();
    }

    @Title("Log in with incorrect user name and incorrect password")
    @Test
    public void loginWithIncorrectUserNameAndInCorrectPassword(){
        loginPage.clearEmailField();
        loginPage.enterYourUserName("est100@test.com");
        loginPage.clearPasswordField();
        loginPage.enterYourPassword("test1233");
        loginPage.clickOnLogin();
        accountPage.verifyErrorMsgOfEnteringIncorrectCredential();
    }

    @Title("Log in with empty user name and empty password")
    @Test
    public void loginWithEmptyNameAndEmptyPassword(){
        loginPage.enterYourUserName("");
        loginPage.enterYourPassword("");
        loginPage.clickOnLogin();
        accountPage.verifyErrorMsgOfEnteringIncorrectCredential();
    }
}
