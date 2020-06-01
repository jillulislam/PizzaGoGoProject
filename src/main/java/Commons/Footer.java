package Commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends CommonActions{
    public Footer(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[@class='wrapper']/ul/li[2]")
    WebElement link_about;

    @FindBy(xpath = "//div[@class='wrapper']/ul/li[4]")
    WebElement link_contact;


    public void clickInOnAbout(){
        clickOn(link_about);
    }

    public void clickOnContact(){
        clickOn(link_contact);
    }
}


