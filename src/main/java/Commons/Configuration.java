package Commons;

import core.AllureReportConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Configuration extends AllureReportConfig {

    public static void openChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        driver.manage().window().maximize();
    }

    public static void openFireFox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,SECONDS);
    }

    @BeforeClass
    public static void openBrowser(){
        openChrome();
    }

    @AfterClass
    public static void closeBrowser(){
        driver.close();
    }
}