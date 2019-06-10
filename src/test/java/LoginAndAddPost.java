import org.testng.annotations.*;
import pages.AddArticlePage;
import pages.LoginPage;
import pages.ViewPostPage;
import java.io.IOException;

public class LoginAndAddPost extends BaseTest
{
    private LoginPage loginPage;
    private AddArticlePage addArticlePage;
    private ViewPostPage viewPostPage;
    private String viewLink;

    @BeforeClass
    public void initPages()
    {
        loginPage =  new LoginPage(getDriver());
        addArticlePage = new AddArticlePage(getDriver());
        viewPostPage = new ViewPostPage(getDriver());
    }

    @Test(description = "Авторизация")
    @Parameters({"login", "password"})
    public void testLogin (String login, String password) throws Exception
    {
        loginPage.login(login,password);
    }

    @Test(dependsOnMethods = "testLogin", description = "Добавление статьи")
    public void testAddArticle()
    {
        viewLink = addArticlePage.AddArticle();
    }

    @Test(dependsOnMethods = "testAddArticle", description = "Просмотр статьи")
    public void testCheckPost()
    {
        viewPostPage.ViewPost(viewLink);
    }

}
