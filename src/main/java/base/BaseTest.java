package base;

import config.ConfigManager;
import config.UiSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import utils.AllureLogger;

import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest extends AllureLogger {
    @Getter
    private static WebDriver driver;
    protected static UiSettings settings;

    @BeforeSuite
    public void beforeSuite() {
        settings = ConfigManager.getConfiguration().getUiSettings();
        startChrome();
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        logInfo("Chrome driver started");
    }
}
