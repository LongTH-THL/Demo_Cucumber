package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage{
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName, String appUrl) {
        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOTP = new ChromeOptions();
            chromeOTP.addArguments("-headless");
            chromeOTP.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(chromeOTP);
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(GlobalContains.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(appUrl);
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver getWebDriver() {
        return this.driver;
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            System.out.println(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFailed(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            System.out.println(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            System.out.println(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            System.out.println(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
}
