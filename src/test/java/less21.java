import io.github.bonigarcia.wdm.WebDriverManager;
import org.DariaRyabinina.LoginPage;
import org.DariaRyabinina.ReviewPage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class less21 {
    private WebDriver webDriver;
    public static final Logger LOGG = LoggerFactory.getLogger(less21.class);
    private static final String formatManey="\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.";

    @BeforeClass
    public void downloadDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.close();
    }

    @Test
    public void TestSpbBank() {
        webDriver.get("https://idemo.bspb.ru/");
        webDriver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(webDriver);
        loginPage
                .longin("demo", "demo")
                .enterCode("0000")
                .clickEntrButton()
                .clickButtonId();

        ReviewPage reviewPage = new ReviewPage(webDriver);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60);
        webDriverWait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(reviewPage.nameReview));

        String nameReview1 = reviewPage.nameReview.getText();
        nameReview1 = nameReview1.replaceAll("[^(а-яёА-ЯЁ)]", "");
        Assert.assertEquals(nameReview1, "Обзор","Название вкладки не \"Обзор\"");
        Assert.assertEquals(reviewPage.financialfreedom.getText(), "Финансовая свобода","Название поля не \"Финансовая свобода\"");

        webDriverWait.until(ExpectedConditions.visibilityOf(reviewPage.webColumnMoney));


        String sumMoney = reviewPage.webColumnMoney.getText().trim();
        LOGG.info("Сумма = " + sumMoney);
        boolean mach = sumMoney.matches(formatManey);
        Assert.assertTrue(mach,"Формат не соответствует");

        Actions action = new Actions(webDriver);
        action.moveToElement(reviewPage.webColumnMoney).build().perform();

        webDriverWait.until(ExpectedConditions.visibilityOf(reviewPage.webColumnMyMoney));


        String myMoney = reviewPage.webColumnMyMoney.getText();
        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        LOGG.info("Моих средств "+myMoney);
        Assert.assertEquals(myMoney, "Моих средств", "Название поля не \"Моих среств\"");
        String mySumMoney = reviewPage.webColumnMyMoney.getText().replaceAll("Моих средств", "").trim();
        LOGG.info("Моих средств ", mySumMoney);
        mach = mySumMoney.matches(formatManey);
        Assert.assertTrue(mach,"Формат не соответствует");


    }
}
