package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    // start page
    private static String url1 = "http://wordpress.local/wp-login.php";
    By loginButton = By.id("wp-submit");
    By loginField = By.id("user_login");
    By passField = By.id("user_pass");

    public void login (String login, String password)
    {
        driver.get("http://inna:Inna123!@wordpress.local/wp-login.php");
        writeText(loginField,login);
        writeText(passField,password);
        click(loginButton);
    }
}