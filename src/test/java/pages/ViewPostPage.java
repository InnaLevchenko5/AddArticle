package pages;

import org.openqa.selenium.*;
import java.io.IOException;

public class ViewPostPage {

    private WebDriver driver;

    public ViewPostPage(WebDriver driverIn)
    {
        driver = driverIn;
    }

    public void ViewPost()
    {
        WebElement viewLink = driver.findElement(By.cssSelector("div.components-notice a"));
        driver.get(viewLink.getAttribute("href"));
    }

    public String getTitle()
    {
        return driver.findElement(By.xpath("//header/h1")).getText();
    }

    public String getArticle()
    {
        return driver.findElement(By.xpath("//div[@class='entry-content']/p")).getText();
    }
}

