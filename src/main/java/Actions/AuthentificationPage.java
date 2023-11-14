package Actions;

import org.openqa.selenium.WebDriver;

import static POM.AuthPage.*;

public class AuthentificationPage {
    private final WebDriver webDriver;

    public AuthentificationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void sendKeyEmail(String email) {
        webDriver.findElement(POM.AuthPage.EMAIL_INPUT).sendKeys(email);
    }
    public void sendKeyPassword(String password) {
        webDriver.findElement(POM.AuthPage.PASS_INPUT).sendKeys(password);
    }
    public void signIn() {
        webDriver.findElement(SIGN_IN_BUTTON).click();
    }
    public void loginFromMainPage(String email, String password) {
        sendKeyEmail(email);
        sendKeyPassword(password);
        signIn();
    }
}