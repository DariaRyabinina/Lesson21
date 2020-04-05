import io.github.bonigarcia.wdm.WebDriverManager;
import org.DariaRyabinina.CodePage;
import org.DariaRyabinina.LoginPage;
import org.DariaRyabinina.ReviewPage;
import org.DariaRyabinina.TabMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class less20 {
    private WebDriver webDriver;
    public static final Logger LOGG = LoggerFactory.getLogger(less20.class);

    @BeforeClass
    public void downloadDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver() {
        webDriver = new ChromeDriver();
    }

    /*  @AfterMethod
       public void closeDriver() {
           webDriver.close();
       }
 */
    @Test
    public void Test1() {
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
        webDriverWait.until(ExpectedConditions.visibilityOf(reviewPage.nameReview));
        String nameReview1 = reviewPage.nameReview.getText();
        nameReview1 = nameReview1.replaceAll("[^(а-яёА-ЯЁ)]", "");
        Assert.assertEquals(nameReview1, "Обзор");
        Assert.assertEquals(reviewPage.financialfreedom.getText(), "Финансовая свобода");

        webDriverWait.until(ExpectedConditions.visibilityOf(reviewPage.webColumnMoney));

        String sumMoney = reviewPage.webColumnMoney.getText().trim();
        LOGG.info(sumMoney);
        boolean mach = sumMoney.matches("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.");
        Assert.assertTrue(mach);


        Actions action = new Actions(webDriver);
        action.moveToElement(reviewPage.webColumnMoney).build().perform();

        String myMoney = reviewPage.webColumnMyMoney.getText();
        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        LOGG.info(myMoney);
        Assert.assertEquals(myMoney, "Моих средств");
        String mySumMoney = reviewPage.webColumnMyMoney.getText().replaceAll("Моих средств", "").trim();
        LOGG.info(mySumMoney);
        mach = mySumMoney.matches("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.");
        Assert.assertTrue(mach);


    }
}
