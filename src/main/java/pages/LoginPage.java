package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    static Logger LOGGER = Logger.getLogger(LoginPage.class);
    @FindBy(how = How.ID, using = "email")
    public WebElement email;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement password;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement signin_button;

    @FindBy(how = How.ID, using = "id-username")
    public WebElement id_username;

    @FindBy(how = How.ID, using = "id-password")
    public WebElement id_password;

    @FindBy(how = How.ID, using = "email_create")
    public WebElement email_create;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement submit_create;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In')]")
    public WebElement signIn;

    public LoginPage() {

        PageFactory.initElements(driver, this);
        driver.navigate().refresh();
        if (!id_username.isDisplayed())
            throw new RuntimeException("Unable to see login");
    }


    public HomePage login(String username, String password) {
        id_username.sendKeys(username);
        id_password.sendKeys(password);
        signIn.click();

        return new HomePage();

    }
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
