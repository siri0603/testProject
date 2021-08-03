package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetEmployeeDetailsTest extends BaseApiTest{

    @BeforeMethod
    public void setup(){
        loadConfigs();
    }

    @Test
    public void verifyGetEmployee(){
            given()
                    .when()
                    .get(getApiPath)
                    .then()
                    .assertThat().statusCode(200).and()
                    .contentType(ContentType.JSON).and()
                    .body("status", equalTo("success")).and()
                    .body("message", equalTo("Successfully! Record has been fetched.")).and()
                    .body("data.id", equalTo(24)).and()
                    .body("data.employee_name", equalTo("Doris Wilder")).and()
                    .body("data.employee_salary", equalTo(85600)).and()
                    .body("data.employee_age", equalTo(23)).and()
                    .body("profile_image", equalTo(null));

    }
}
