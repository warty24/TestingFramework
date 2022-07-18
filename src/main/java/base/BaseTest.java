package base;

import config.ConfigManager;
import config.UiSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    @Getter
    private static WebDriver driver;
    protected static UiSettings settings;

    @BeforeSuite
    public void beforeSuite() {
        settings = ConfigManager.getConfiguration().getUiSettings();
        startChrome();
    }
    @AfterSuite
    public void afterSuite() {
  //      driver.quit();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }
}
