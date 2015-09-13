package pages;

import Utils.VerifyUtils;
import org.openqa.selenium.By;

/**
 * Created by sriramangajala on 13/09/15.
 */
public class Basketpage extends BasePage{

    public void checkItemIsAdded()
    {
        VerifyUtils.True("Checking that item is added",driver.findElement(By.tagName("body")).getText().contains("Added to"));
    }


}
