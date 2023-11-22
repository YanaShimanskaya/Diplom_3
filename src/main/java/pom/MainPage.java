package pom;

import org.openqa.selenium.By;

public class MainPage {
    public static final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//a[@class='AppHeader_header__link__3D_hX']/p[text()= 'Личный Кабинет']");
    public static final By ACCOUNT_SIGNIN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By MAKE_ORDER_BUTTON = By.xpath("/html/body/div/div/main/section[2]/div/button");
    public static final By BURGER_CONSTRUCTOR_BUTTON = By.xpath(".//p[contains(@class,'AppHeader_header__linkText__3q_va ml-2') and text()='Конструктор']");
    public static final By MAKE_BURGER_TEXT = By.xpath(".//h1[text()='Соберите бургер']");
    public static final By BUN = By.xpath(".//span[text()='Булки']");
    public static final By SAUCES = By.xpath(".//span[text()='Соусы']");
    public static final By FILLING = By.xpath(".//span[text()='Начинки']");
    public static final By ACTIVE_TAB = By.className("tab_tab_type_current__2BEPc");

}