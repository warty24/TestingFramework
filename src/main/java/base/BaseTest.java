package base;

import config.AppConfig;
import config.ConfigManager;
import config.UiSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import io.restassured.response.Response;
import java.time.Duration;

import static io.restassured.RestAssured.*;

public class BaseTest {
    @Getter
    private static WebDriver driver;
    protected static UiSettings settings;

    @BeforeSuite
    public void beforeSuite() {
        settings = ConfigManager.getConfiguration().getUiSettings();
        if(settings == null) {
            settings = getRemoteJSON().getUiSettings();
        }

        startChrome();
    }
    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }
    AppConfig getRemoteJSON() {
        String configFileAddress = "";
        Response resp = get(configFileAddress);
        return resp.as(AppConfig.class);
    }
}
