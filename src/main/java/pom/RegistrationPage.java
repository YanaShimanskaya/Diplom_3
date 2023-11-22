package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pom.MainPage.*;

public class RegistrationPage {
    public static final By REGISTRATION_BUTTON = By.xpath(".//a[@class='Auth_link__1fOlj' and text() = 'Зарегистрироваться']");
    private static final By FINAL_REG_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private static final By NAME_INPUT = By.xpath("(.//label[text()='Имя'])/../input[@class='text input__textfield text_type_main-default']");
    private static final By EMAIL_INPUT = By.xpath("(.//label[text()='Email'])/../input[@class='text input__textfield text_type_main-default']");
    private static final By PASSWORD_INPUT = By.xpath("(.//label[text()='Пароль'])/../input[@class='text input__textfield text_type_main-default']");
    public static final By INVALID_PASS = By.xpath(".//p[text()='Некорректный пароль']");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку Персональный аккаунт")
    public void clickOnPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickOnRegisterButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Нажать финальную кнопку Регистрации")
    public void clickOnFinalRegisterButton() {
        driver.findElement(FINAL_REG_BUTTON).click();
    }

    @Step("Ввести Имя")
    public void sendKeyName(String name) {
        driver.findElement(pom.RegistrationPage.NAME_INPUT).sendKeys(name);
    }

    @Step("Ввести email")
    public void setEmail(String email) {
        driver.findElement(pom.RegistrationPage.EMAIL_INPUT).sendKeys(email);
    }

    @Step("Ввести Пароль")
    public void setPassword(String password) {
        driver.findElement(pom.RegistrationPage.PASSWORD_INPUT).sendKeys(password);
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
