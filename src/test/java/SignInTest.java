import actions.CreateUser;
import actions.LoginUser;
import actions.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.AuthPage;

import static app.config.AppConfig.*;
import static driver.config.DriverConfig.GET_DRIVER_CONFIG;
import static org.junit.Assert.assertEquals;
import static pom.AuthPage.RESET_PASS_BUTTON;
import static pom.AuthPage.SIGN_IN_BUTTON;
import static pom.MainPage.*;
import static pom.RegistrationPage.REGISTRATION_BUTTON;

public class SignInTest {
    private WebDriver webDriver;
    private static AuthPage authPage;
    private static String userToken;
    @Before
    public void setUp(){
        webDriver = GET_DRIVER_CONFIG();
        User.newUser(new CreateUser(EMAIL,PASSWORD,NAME));
        userToken = User.getUserToken(new LoginUser(EMAIL, PASSWORD));
        authPage = new AuthPage(webDriver);;
    }

    @Test
    @DisplayName("Sing in from Personal Account page")
    @Description("Check sing in from Personal Account page test")
    public void loginPersonalAccountTest() {
        webDriver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        authPage.loginFromMainPage(EMAIL,PASSWORD);
        String actualResult = webDriver.findElement(MAKE_ORDER_BUTTON).getText();
        assertEquals(EXPECTED_SIGN_IN_TEXT,actualResult);
    }

    @Test
    @DisplayName("Sign in from main page")
    @Description("Check sign in from main page test")
    public void loginButtonLoginTest() {
        webDriver.findElement(ACCOUNT_SIGNIN_BUTTON).click();
        authPage.loginFromMainPage(EMAIL,PASSWORD);
        String actualResult = webDriver.findElement(MAKE_ORDER_BUTTON).getText();
        assertEquals(EXPECTED_SIGN_IN_TEXT,actualResult);
    }

    @Test
    @DisplayName("Sign in from registration page")
    @Description("Check sign in from registration page test")
    public void loginFromRegistrationPageTest() {
        webDriver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        webDriver.findElement(REGISTRATION_BUTTON).click();
        webDriver.findElement(SIGN_IN_BUTTON).click();
        authPage.loginFromMainPage(EMAIL, PASSWORD);
        String actualResult = webDriver.findElement(MAKE_ORDER_BUTTON).getText();
        assertEquals(EXPECTED_SIGN_IN_TEXT,actualResult);
    }

    @Test
    @DisplayName("Sign in from reset password page")
    @Description("Check sign in from reset password page test")
    public void loginFromPasswordResetPageTest() {
        webDriver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        webDriver.findElement(RESET_PASS_BUTTON).click();
        webDriver.findElement(SIGN_IN_BUTTON).click();
        authPage.loginFromMainPage(EMAIL, PASSWORD);
        String actualResult = webDriver.findElement(MAKE_ORDER_BUTTON).getText();
        assertEquals(EXPECTED_SIGN_IN_TEXT,actualResult);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
        User.deleteUser(userToken);
    }
}