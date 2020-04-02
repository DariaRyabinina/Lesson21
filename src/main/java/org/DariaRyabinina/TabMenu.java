package org.DariaRyabinina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabMenu {
    private final WebDriver webDriver;

    public TabMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickButtonId(String id) {
        webDriver.findElement(By.id(id)).click();
    }
}
