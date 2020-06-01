package Commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CommonActions {
    public WebDriver driver;

    public void initElement(){
        PageFactory.initElements(driver,this);
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void clickOn(WebElement element){
        element.click();
    }

    public void javaScriptClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }


    public void typeText(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clearField(WebElement element){
        element.clear();
    }

    public void deleteAChar(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    public String getValue(WebElement element){
        return element.getAttribute("value");
    }

    public String getTextOfDropdownDefaultVaue(WebElement element){
        Select select = new Select(element);
        String defaultValue = select.getFirstSelectedOption().getText();
        return defaultValue;
    }

    public void waitFor(int milli) throws InterruptedException {
        Thread.sleep(milli);
    }

    public void selectByValue(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void backSpaceUsingKeyboard(WebElement element){
        Actions action = new Actions(driver);
    }
}
