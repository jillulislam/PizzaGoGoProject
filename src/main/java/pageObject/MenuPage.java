package pageObject;

import Commons.CommonActions;
import Commons.Footer;
import Commons.Header;
import Commons.VerifyTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class MenuPage extends CommonActions {

    public Header header;
    public Footer footer;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        initElement();
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @FindBy(xpath = "//*[@id='menu_page']/div/div[2]/div/div/a")
    WebElement pizza;

    @Step
    public String getMenuPageTitle(){
        return driver.getTitle();
    }

    @Step
    public void verifyLaunchingOnMenuPage(){
        VerifyTests.verify("Pizza GoGo Menu - What would you like today?",getMenuPageTitle());
    }

    @Step
    public void clickOnPizza(){
        clickOn(pizza);
    }

}
