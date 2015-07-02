package pages;

import Utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sriramangajala on 02/07/15.
 */
public class HomePage extends BasePage {

    static Logger LOGGER = Logger.getLogger(HomePage.class);
    @FindBy(how = How.TAG_NAME, using = "h2")
    public WebElement header;

    @FindBy(how = How.ID, using = "toList")
    public WebElement toList;
    @FindBy(how = How.ID, using = "tagsElem")
    public WebElement tagsElem;
    @FindBy(how = How.ID, using = "Subject")
    public WebElement Subject;

    @FindBy(how = How.ID, using = "editableContent")
    public WebElement editableContent;


    public HomePage() {

        PageFactory.initElements(driver, this);
        Utils.waitElementPresent(By.tagName("h2"));
        if (!header.isDisplayed())
            throw new RuntimeException("No home page shown");
    }

    public void createMessageOfType(String type) {
        header.click();
        Utils.sleep(3);
        Utils.waitAndClickOnLink("New Message");
//        Utils.waitAndClickOnLink(type);

    }

    public void enterMessageHeaders(String to, String label, String subject) {

        LOGGER.info("Entering data into the field To:"+to+" Label:"+label+" Subject:"+subject);
        Utils.waitElementPresent(By.id("toList"));
        toList.sendKeys(to);
        tagsElem.sendKeys(label);
        Subject.sendKeys(subject);


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

    public boolean checkMessage(String message) {
        Utils.waitElementPresent(By.linkText(message));
        return driver.findElement(By.linkText(message)).isDisplayed();
    }
}
