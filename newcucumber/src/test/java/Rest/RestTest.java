package Rest;

import DbPichypido.Food;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Допустим;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

public class RestTest {
    private static final String Base_Uri = "http://localhost:8080/";
    private static Cookie cookie = null;


    public static List<Food> getItem(ContentType contentType, int status){
    List<Food> fod =
            given()
                    .baseUri(Base_Uri)
                    .cookie(getCookie())
                    .contentType(contentType)
                    .basePath("api/")
                    .get("food")
                    .then()
                    .statusCode(status)
                    .extract()
                    .jsonPath().getList("", Food.class);
    return fod;
}

    public static void addItems(String name, String type, boolean exotic, int status) {

        String body = String.format("{\n" +
                "    \"name\": \"%s\",\n" +
                "    \"type\": \"%2s\",\n" +
                "    \"exotic\": %3s\n" +
                "}", name, type, exotic);
        given()
                .baseUri(Base_Uri)
                .cookie(getCookie())
                .body(body)
                .basePath("api/food")
                .contentType(ContentType.JSON)
                .accept("*/*")
                .post()
                .then()
                .statusCode(status);
    }

    public static Cookie getCookie () {
        if(cookie == null) {
            String token = given()
                    .basePath("api/")
                    .get("food")
                    .cookie("JSESSIONID");
            cookie = new Cookie.Builder("JSESSIONID", token)
                    .setSecured(true)
                    .setComment("test")
                    .build();
        }

        if(cookie != null)
            return cookie;

        return null;
    }

    public static void rest(int status) {
        given()
                .baseUri(Base_Uri)
                .cookie(getCookie())
                .basePath("api/")
                .post("data/reset")
                .then()
                .statusCode(status);
    }



}

/*    @Test
    void test1() {

        Response response = given()
                .baseUri(Base_Url)
                .when()
                .log().all()
                .get("/food");
        Assertions.assertEquals(200, response.getStatusCode());

    }

    @Test
    void test2() {

        given()
                .baseUri(Base_Url)
                .when()
                .log().all()
                .get("/food")
                .then()
                .assertThat()
                .statusCode(200);


    }*/


