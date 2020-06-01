package pageObject;

import Commons.CommonActions;
import Commons.Footer;
import Commons.Header;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonActions {

    public Header header;
    public Footer footer;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        initElement();
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @FindBy(xpath = "//*[@id='tabpanel_2']/div/div/h1")
    WebElement text_registerPage;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "pass1")
    WebElement password;

    @FindBy(id = "pass2")
    WebElement password2;

    @FindBy(id = "first_name")
    WebElement fname;

    @FindBy(id = "last_name")
    WebElement lname;

    @FindBy (id = "door_number")
    WebElement doorNumber;

    @FindBy(id = "address_1")
    WebElement streetAddress;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "agree")
    WebElement checkBox_agree;

    @FindBy(id = "register")
    WebElement btn_register;

    @FindBy(xpath = "//*[@id='tabpanel_2']/div/div/div[2]")
    WebElement text_ErrorMsg;

    public void enterYourEmailAddress(){
        typeText(email,"test100@test.com");
    }

    public void enterYourApassword(){
        typeText(password,"test123");
    }

    public void confirmYourApassword(){
        typeText(password2,"test123");
    }

    public void enterYourFirstName(){
        typeText(fname,"abdul");
    }

    public void enterYourLastName(){
        typeText(lname,"Haque");
    }

    public void enterYourDoorNumber(){
        typeText(doorNumber,"15");
    }

    public void enterYourStreetAddress(){
        typeText(streetAddress,"Abbay Street");
    }

    public void enterYourCity(){
        typeText(city,"London");
    }

    public void enterYourPostCode(){
        typeText(postCode,"Se1 3EF");
    }

    public void enterYourPhoneNumber(){
        typeText(phone,"07784652387");
    }

    public void clickOnCheckBox(){
        clickOn(checkBox_agree);
    }

    public void clickOnRegisterButton(){
        clickOn(btn_register);
    }

    public String getTextOfRegisterPage(){
        return getText(text_registerPage);
    }

    public String getTextOfErrorMsg(){
        return getText(text_ErrorMsg);
    }

    public String getTextOfNotEnteringMandatoryField(){
        return getText(text_ErrorMsg);
    }

    public void verifyLaunchingOnRegisterPage(){
        VerifyTests.verify("REGISTER ME AS A CUSTOMER",getTextOfRegisterPage());
    }

    public void verifyingRegistrationDuplationError(){
        VerifyTests.verify("That Email is already in use. Please choose another.",
                getTextOfErrorMsg());
    }

    public void verifyErrorMsgOfUncompletedField(){
        VerifyTests.verify("Please complete all required fields",
                getTextOfNotEnteringMandatoryField());
    }

    public void verifyErrorOnMisMatchOfPassword(){
        VerifyTests.verify("The two provided passwords did not match.",
                getTextOfNotEnteringMandatoryField());
    }

}
