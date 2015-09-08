package pages;

import Utils.Utils;
import Utils.VerifyUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by sriramangajala on 02/07/15.
 */
public class HomePage extends BasePage {

    static Logger LOGGER = Logger.getLogger(HomePage.class);


    @FindBy(how = How.CLASS_NAME, using = "dealer-name")
    public WebElement header;

    @FindBy(how = How.ID, using = "Subject")
    public WebElement Subject;

    @FindBy(how = How.CLASS_NAME, using = "hamburger_button")
    public WebElement hamburger_button;

    @FindBy(how = How.ID, using = "")
    public WebElement editableContent;

    @FindBy(how = How.CSS, using = "span.header_links.shop_link")
    public WebElement header_links_shop_link;

    @FindBy(how = How.LINK_TEXT, using = "Show all shops")
    public WebElement Show_all_shops;


    public HomePage() {

        PageFactory.initElements(driver, this);
        Utils.waitElementPresent(By.linkText("Basket"));
        if (!driver.findElement(By.linkText("Basket")).isDisplayed())
            throw new RuntimeException("No home page shown");
    }


    public void enterBody(String body) {

        driver.switchTo().frame("iframeCommonBody");
        editableContent.sendKeys(body);
        driver.switchTo().defaultContent();

    }

    public void sendMessage() {
        ((JavascriptExecutor) driver).executeScript("checkLimitBeforeSend('/web_com/SendMessage?', 'send')");
//        driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
    }

    public boolean checkHeader(String message) {
        return header.getText().contains(message);
    }


    public boolean getHeader(String header) {
        return this.header.getText().contains(header);
    }

    public boolean getButton(String buttontext) {
        List<WebElement> elements = driver.findElements(By.tagName("button"));

        for (WebElement element : elements) {
            try {
                element.findElement(By.tagName("span")).getText().contains(buttontext);
                return true;
            } catch (Exception e) {
                //ignore
            }
        }

        return false;
    }

    public void openHamBurgerMenu() {
        hamburger_button.click();
    }

    public void openAllShops() {
        header_links_shop_link.click();
        Utils.sleep(3);
        Show_all_shops.click();

    }

    public void checkBranchIsShown(String branch) {
        VerifyUtils.True("Checking that the branch " + branch + " is available", Utils.isElementPresent(By.linkText(branch)));
    }

    public void openTheBranch(String branch) {
        driver.findElement(By.linkText(branch)).click();
    }

    public void checkBranchText(String branch) {
        VerifyUtils.ContainsTrue("Checking the branch details are shown " + branch, Utils.getVisibleText(), "John Lewis " + branch);
    }
}
