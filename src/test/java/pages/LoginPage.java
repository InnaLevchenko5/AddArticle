package pages;
import io.qameta.allure.Step;
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

    private static String url1 = "http://wordpress.local/wp-login.php";
    By loginButton = By.id("wp-submit");
    By loginField = By.id("user_login");
    By passField = By.id("user_pass");
    @Step("Вход по логину, паролю")
    public void login (String login, String password)
    {
        driver.get("http://inna:Inna123!@wordpress.local/wp-login.php");
        writeText(loginField,login);
        writeText(passField,password);
        click(loginButton);
    }
}