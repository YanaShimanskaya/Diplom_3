package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    public static final By RESET_PASS_BUTTON = By.xpath(".//a[text()='Восстановить пароль']");
    private static final By EMAIL_INPUT = By.xpath(".//input[@name='name']");
    private static final By PASS_INPUT = By.xpath(".//input[@name='Пароль']");
    public static final By SIGN_IN_BUTTON = By.xpath(".//button[text()='Войти']");
    private  final WebDriver webDriver;


    public AuthPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ввести email")
    public void sendKeyEmail(String email) {
        webDriver.findElement(pom.AuthPage.EMAIL_INPUT).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void sendKeyPassword(String password) {
        webDriver.findElement(pom.AuthPage.PASS_INPUT).sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void signIn() {
        webDriver.findElement(SIGN_IN_BUTTON).click();
    }

    public void loginFromMainPage(String email, String password) {
        sendKeyEmail(email);
        sendKeyPassword(password);
        signIn();
    }
}
