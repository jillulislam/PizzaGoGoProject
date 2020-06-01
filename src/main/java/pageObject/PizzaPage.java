package pageObject;

import Commons.CommonActions;
import Commons.VerifyTests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.logging.XMLFormatter;

public class PizzaPage extends CommonActions {

    public PizzaPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(id = "prods_613")
    WebElement chickenHotPizza;

    @FindBy(id = "prods_631")
    WebElement vegiterianPizza;

    @FindBy(id = "pizza_size")
    WebElement dropDown_pizzaSize;

    @FindBy(id = "pizza_base")
    WebElement getDropDown_pizzaBase;

    @FindBy(id = "quantity")
    WebElement quantity;

    @FindBy(xpath = "//div[@id='single_controls']/a[1]")
    WebElement btn_add;

    @FindBy(xpath = "//*[@id='addedto_window']/div[1]/div/div/h1")
    WebElement text_orderAdded;

    @FindBy(xpath = "//*[@id='addedto_window']/div[4]/a[2]")
    WebElement btn_proceedToCheckout;

    @FindBy(xpath = "//*[@id='points_table']/div[2]/div/div[1]/input")
    WebElement chartQuantity;

    @FindBy(id = "pizzafilter")
    WebElement dropDownList;

    public String getTitleOfPizzaPage(){
        return driver.getTitle();
    }

    @Step
    public void selectingChickenHotPizza(){
        clickOn(chickenHotPizza);
    }

    @Step
    public void selectSizePizza(){
        selectByValue(dropDown_pizzaSize,"2");
    }

    @Step
    public void selectBaseOfPizza(){
        selectByValue(getDropDown_pizzaBase,"1");
    }

    @Step
    public void clearQuantityField() throws InterruptedException {
        deleteAChar(quantity);
    }

    @Step
    public void clickOnProcceedToCheckOut(){
        clickOn(btn_proceedToCheckout);
    }

    @Step
    public void enterTheQuantityOfPizza(){
        typeText(quantity,"5");
    }

    @Step
    public void verifyQuantity(){
        VerifyTests.verify("5",getValue(chartQuantity));
    }

    @Step
    public void clickOnAdd(){
        clickOn(btn_add);
    }

    @Step
    public String getTextOfOrderAddedMsg(){
        return getText(text_orderAdded);
    }

    @Step
    public void verifyAddingOrderOnTheBusket(){
        VerifyTests.verify("ADDED TO ORDER", getTextOfOrderAddedMsg());
    }

    @Step
    public void verifyLaunchingOnPizzaPage(){
        VerifyTests.verify("Pizzas - Fresh food from Pizza GoGo",
                getTitleOfPizzaPage());
    }

    @Step
    public String defaultTextOfDropDownList(){
        return getTextOfDropdownDefaultVaue(dropDownList);
    }

    @Step
    public void verifyDropDownDefaultValue(){
        VerifyTests.verify("Show me all pizzas",defaultTextOfDropDownList());
    }

    @Step
    public void selectVegitarianOptionFromDropdown(){
        selectByValue(dropDownList,"5");
    }

    @Step
    public void verifyVegitarianOptionisSelected(){
        VerifyTests.verify("Vegetarian",defaultTextOfDropDownList());
    }
}
