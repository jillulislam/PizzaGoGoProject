package pageObject;

import Commons.CommonActions;
import Commons.Footer;
import Commons.Header;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends CommonActions {

    Header header;
    Footer footer;
    public AboutPage(WebDriver driver){
        this.driver = driver;
        initElement();
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @FindBy(xpath = "//div[@class='page_hero_pad']/h1")
    WebElement text_aboutPage;

    public String getTextOfAboutPage(){
        return getText(text_aboutPage);
    }

    public void verifyLaunchingOnAboutPage(){
        VerifyTests.verify("ABOUT PIZZA GOGO",getTextOfAboutPage());
    }
}
