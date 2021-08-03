package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static Properties config;
    public static String url = null;
    public static String username = null;
    public static String password = null;
    public static String expectedItemPrice = null;
    public static String searchString = null;
    public static String driverPath = null;
    public static String browserName = null;

    public void loadConfigs(){
        //Load config properties
        config = new java.util.Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("./src/main/resources/config.properties");
            config.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        browserName =  config.getProperty("BROWSER");
        url = config.getProperty("URL");
        username = config.getProperty("USERNAME");
        password = config.getProperty("PASSWORD");
        expectedItemPrice = config.getProperty("EXPECTED_ITEM_PRICE");
        searchString = config.getProperty("SEARCH_STRING");
        driverPath = config.getProperty("DRIVER_PATH");

    }

    public void browser_Initialization(){
//        Initialize browser
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }
        else if(browserName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public void launch_url(){
        driver.get(url);
    }


    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
