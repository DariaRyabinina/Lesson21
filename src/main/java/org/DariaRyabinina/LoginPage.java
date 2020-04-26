package org.DariaRyabinina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver webDriver;

    @FindBy(name = "username")
    private WebElement loginFiled;

    @FindBy(name = "password")
    private WebElement passFiled;
    @FindBy(id = "login-button")
    private WebElement enterButtonLogin;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public CodePage longin(String login, String password) {
        loginFiled.clear();
        loginFiled.sendKeys(login);
        passFiled.clear();
        passFiled.sendKeys(password);
        enterButtonLogin.click();
        return new CodePage(webDriver);
    }
}
