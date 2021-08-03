package api;



import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseApiTest {

    public static Properties config;
    public static String uri = null;
    public static String getApiPath = null;
    public static String deleteApiPath = null;
    public static RestAssured restAssured;

    public void loadConfigs(){

        config = new java.util.Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("./src/main/resources/apiConfig.properties");
            config.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        restAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        restAssured.baseURI =  config.getProperty("URI");
        getApiPath = config.getProperty("GET_API_PATH");
        deleteApiPath = config.getProperty("DELETE_API_PATH");
    }




}
