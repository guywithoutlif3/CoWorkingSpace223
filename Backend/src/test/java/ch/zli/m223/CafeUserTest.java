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
public class CafeUserTest {
    @Test
    @Description("test if create of cafe Users works")
    public void createCafeUserTest() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Ik1heEBNdXN0ZXIuY29tIiwic3ViIjoiTWl0Z2xpZWQiLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiZXhwIjoxNjY1MzQ5NTI0ODQwLCJyb2xlIjoiTWl0Z2xpZWQiLCJpYXQiOjE2NjQzNDk1MjQsImp0aSI6IjdiMGYyZDFhLTRjZjgtNGY4MS1iYjkwLWRhYjgxMzhmNWQ0YiJ9.TNNnnAeERiTvP7hUJuBG065zrzPJIb6RQinmRWuNX8Jir-oa0tiD-8jLy1Deiqrnqp-zz1IS0K4cuXjbCw0_uNUHu4ZBajw_wUENesGzxGhcfGPelOrbkzFP_6V1iG_agAE15CDMo9xyZhVA41P400zumSxsM5bXreng3-hHOAP67zaPO7BsQjYuW-QdsC52LftrGANpveJqMXjbTojoFawxZehQBtRiPpfaoxkdIeQfRU76LBNB5Tn3EreAu6-yknCuDor0VYw9w0D6QeIEPmWH1o4GZlhPGGPc7nBkX3I-mxxJKb7asdITlATPpH8B-JTc2G_alFHfum-oIwiXrQ")
        .body("{\r\n    \"timestamp\": \"2022-09-28T18:32:32.333Z\",\r\n    \"mitglied\": {  \r\n        \"id\": 1\r\n    }\r\n  }")
        .contentType(ContentType.JSON)              
        .when().post("/cafeUser")
        .then()
        .statusCode(200);
    }

    @Test
    @Description("test if create of cafe Users works with wrong data")
    public void createCafeUserTestWrong() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Ik1heEBNdXN0ZXIuY29tIiwic3ViIjoiTWl0Z2xpZWQiLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiZXhwIjoxNjY1MzQ5NTI0ODQwLCJyb2xlIjoiTWl0Z2xpZWQiLCJpYXQiOjE2NjQzNDk1MjQsImp0aSI6IjdiMGYyZDFhLTRjZjgtNGY4MS1iYjkwLWRhYjgxMzhmNWQ0YiJ9.TNNnnAeERiTvP7hUJuBG065zrzPJIb6RQinmRWuNX8Jir-oa0tiD-8jLy1Deiqrnqp-zz1IS0K4cuXjbCw0_uNUHu4ZBajw_wUENesGzxGhcfGPelOrbkzFP_6V1iG_agAE15CDMo9xyZhVA41P400zumSxsM5bXreng3-hHOAP67zaPO7BsQjYuW-QdsC52LftrGANpveJqMXjbTojoFawxZehQBtRiPpfaoxkdIeQfRU76LBNB5Tn3EreAu6-yknCuDor0VYw9w0D6QeIEPmWH1o4GZlhPGGPc7nBkX3I-mxxJKb7asdITlATPpH8B-JTc2G_alFHfum-oIwiXrQ")
        .body("{\r\n    \"timestamp\": \"2022-09-28 18:32:32.333\",\r\n    \"mitglied\": {  \r\n        \"id\": 1\r\n    }\r\n  }")
        .contentType(ContentType.JSON)              
        .when().post("/cafeUser")
        .then()
        .statusCode(400);
    }

   

    

}
