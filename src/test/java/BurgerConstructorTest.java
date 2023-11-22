import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static app.config.AppConfig.*;

import static driver.config.DriverConfig.GET_DRIVER_CONFIG;
import static org.junit.Assert.assertEquals;
import static pom.MainPage.*;

public class BurgerConstructorTest {
    private WebDriver webDriver;

    @Before
    public void setUp(){
        webDriver = GET_DRIVER_CONFIG();
    }

    @Test
    @DisplayName("Bun section")
    @Description("Going to BUN section test")
    public void goingToBunSectionTest() {
        WebElement filling = new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(FILLING));
        filling.click();
        WebElement bun =  new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(BUN));
        bun.click();
        String actualResult = webDriver.findElement(ACTIVE_TAB).getText();
        assertEquals(EXPECTED_BUN_SECTION_TEXT,actualResult);
    }

    @Test
    @DisplayName("Sauces section")
    @Description("Going to SAUSES section test")
    public void goingToSaucesSectionTest() {
        webDriver.findElement(SAUCES).click();
        String actualResult = webDriver.findElement(ACTIVE_TAB).getText();
        assertEquals(EXPECTED_SAUCES_SECTION_TEXT,actualResult);
    }

    @Test
    @DisplayName("Filling section")
    @Description("Going to FILLING section test")
    public void goingToFillingSectionTest() {
        webDriver.findElement(FILLING).click();
        String actualResult = webDriver.findElement(ACTIVE_TAB).getText();
        assertEquals(EXPECTED_FILLING_SECTION_TEXT,actualResult);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
    }
}