package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage extends BaseTest {
    public void getPage(String url) {
        getDriver().get(url);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }
    private WebElement findElement(By by) {
        return getDriver().findElement(by);
    }
    public void click(By by) {
        findElement(by).click();
    }

    public void type(By by,String text) {
        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by) {
        return findElement(by).isDisplayed();
    }

}
