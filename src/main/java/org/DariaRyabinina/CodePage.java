package org.DariaRyabinina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CodePage {
    private WebDriver webDriver;
    @FindBy(id = "otp-code")
    WebElement addCode;
    @FindBy(id = "login-otp-button")
    WebElement enterButtonCode;

    public CodePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    public CodePage enterCode(String code) {
        addCode.sendKeys(code);
        return this;
    }

    public TabMenu clickEntrButton() {
        enterButtonCode.click();
        return new TabMenu(webDriver);
    }
}
