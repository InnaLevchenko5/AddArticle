import listeners.IGetDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BaseTest implements IGetDriver
{
    private WebDriver driver;

    @BeforeSuite
    @Parameters({"browser","path"})
    public void initBrowser(String browser, String path)
    {
        System.setProperty(browser, path);
        driver = new ChromeDriver();
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    @AfterSuite
    public void after()
    {
       if (driver != null) {
           getDriver().quit();
       }
    }
}
