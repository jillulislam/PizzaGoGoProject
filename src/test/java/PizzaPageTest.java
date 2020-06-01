import Commons.Configaration;
import org.junit.Before;
import org.junit.Test;
import pageObject.PizzaPage;
import ru.yandex.qatools.allure.annotations.Title;

public class PizzaPageTest extends Configaration {

    PizzaPage pizzaPage = new PizzaPage(driver);

    @Before
    public void openUrl(){
        pizzaPage.openUrl("https://www.pizzagogo.co.uk/menu/pizzas");
    }

    @Title("Medium size pizza can be added to the busket")
    @Test
    public void verifyselectingAMendiumPizzaFromPizzaPage() throws InterruptedException {
        pizzaPage.selectingChickenHotPizza();
        pizzaPage.waitFor(2000);
        pizzaPage.selectSizePizza();
        pizzaPage.waitFor(2000);
        pizzaPage.selectBaseOfPizza();
        pizzaPage.waitFor(2000);
        pizzaPage.clearQuantityField();
        pizzaPage.waitFor(2000);
        pizzaPage.enterTheQuantityOfPizza();
        pizzaPage.waitFor(2000);
        pizzaPage.clickOnAdd();
        pizzaPage.waitFor(10000);
        pizzaPage.verifyAddingOrderOnTheBusket();
        pizzaPage.clickOnProcceedToCheckOut();
        pizzaPage.verifyQuantity();
    }

    @Title("Drop down default value validation")
    @Test
    public void verifyDefaultValueOfDropDownList(){
        pizzaPage.verifyDropDownDefaultValue();
    }

    @Title("Vegitarian option can be selected from dropdown")
    @Test
    public void verifySelectingAnOptionFromDropdown(){
        pizzaPage.selectVegitarianOptionFromDropdown();
        pizzaPage.verifyVegitarianOptionisSelected();
    }
}
