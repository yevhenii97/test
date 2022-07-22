package test;

import config.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {


    private static final String ERROR_MESSAGE_LOGIN = "No account found with that username.";
    private static final String ERROR_MESSAGE_PASSWORD = "The password you entered was not valid.";

    @Test(priority = 1)
    public void userSentInvalidLoginAndInvalidPasswordAndErrorMessage() {
        assertTrue(getSignInPage().logoIsVisible());
        getSignInPage().sentLogin("qwerty");
        getSignInPage().sentPassword(ConfigProvider.PASSWORD);
        getSignInPage().clickLoginButton();
        Assert.assertTrue(getSignInPage().errorMessageIsVisible());
        Assert.assertEquals(getSignInPage().getErrorMessage(), ERROR_MESSAGE_LOGIN);
    }

    @Test(priority = 2)
    public void userSentValidLoginAndInvalidPasswordAndErrorMessage() {
        assertTrue(getSignInPage().logoIsVisible());
        getSignInPage().sentLogin(ConfigProvider.LOGIN);
        getSignInPage().sentPassword(ConfigProvider.PASSWORD);
        getSignInPage().clickLoginButton();
        Assert.assertTrue(getSignInPage().errorMessageIsVisible());
        Assert.assertEquals(getSignInPage().getErrorMessage(), ERROR_MESSAGE_PASSWORD);
    }


}
