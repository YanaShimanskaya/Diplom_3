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
import static pom.AuthPage.SIGN_IN_BUTTON;
import static pom.MainPage.*;
import static pom.UserPage.EXIT_BUTTON;
import static pom.UserPage.SAVE_BUTTON;


public class PersonalAccountTest {
    private WebDriver webDriver;
    private static String userToken;

    @Before
    public void setUp(){
        webDriver = GET_DRIVER_CONFIG();
        User.newUser(new CreateUser(EMAIL, PASSWORD, NAME));
        userToken = User.getUserToken(new LoginUser(EMAIL, PASSWORD));
        AuthPage authenticationPage = new AuthPage(webDriver);
        webDriver.findElement(ACCOUNT_SIGNIN_BUTTON).click();
        authenticationPage.loginFromMainPage(EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("Going to account profile")
    @Description("Successful account profile login test")
    public void personalAccountLoginTest() {
        webDriver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        String actualResult = webDriver.findElement(SAVE_BUTTON).getText();
        assertEquals(EXPECTED_SAVE_BUTTON_TEXT,actualResult);
    }

    @Test
    @DisplayName("Going from profile to Burger constructor")
    @Description("Successful shift to Burger constructor from Profile test")
    public void shiftToBurgerConstructorTest() {
        webDriver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        webDriver.findElement(BURGER_CONSTRUCTOR_BUTTON).click();
        String actualResult = webDriver.findElement(MAKE_BURGER_TEXT).getText();
        assertEquals(EXPECTED_MAKE_BURGER_TEXT,actualResult);
    }

    @Test
    @DisplayName("Logout from Profile")
    @Description("Successful logout profile test")
    public void logoutProfileTest() {
        webDriver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        webDriver.findElement(EXIT_BUTTON).click();
        String actualResult = webDriver.findElement(SIGN_IN_BUTTON).getText();
        assertEquals(EXPECTED_SUCCESSFUL_TEXT,actualResult);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
        User.deleteUser(userToken);
    }
}