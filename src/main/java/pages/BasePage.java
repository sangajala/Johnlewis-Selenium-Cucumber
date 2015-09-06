package pages;

import Utils.BrowserFactory;
import Utils.VerifyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by sriramangajala on 01/07/15.
 */
public class BasePage {

    WebDriver driver = BrowserFactory.getDriver();

    public void checkElements(Map<String, String> data) {
        System.out.println("data = [" + data + "]");

            for(Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if(key.equalsIgnoreCase("link"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.linkText(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("name"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.name(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("class"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.className(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("id"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.id(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("xpath"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.xpath(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("css"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.cssSelector(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("tag"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.tagName(value)).isDisplayed());
                }
                else if(key.equalsIgnoreCase("button"))
                {
                    VerifyUtils.True("Checking element type "+key+" with name "+value,driver.findElement(By.xpath("//button[text()='"+value+"']")).isDisplayed());
                }
                else
                    VerifyUtils.Info("Not valid element type "+key);

                // do what you have to do here
                // In your case, an other loop.
            }
    }
}
