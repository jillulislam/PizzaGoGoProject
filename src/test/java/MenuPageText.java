import Commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.MenuPage;
import pageObject.PizzaPage;
import ru.yandex.qatools.allure.annotations.Title;

public class MenuPageText extends Configuration {

    MenuPage menuPage = new MenuPage(driver);
    PizzaPage pizzaPage = new PizzaPage(driver);

    @Before
    public void openUrl(){
        menuPage.openUrl("https://www.pizzagogo.co.uk/menu");
    }

    @Title("Select a pizza from menu")
    @Test
    public void verifySelectingPizzaFromMenuPage() {
        menuPage.clickOnPizza();
        pizzaPage.verifyLaunchingOnPizzaPage();
    }



}
