import Commons.Configaration;
import Commons.Footer;
import Commons.Header;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;
import ru.yandex.qatools.allure.annotations.Title;


public class HomePageTest extends Configaration {

    Homepage homepage = new Homepage(driver);
    Header header = new Header(driver);
    Footer footer = new Footer(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    MenuPage menuPage = new MenuPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AboutPage aboutPage = new AboutPage(driver);
    ContactPage contactPage = new ContactPage(driver);

    @Before
    public void openTheUrl(){
        homepage.openUrl("https://www.pizzagogo.co.uk");
    }

    @Title("Menu link is navigating user to the correct page")
    @Test
    public void verifyLinkByClickingOnMenu() {
        homepage.header.clickOnMenu();
        menuPage.verifyLaunchingOnMenuPage();
    }

    @Title("Register link is navigating user to the correct page")
    @Test
    public void verifyLinkByClickingOnRegister(){
        homepage.header.clickOnRegister();
        registerPage.verifyLaunchingOnRegisterPage();
    }

    @Title("Login link is navigating user to the correct page")
    @Test
    public void verifyLinkByClickingOnLogIn(){
        homepage.header.clickOnLogInn();
        loginPage.verifyLaunchingOnLoginPage();
    }

    @Title("A store can be selected by entering a correct postcode in the search box")
    @Test
    public void verifyingSearchBoxFunctionalityByEnteringAValiidAddress() {
        homepage.enterAValidPostCode("E143LD");
        homepage.clickOnGogoButton();
        homepage.verifySelectAStorePageLoadedText();
    }

    @Title("An error popup is displaying by entering numbers only in the search box")
    @Test
    public void verifyingSearchBoxFunctionalityByEnteringNumbersOnly(){
        homepage.enterAnInvalidPostCode("3234234");
        homepage.clickOnGogoButton();
        homepage.verifyErrorMsgByEnteringNumbers();
    }

    @Title("Checking search functionality by entering a post code where store is not available")
    @Test
    public void verifyingSearchBoxFunctionalityByEnteringAPostCodeWhereStoreIsNotAvaliable(){
        homepage.enterAPostcode("E30 3LD");
        homepage.clickOnGogoButton();
        homepage.verifyMsgWhereStoreIsNotAvaliable();
    }

    @Title("About link is navigating user to the correct page")
    @Test
    public void verifyLinkByClickingOnAbout(){
        homepage.footer.clickInOnAbout();
        aboutPage.verifyLaunchingOnAboutPage();
    }

    @Title("Contact link is navigating user to the correct page")
    @Test
    public void verifyClickingOnContact(){
        homepage.footer.clickOnContact();
        contactPage.verifyLaunchingOnContactPage();
    }


}
