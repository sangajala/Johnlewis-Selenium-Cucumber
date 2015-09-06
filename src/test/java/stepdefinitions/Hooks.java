package stepdefinitions;

import Utils.AutomationConstants;
import Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;

public class Hooks {
    public static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(BrowserFactory.class);

    @BeforeClass
    public static void openBrowser() throws MalformedURLException {
        LOGGER.info("Opening Browser.....");
        driver = BrowserFactory.getDriver();
        driver.get(AutomationConstants.ENV_URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
        driver = null;
    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }

    }

}