import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest
{
    private WebDriver driver;

    @BeforeSuite

    @Parameters({"browser","path"})
    public void init(String browser, String path) throws Exception
    {
        System.setProperty(browser,path);
        if (browser.equals("webdriver.chrome.driver")) {
            driver = new ChromeDriver();
        }
        if (browser.equals("webdriver.gecko.driver")) {
            driver = new FirefoxDriver();
        }

        if (driver == null) {
            throw new Exception("Driver is not initialized");
        }

        System.setProperty("webdriver.gecko.driver", "Path to GeckDriver Executable File here");
        driver = new FirefoxDriver();

    }

    public WebDriver getDriver()
    {
        return driver;
    }


    @AfterSuite
    public void after()
    {
//        if (driver != null) {
//            getDriver().quit();
//        }
    }
}
