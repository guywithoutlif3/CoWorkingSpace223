package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import org.h2.util.json.JSONArray;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.restassured.http.ContentType;
import io.vertx.core.cli.annotations.Description;

import java.time.LocalDateTime;
import ch.zli.m223.model.Mitglied;

@QuarkusTest
public class MitgliedTest {
    @Test
    @Description("test if index route returns forbidden")
    public void testIndexEndpoint() {
        given()
        .when().get("/mitglied")
        .then()
                .statusCode(401)
                .body(is(""));
    }

    @Test
    @Description("test if Mitglied can only get his own")
    public void testFindByIdEndpoint() {

        given()
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Ik1heEBNdXN0ZXIuY29tIiwic3ViIjoiTWl0Z2xpZWQiLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiZXhwIjoxNjY1MzQ5NTI0ODQwLCJyb2xlIjoiTWl0Z2xpZWQiLCJpYXQiOjE2NjQzNDk1MjQsImp0aSI6IjdiMGYyZDFhLTRjZjgtNGY4MS1iYjkwLWRhYjgxMzhmNWQ0YiJ9.TNNnnAeERiTvP7hUJuBG065zrzPJIb6RQinmRWuNX8Jir-oa0tiD-8jLy1Deiqrnqp-zz1IS0K4cuXjbCw0_uNUHu4ZBajw_wUENesGzxGhcfGPelOrbkzFP_6V1iG_agAE15CDMo9xyZhVA41P400zumSxsM5bXreng3-hHOAP67zaPO7BsQjYuW-QdsC52LftrGANpveJqMXjbTojoFawxZehQBtRiPpfaoxkdIeQfRU76LBNB5Tn3EreAu6-yknCuDor0VYw9w0D6QeIEPmWH1o4GZlhPGGPc7nBkX3I-mxxJKb7asdITlATPpH8B-JTc2G_alFHfum-oIwiXrQ")
                .when().get("/mitglied/1")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("test if create of Buchung works")
    public void createBuchungTest() {
  
        
        given()
        .body("{\r\n            \"email\": \"Max1@Muster.com\",\r\n            \"passwort\": \"veryEncrypedPassword\",\r\n            \"rolle\": \"Mitglied\"\r\n        }")
        .contentType(ContentType.JSON)              
        .when().post("/mitglied")
        .then()
        .statusCode(200);
    }

    @Test
    @Description("test if create of Buchung works with wrong body")
    public void createBuchungTestWrong() {
  
        
        given()
        .body("{\r\n            \"email\": \"Max1.Muster.com\",\r\n            \"passwort\": \"veryEncrypedPassword\",\r\n            \"rolle\": \"Mitglied\"\r\n        }")
        .contentType(ContentType.JSON)              
        .when().post("/mitglied")
        .then()
        .statusCode(400);
    }

}
