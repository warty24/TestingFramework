package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureLogger;

public class BasePage extends AllureLogger {
    private WebDriver driver = BaseTest.getDriver();
    
    public void getPage(String url) {
        logInfo("Getting url " + url);
        if (driver == null) driver = BaseTest.getDriver();
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
    private WebElement findElement(By by) {
        logInfo("Finding element by locator: " + by);
        return driver.findElement(by);
    }
    protected void click(By by) {
        logInfo("Click element by locator: " + by);
        findElement(by).click();
    }

    protected void type(By by,String text) {
        logInfo("Type text \"" + text + "\" to " + by);
        findElement(by).sendKeys(text);
    }

    protected boolean isElementVisible(By by) {
        return findElement(by).isDisplayed();
    }

    protected String getElementText(By by) {
        return findElement(by).getText();
    }
}
