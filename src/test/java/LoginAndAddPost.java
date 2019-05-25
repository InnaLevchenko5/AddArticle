import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AddArticlePage;
import pages.LoginPage;
import pages.ViewPostPage;

import java.io.File;
import java.io.IOException;

public class LoginAndAddPost extends BaseTest
{
    private LoginPage loginPage;
    private AddArticlePage addArticlePage;
    private ViewPostPage viewPostPage;
    private String titleArticle = "Локаторы";
    private String bodyArticle = "Различают три вида локаторов";

    @BeforeClass
    public void init()
    {
        loginPage =  new LoginPage(getDriver());
        addArticlePage = new AddArticlePage(getDriver());
        viewPostPage = new ViewPostPage(getDriver());
    }

    @Test
    @Parameters({"login", "password"})
    public void testLogin (String login, String password) throws IOException
    {
        loginPage.login(login,password);
    }

    @Test(dependsOnMethods = "testLogin")
    public void testAddArticle()
    {
        addArticlePage.AddArticle();
    }

    @Test(dependsOnMethods = "testAddArticle")
    public void testCheckPost() throws IOException
    {
        viewPostPage.ViewPost();
        Assert.assertEquals(viewPostPage.getTitle(), titleArticle);
        Assert.assertEquals(viewPostPage.getArticle(), bodyArticle);
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/screenshots/screen.png"));
    }

}
