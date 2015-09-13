package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sriramangajala on 13/09/15.
 */
public class SearchResultPage extends BasePage{

    @FindBy(how = How.CLASS_NAME, using = "un_prod_name")
    public WebElement firstitem;

    @FindBy(how = How.XPATH,using = "//input[@value='Add to Basket']")
    public WebElement Add_to_basket;



    public SearchResultPage() {

        PageFactory.initElements(driver,this);
    }

    public void addFirstItemIntoTheBasket(){
        Assert.assertTrue(driver.findElement(By.className("un_prod_name")).isDisplayed());
        firstitem.click();
        Add_to_basket.click();

    }
}
