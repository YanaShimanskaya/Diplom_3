import actions.LoginUser;
import actions.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.RegistrationPage;

import static app.config.AppConfig.*;

import static driver.config.DriverConfig.GET_DRIVER_CONFIG;
import static org.junit.Assert.assertEquals;
import static pom.AuthPage.SIGN_IN_BUTTON;
import static pom.RegistrationPage.INVALID_PASS;

public class RegistrationTest {
    private WebDriver webDriver;
    private static String userToken;

    @Before
    public void setUp(){
        webDriver = GET_DRIVER_CONFIG();
        RestAssured.baseURI = APP_URL;
    }

    @Test
    @DisplayName("Successful registration new user")
    @Description("Successful registration test")
    public void newUserRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.registration(NAME, EMAIL, PASSWORD);
        LoginUser loginUser = new LoginUser(EMAIL, PASSWORD);
        userToken = User.getUserToken(loginUser);
        String actualResult = webDriver.findElement(SIGN_IN_BUTTON).getText();
        assertEquals(EXPECTED_SUCCESSFUL_TEXT, actualResult);
    }

    @Test
    @DisplayName("Invalid Password registration")
    @Description("Registration with invalid Password test")
    public void invalidPasswordRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        registrationPage.registration(NAME,EMAIL,"five");
        String actualResult = webDriver.findElement(INVALID_PASS).getText();
        assertEquals(EXPECTED_INVALID_PASS_TEXT,actualResult);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
        if (userToken != null){ User.deleteUser(userToken); }
    }
}