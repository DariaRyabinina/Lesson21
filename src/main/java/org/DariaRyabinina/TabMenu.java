package org.DariaRyabinina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabMenu {
    PageFactory pageFactory;

    public TabMenu(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);

    }

    @FindBy(id = "bank-overview")
    WebElement code;

    public void clickButtonId() {
        code.click();
        ;
    }
}
