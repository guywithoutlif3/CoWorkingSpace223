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
public class BuchungTest {
    @Test
    @Description("test if index route returns forbidden")
    public void testIndexEndpoint() {
        given()
        .when().get("/buchung")
        .then()
                .statusCode(401)
                .body(is(""));
    }

    @Test
    @Description("test if index route returns forbidden")
    public void testFindByIdEndpoint() {

        given()
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6Ik1heEBNdXN0ZXIuY29tIiwic3ViIjoiTWl0Z2xpZWQiLCJncm91cHMiOlsiTWl0Z2xpZWQiXSwiZXhwIjoxNjY1MzQ5NTI0ODQwLCJyb2xlIjoiTWl0Z2xpZWQiLCJpYXQiOjE2NjQzNDk1MjQsImp0aSI6IjdiMGYyZDFhLTRjZjgtNGY4MS1iYjkwLWRhYjgxMzhmNWQ0YiJ9.TNNnnAeERiTvP7hUJuBG065zrzPJIb6RQinmRWuNX8Jir-oa0tiD-8jLy1Deiqrnqp-zz1IS0K4cuXjbCw0_uNUHu4ZBajw_wUENesGzxGhcfGPelOrbkzFP_6V1iG_agAE15CDMo9xyZhVA41P400zumSxsM5bXreng3-hHOAP67zaPO7BsQjYuW-QdsC52LftrGANpveJqMXjbTojoFawxZehQBtRiPpfaoxkdIeQfRU76LBNB5Tn3EreAu6-yknCuDor0VYw9w0D6QeIEPmWH1o4GZlhPGGPc7nBkX3I-mxxJKb7asdITlATPpH8B-JTc2G_alFHfum-oIwiXrQ")
                .when().get("/buchung/1")
                .then()
                .statusCode(200);
    }


    @Test
    @Description("test if create of Buchung works")
    public void createBuchungTest() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InNldmVyaW4ubWFjaGF6QGJsdWV3aW4uY2giLCJzdWIiOiJBZG1pbiIsImdyb3VwcyI6WyJBZG1pbiJdLCJleHAiOjE2NjUzNjU5MzU2OTEsInJvbGUiOiJBZG1pbiIsImlhdCI6MTY2NDM2NTkzNSwianRpIjoiMTE3ZTQ2ZWItMDZjZC00Yzc4LWFhYzYtMWRiNzNlOTUwN2EyIn0.PfiAwyAnNOO3tPAyQbrPP3NA76l3-dZuPFNtAaV_gpyVSDoP0PwBKBNwKUKTsrfpbRqDepfWNcl6JoypqDXVtmUTXUOmla7axPVvM6f7I4JNpubaupD941agakKc44I-nyd3k39mjocL6qNjha-Vd76k86_zKErowdV1RGa79FC6GfIO4L7bvt948WcP7-HEvA7pziJWtZHjhzB7R9-L7IwVmmhPeK7b1UwLcuKsWFY34j6DxmEKPmbxDv5BCxCVMQCWMFb3Nz6KZ5Vzn8oChd6o2pNXAfS4vPZh_LMeAOl0kzx1BVl_wotoZzFTBMU87m_DnN5MHJMq65Zdm9wIXA")
        .body("{\r\n    \"datum\": \"2022-09-28T18:32:32.333Z\",\r\n    \"halbtag\": \"True\",\r\n    \"status\": \"True\",\r\n    \"mitglied\": {  \r\n        \"id\": 1\r\n    }\r\n  }")
        .contentType(ContentType.JSON)              
        .when().post("/buchung")
        .then()
        .statusCode(200);
    }

    @Test
    @Description("test if create of Buchung works with wrong input")
    public void createBuchungTestWrong() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InNldmVyaW4ubWFjaGF6QGJsdWV3aW4uY2giLCJzdWIiOiJBZG1pbiIsImdyb3VwcyI6WyJBZG1pbiJdLCJleHAiOjE2NjUzNjU5MzU2OTEsInJvbGUiOiJBZG1pbiIsImlhdCI6MTY2NDM2NTkzNSwianRpIjoiMTE3ZTQ2ZWItMDZjZC00Yzc4LWFhYzYtMWRiNzNlOTUwN2EyIn0.PfiAwyAnNOO3tPAyQbrPP3NA76l3-dZuPFNtAaV_gpyVSDoP0PwBKBNwKUKTsrfpbRqDepfWNcl6JoypqDXVtmUTXUOmla7axPVvM6f7I4JNpubaupD941agakKc44I-nyd3k39mjocL6qNjha-Vd76k86_zKErowdV1RGa79FC6GfIO4L7bvt948WcP7-HEvA7pziJWtZHjhzB7R9-L7IwVmmhPeK7b1UwLcuKsWFY34j6DxmEKPmbxDv5BCxCVMQCWMFb3Nz6KZ5Vzn8oChd6o2pNXAfS4vPZh_LMeAOl0kzx1BVl_wotoZzFTBMU87m_DnN5MHJMq65Zdm9wIXA")
        .body("{\r\n    \"datum\": \"2022-09-2818:32:32.333Z\",\r\n    \"halbtag\": \"True\",\r\n    \"status\": \"True\",\r\n    \"mitglied\": {  \r\n        \"id\": 1\r\n    }\r\n  }")
        .contentType(ContentType.JSON)              
        .when().post("/buchung")
        .then()
        .statusCode(400);
    }

    @Test
    @Description("test if create of Buchung works with wrong input")
    public void createBuchungTestWrong2() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InNldmVyaW4ubWFjaGF6QGJsdWV3aW4uY2giLCJzdWIiOiJBZG1pbiIsImdyb3VwcyI6WyJBZG1pbiJdLCJleHAiOjE2NjUzNjU5MzU2OTEsInJvbGUiOiJBZG1pbiIsImlhdCI6MTY2NDM2NTkzNSwianRpIjoiMTE3ZTQ2ZWItMDZjZC00Yzc4LWFhYzYtMWRiNzNlOTUwN2EyIn0.PfiAwyAnNOO3tPAyQbrPP3NA76l3-dZuPFNtAaV_gpyVSDoP0PwBKBNwKUKTsrfpbRqDepfWNcl6JoypqDXVtmUTXUOmla7axPVvM6f7I4JNpubaupD941agakKc44I-nyd3k39mjocL6qNjha-Vd76k86_zKErowdV1RGa79FC6GfIO4L7bvt948WcP7-HEvA7pziJWtZHjhzB7R9-L7IwVmmhPeK7b1UwLcuKsWFY34j6DxmEKPmbxDv5BCxCVMQCWMFb3Nz6KZ5Vzn8oChd6o2pNXAfS4vPZh_LMeAOl0kzx1BVl_wotoZzFTBMU87m_DnN5MHJMq65Zdm9wIXA")
        .body("{\r\n    \"datum\": \"2022-09-28T18:32:32.333Z\",\r\n    \"halbtag\": \"True\",\r\n    \"status\": \"True\",\r\n    \"mitglied\": {  \r\n        \"id\": 5\r\n    }\r\n  }")
        .contentType(ContentType.JSON)              
        .when().post("/buchung")
        .then()
        .statusCode(500);
    }
}
