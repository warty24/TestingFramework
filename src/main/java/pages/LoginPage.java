package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By loginField = new By.ByXPath("//input[@name='username']");
    private final By passwordField = new By.ByXPath("//input[@name='password']");
    private final By loginButton = new By.ByXPath("//input[@type='submit']");
    private final By errorMessage = new By.ByXPath("//*[@class='help-block']");

    public void clickLoginField() {
        click(loginField);
    }
    public void typeLogin(String login) {
        type(loginField, login);
    }
    public void typePassword(String password) {
        type(passwordField, password);
    }
    public void clickLoginButton() {
        click(loginButton);
    }
    public boolean isErrorMessagePresent() {
        return isElementVisible(errorMessage);
    }
    public String getErrorMessage() {
        return getElementText(errorMessage);
    }




}
