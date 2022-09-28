package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.vertx.web.Body;

import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.restassured.http.ContentType;
import io.vertx.core.cli.annotations.Description;

import java.time.LocalDateTime;
import ch.zli.m223.model.Mitglied;

@QuarkusTest
public class AuthTest {
    @Test
    @Description("test if login works")
    public void loginTest() {
  
        
        given()
        .body("{\r\n        \"id\": 1,\r\n        \"email\": \"Max@Muster.com\",\r\n        \"passwort\": \"veryEncrypedPassword\",\r\n        \"rolle\": \"Mitglied\\n\"\r\n    }")
        .contentType(ContentType.JSON)              
        .when().post("/auth/login")
        .then()
        .statusCode(200);
    }

    @Test
    @Description("test if login works with wrong password")
    public void loginWrongTest() {
  
        
        given()
        .body("{\r\n            \"id\": 1,\r\n            \"email\": \"Max@Muster.com\",\r\n            \"passwort\": \"veryEncrypedPasswor\",\r\n            \"rolle\": \"Mitglied\\n\"\r\n        }")
        .contentType(ContentType.JSON)              
        .when().post("/auth/login")
        .then()
        .statusCode(200)
        .body(is("no access"));
    }

    

}
