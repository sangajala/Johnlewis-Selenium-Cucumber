package features;

import Utils.AutomationConstants;
import Utils.BrowserFactory;
import Utils.VerifyUtils;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
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

import java.util.Map;

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



    }


    @Given("^I am logged in user$")
    public void i_am_logged_in_user() throws Throwable {
        loginPage = new LoginPage();
        homePage = loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD);

    }


    @Then("^the Subject should be \"(.*?)\"$")
    public void the_Subject_should_be(String arg1) throws Throwable {
        Assert.assertTrue(homePage.checkHeader(arg1));
    }

    @Then("^the Subject should be \"(.*?)\" and fail$")
    public void the_Subject_should_be_fail(String arg1) throws Throwable {
        Assert.assertFalse(homePage.checkHeader(arg1));
    }


    @Given("^user open a browser$")
    public void user_open_a_browser() throws Throwable {

    }

    @And("^opens the url for \"([^\"]*)\" brand$")
    public void opens_the_url_for_brand(String brand) throws Throwable {

        if(brand.equalsIgnoreCase("Armstrong Auto"))
        {
            driver.get(AutomationConstants.ArmstrongAutoURL);
        }
    }

    @Then("^the page should be opened$")
    public void the_page_should_be_opened() throws Throwable {

        homePage = new HomePage();
    }

    @And("^the brand name should be shown as \"([^\"]*)\"$")
    public void the_brand_name_should_be_shown_brand_name_in_header_as(String header) throws Throwable {

        VerifyUtils.True("Checking if user can see header",homePage.checkHeader(header));
    }

    @And("^show the below elements$")
    public void show_the_below_elements(DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMap(String.class,String.class);
        homePage.checkElements(data);

    }

    @Then("^a header with name \"(.*?)\"$")
    public void a_header_with_name(String header) throws Throwable {
        VerifyUtils.True("Checking the header is "+header,homePage.getHeader(header));
    }

    @Then("^a button with name \"(.*?)\" is shown$")
    public void a_button_with_name_is_shown(String buttontext) throws Throwable {

        VerifyUtils.True("Checking the button with text is "+buttontext,homePage.getButton(buttontext));
    }

    @When("^(?:open|close) the ham burger menu$")
    public void open_the_ham_burger_menu() throws Throwable {
        homePage = new HomePage();
        homePage.openHamBurgerMenu();
    }

    @Then("^I should see the following option$")
    public void I_should_see_the_following_option(DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMap(String.class,String.class);
        homePage.checkElements(data);
    }
}
