package org.DariaRyabinina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver webDriver;
    private final By loginFiled = By.name("username");
    private final By passFiled = By.name("password");
    private final By enterButtonLogin = By.id("login-button");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void longin(String login, String password) {
        webDriver.findElement(loginFiled).clear();
        webDriver.findElement(loginFiled).sendKeys(login);
        webDriver.findElement(passFiled).clear();
        webDriver.findElement(passFiled).sendKeys(password);
        webDriver.findElement(enterButtonLogin).click();
    }
}
