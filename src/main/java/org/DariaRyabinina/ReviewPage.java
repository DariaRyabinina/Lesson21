package org.DariaRyabinina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {


    public ReviewPage(WebDriver webDriver) {
       PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//@id[.='header-container']/following::h1[1]")
    public WebElement nameReview;
    @FindBy(xpath = "//span[@class='amount-holder']/span[@class='amount']")
    public WebElement webColumnMoney;
    @FindBy(xpath = "//@id[.='can-spend'][1]/following::span[1]")
    public WebElement financialfreedom;
    @FindBy(xpath = "//small[@class='my-assets']")
    public WebElement webColumnMyMoney;

}
