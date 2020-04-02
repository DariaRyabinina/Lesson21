package org.DariaRyabinina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CodePage {
    private final WebDriver webDriver;
    private final By addCode = By.id("otp-code");
    private final By entrButtonCode = By.id("login-otp-button");

    public CodePage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void enterCode(String code) {
        webDriver.findElement(addCode).sendKeys(code);
    }

    public void clickEntrButton() {
        webDriver.findElement(entrButtonCode).click();
    }
}
