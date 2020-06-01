package pageObject;

import Commons.CommonActions;
import Commons.Footer;
import Commons.Header;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class Homepage extends CommonActions {

    public Header header;
    public Footer footer;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        initElement();
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement postcode;

    @FindBy (id = "gogo")
    WebElement btn_gogo;

    @FindBy(xpath = "//div[@class='mobile_pad_me align_center']/h1")
    WebElement text_menuPage;

    @FindBy(xpath = "//div[@class='pad20']/p")
    WebElement text_forEnteringInvalidPostcode;

    @Step
    public void enterAValidPostCode(String code){
        typeText(postcode,code);
    }

    @Step
    public void enterAnInvalidPostCode(String code){
        typeText(postcode,code);
    }

    @Step
    public void enterAPostcode(String code){
        typeText(postcode,code);
    }

    @Step
    public void clickOnGogoButton(){
        clickOn(btn_gogo);
    }

    @Step
    public String getTextOfSelectStorePage(){
        return getText(text_menuPage);
    }

    @Step
    public String getTextOfInvalidInputMsgInSearchBox(){
        return getText(text_forEnteringInvalidPostcode);
    }

    @Step
    public void verifySelectAStorePageLoadedText(){
        VerifyTests.verify("SELECT YOUR STORE",getTextOfSelectStorePage());
    }

    @Step
    public void verifyErrorMsgByEnteringNumbers(){
        VerifyTests.verify("Please enter a valid postcode.", getTextOfInvalidInputMsgInSearchBox());
    }

    @Step
    public void verifyMsgWhereStoreIsNotAvaliable(){
        VerifyTests.verify("Sorry, we have no stores near the postcode you entered.", getTextOfInvalidInputMsgInSearchBox());
    }

}
