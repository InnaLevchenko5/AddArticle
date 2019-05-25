package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class LoginPage
{
    private WebDriver driver;

    // start page
    private static String url1 = "http://wordpress.local/wp-login.php";

    public LoginPage(WebDriver driverIn)
    {
        driver = driverIn;
    }

    public void login (String login, String password)
    {
        driver.get("inna:Inna123!@http://wordpress.local/");
        driver.get("http://wordpress.local/");

        driver.get(url1);
        WebElement loginIn = driver.findElement(By.id("user_login"));
        loginIn.sendKeys(login);
        WebElement passwd = driver.findElement(By.id("user_pass"));
        passwd.sendKeys(password);
        driver.findElement(By.id("loginform")).submit();
    }
}