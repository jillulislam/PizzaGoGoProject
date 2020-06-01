import Commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.MenuPage;
import pageObject.RegisterPage;
import ru.yandex.qatools.allure.annotations.Title;

public class RegisterPageTest extends Configuration {

    //why cant i see the property of registerclass after making its object?
    RegisterPage registerPage = new RegisterPage(driver);
    MenuPage menuPage = new MenuPage(driver);

    @Before
    public void openUrl(){
        registerPage.openUrl("https://www.pizzagogo.co.uk/register");
    }

    @Title("new user registration")
    @Test
    public void verifyRegistratonOfAnUser(){
        registerPage.enterYourEmailAddress();
        registerPage.enterYourApassword();
        registerPage.confirmYourApassword();
        registerPage.enterYourFirstName();
        registerPage.enterYourLastName();
        registerPage.enterYourDoorNumber();
        registerPage.enterYourStreetAddress();
        registerPage.enterYourCity();
        registerPage.enterYourPostCode();
        registerPage.enterYourPhoneNumber();
        registerPage.clickOnCheckBox();
        registerPage.clickOnRegisterButton();
        menuPage.verifyLaunchingOnMenuPage();
    }

    @Title("error msg on duplicate account")
    @Test
    public void verifyErrorMsgOnRegistrationOfAnExistingCustomer(){
        registerPage.enterYourEmailAddress();
        registerPage.enterYourApassword();
        registerPage.confirmYourApassword();
        registerPage.enterYourFirstName();
        registerPage.enterYourLastName();
        registerPage.enterYourDoorNumber();
        registerPage.enterYourStreetAddress();
        registerPage.enterYourCity();
        registerPage.enterYourPostCode();
        registerPage.enterYourPhoneNumber();
        registerPage.clickOnCheckBox();
        registerPage.clickOnRegisterButton();
        registerPage.verifyingRegistrationDuplationError();
    }

    @Title("An error msg will popup without filling uo mandatory fields")
    @Test
    public void verifyRegistrationErrorWithoutEnteringAMendatoryField(){
        registerPage.enterYourEmailAddress();
        registerPage.enterYourApassword();
        registerPage.confirmYourApassword();
        registerPage.enterYourFirstName();
        registerPage.enterYourLastName();
        registerPage.enterYourDoorNumber();
        registerPage.enterYourStreetAddress();
        registerPage.enterYourCity();
        registerPage.enterYourPhoneNumber();
        registerPage.clickOnCheckBox();
        registerPage.clickOnRegisterButton();
        registerPage.verifyErrorMsgOfUncompletedField();
    }

    @Title("Registration failure on password missmatch")
    @Test
    public void verifyMismatchPasswordField(){
        registerPage.enterYourEmailAddress();
        registerPage.enterYourApassword();
        registerPage.confirmYourApassword();
        registerPage.enterYourFirstName();
        registerPage.enterYourLastName();
        registerPage.enterYourDoorNumber();
        registerPage.enterYourStreetAddress();
        registerPage.enterYourCity();
        registerPage.enterYourPostCode();
        registerPage.enterYourPhoneNumber();
        registerPage.clickOnCheckBox();
        registerPage.clickOnRegisterButton();
        registerPage.verifyErrorOnMisMatchOfPassword();
    }


}
