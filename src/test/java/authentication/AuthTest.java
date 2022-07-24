package authentication;

import authentication.provider.AuthDataProvider;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Pages;

public class AuthTest extends BaseTest {
    LoginPage loginPage = Pages.getInitialPage();

    @Test(description = "Pecode auth test", dataProvider = "auth test negative", dataProviderClass = AuthDataProvider.class,
    groups = {"ui", "auth"})
    public void authTest(String login, String password) {
        String expectedTitle = "Login";

        loginPage.getPage(settings.getBaseURL());
        Assert.assertEquals(loginPage.getTitle(), expectedTitle);

        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickLoginButton();
        if(!loginPage.isErrorMessagePresent()) {
            Assert.assertTrue(loginPage.isErrorMessagePresent(), "error message is not present");
            Assert.assertEquals(loginPage.getTitle(), expectedTitle, "Authenticated with invalid credentials");
        }
    }
}
