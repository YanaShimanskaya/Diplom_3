package actions;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static app.config.AppConfig.*;
import static io.restassured.RestAssured.given;

public class User {
    private static final String HEADER = "Content-type";
    private static final String HEADER_TYPE = "application/json";

    @Step("Создать нового пользователя")
    public static void newUser(CreateUser createUser) {
        given()
                .relaxedHTTPSValidation()
                .header(HEADER, HEADER_TYPE)
                .body(createUser)
                .when()
                .post(REGISTER_PATH);

    }

    @Step("Удалить пользователя")
    public static void deleteUser(String token) {
        given()
                .relaxedHTTPSValidation()
                .header(HEADER, HEADER_TYPE)
                .auth().oauth2(token)
                .when()
                .delete(USER_PATH);
    }

    @Step("Получить токен пользователя")
    public static String getUserToken(LoginUser loginUser) {
        Response response = login(loginUser);
        String accessToken = response.jsonPath().get("accessToken");
        return accessToken.replace("Bearer ", "");
    }

    @Step("Авторизация пользователя")
    public static Response login(LoginUser loginUser) {
        return
                given()
                        .relaxedHTTPSValidation()
                        .header(HEADER, HEADER_TYPE)
                        .body(loginUser)
                        .when()
                        .post(LOGIN_PATH);
    }

}