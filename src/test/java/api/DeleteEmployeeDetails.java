package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteEmployeeDetails extends BaseApiTest{


    @BeforeMethod
    public void setup(){
        loadConfigs();
    }

    @Test
    public void verifyDeleteEmployee(){

        given()
                .when()
                .delete(deleteApiPath)
                .then()
                .assertThat().statusCode(200).and()
                .contentType(ContentType.JSON).and()
                .body("status", equalTo("success")).and()
                .body("message", equalTo("Successfully! Record has been deleted"));
    }




}
