package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.vertx.core.cli.annotations.Description;
import io.quarkus.test.junit.QuarkusTest;

import org.h2.util.json.JSONArray;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.restassured.http.ContentType;
import io.vertx.core.cli.annotations.Description;

import java.time.LocalDateTime;
import ch.zli.m223.model.Monitor;


public class MonitorTest {
    @Test
    @Description("test if create of Monitor works")
    public void createMonitorTest() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InNldmVyaW4ubWFjaGF6QGJsdWV3aW4uY2giLCJzdWIiOiJBZG1pbiIsImdyb3VwcyI6WyJBZG1pbiJdLCJleHAiOjE2NjUzNjU5MzU2OTEsInJvbGUiOiJBZG1pbiIsImlhdCI6MTY2NDM2NTkzNSwianRpIjoiMTE3ZTQ2ZWItMDZjZC00Yzc4LWFhYzYtMWRiNzNlOTUwN2EyIn0.PfiAwyAnNOO3tPAyQbrPP3NA76l3-dZuPFNtAaV_gpyVSDoP0PwBKBNwKUKTsrfpbRqDepfWNcl6JoypqDXVtmUTXUOmla7axPVvM6f7I4JNpubaupD941agakKc44I-nyd3k39mjocL6qNjha-Vd76k86_zKErowdV1RGa79FC6GfIO4L7bvt948WcP7-HEvA7pziJWtZHjhzB7R9-L7IwVmmhPeK7b1UwLcuKsWFY34j6DxmEKPmbxDv5BCxCVMQCWMFb3Nz6KZ5Vzn8oChd6o2pNXAfS4vPZh_LMeAOl0kzx1BVl_wotoZzFTBMU87m_DnN5MHJMq65Zdm9wIXA")
        .body("{\r\n    \"name\":\"name\"\r\n\r\n}")
        .contentType(ContentType.JSON)              
        .when().post("/monitor")
        .then()
        .statusCode(200);
    }

    @Test
    @Description("test if create of Monitor work with wrong data")
    public void createMonitorTestWrong() {
  
        
        given()
        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InNldmVyaW4ubWFjaGF6QGJsdWV3aW4uY2giLCJzdWIiOiJBZG1pbiIsImdyb3VwcyI6WyJBZG1pbiJdLCJleHAiOjE2NjUzNjU5MzU2OTEsInJvbGUiOiJBZG1pbiIsImlhdCI6MTY2NDM2NTkzNSwianRpIjoiMTE3ZTQ2ZWItMDZjZC00Yzc4LWFhYzYtMWRiNzNlOTUwN2EyIn0.PfiAwyAnNOO3tPAyQbrPP3NA76l3-dZuPFNtAaV_gpyVSDoP0PwBKBNwKUKTsrfpbRqDepfWNcl6JoypqDXVtmUTXUOmla7axPVvM6f7I4JNpubaupD941agakKc44I-nyd3k39mjocL6qNjha-Vd76k86_zKErowdV1RGa79FC6GfIO4L7bvt948WcP7-HEvA7pziJWtZHjhzB7R9-L7IwVmmhPeK7b1UwLcuKsWFY34j6DxmEKPmbxDv5BCxCVMQCWMFb3Nz6KZ5Vzn8oChd6o2pNXAfS4vPZh_LMeAOl0kzx1BVl_wotoZzFTBMU87m_DnN5MHJMq65Zdm9wIXA")
        .body("{id: \"10\" }")
        .contentType(ContentType.JSON)              
        .when().post("/monitor")
        .then()
        .statusCode(500);
    }

    
}
