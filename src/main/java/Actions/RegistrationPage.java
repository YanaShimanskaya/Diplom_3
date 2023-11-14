package Actions;

import org.openqa.selenium.WebDriver;

import static POM.MainPage.PERSONAL_ACCOUNT_BUTTON;
import static POM.RegistrationPage.*;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }
    public void clickOnRegisterButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }
    public void clickOnFinalRegisterButton() {
        driver.findElement(FINAL_REG_BUTTON).click();
    }

    public void sendKeyName(String name) {
        driver.findElement(POM.RegistrationPage.NAME_INPUT).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(POM.RegistrationPage.EMAIL_INPUT).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(POM.RegistrationPage.PASSWORD_INPUT).sendKeys(password);
    }

    public void registration(String name, String email, String password) {
        clickOnPersonalAccountButton();
        clickOnRegisterButton();
        sendKeyName(name);
        setEmail(email);
        setPassword(password);
        clickOnFinalRegisterButton();
    }
}