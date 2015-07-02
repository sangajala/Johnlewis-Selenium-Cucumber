package features;

import Utils.AutomationConstants;
import Utils.BrowserFactory;
import Utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by sriramangajala on 02/07/15.
 */
public class FuncStepDef {

    public WebDriver driver;
    public LoginPage loginPage;// = new LoginPage();
    private HomePage homePage;


    @Before
    public void start()
    {
        driver = BrowserFactory.getDriver();
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

        Utils.sleep(5);
        driver.navigate().to("https://app.whispir.it/");

    }


    @Given("^I am logged in user$")
    public void i_am_logged_in_user() throws Throwable {
        loginPage = new LoginPage();
        homePage = loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD);

    }

    @When("^I want to create a message with type \"(.*?)\"$")
    public void i_want_to_create_a_message_with_type(String type) throws Throwable {
        homePage.createMessageOfType(type);

    }

    @When("^full the receipt field To \"(.*?)\" label \"(.*?)\" Subject \"(.*?)\"$")
    public void full_the_receipt_field_To_label_Subject(String to, String label, String subject) throws Throwable {
        homePage.enterMessageHeaders(to,label,subject);
    }

    @When("^enter the body of the message as \"(.*?)\"$")
    public void enter_the_body_of_the_message_as(String arg1) throws Throwable {
        homePage.enterBody(arg1);
    }

    @When("^send the message$")
    public void send_the_message() throws Throwable {
        homePage.sendMessage();
    }

    @Then("^the Subject should be \"(.*?)\"$")
    public void the_Subject_should_be(String arg1) throws Throwable {
        Assert.assertTrue(homePage.checkMessage(arg1));
    }

    @Then("^the Subject should be \"(.*?)\" and fail$")
    public void the_Subject_should_be_fail(String arg1) throws Throwable {
        Assert.assertFalse(homePage.checkMessage(arg1));
    }



}
