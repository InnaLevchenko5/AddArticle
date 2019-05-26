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
