package Commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends CommonActions{

    public Header(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[1]/a[1]/span")
    WebElement link_menu;

    @FindBy (xpath = "//div[1]/a[3]/span")
    WebElement link_logIn;

    @FindBy (xpath = "//div[1]/a[4]/span")
    WebElement link_register;

    public void clickOnMenu(){
        clickOn(link_menu);
    }

    public void clickOnLogInn(){
        clickOn(link_logIn);
    }

    public void clickOnRegister(){
        clickOn(link_register);
    }


}
