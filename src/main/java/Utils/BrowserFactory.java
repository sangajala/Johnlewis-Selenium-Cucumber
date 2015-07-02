package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public abstract class BrowserFactory 
	{
	public static WebDriver driver;

     static Logger LOGGER = Logger.getLogger(BrowserFactory.class);
		
	public static WebDriver StartBrowser(String Browser,String URL) throws MalformedURLException, InterruptedException 
	{
        if(driver==null||!isSessionActive())
        {
         driver = startRemoteWebBrowser(Browser,URL);
        }
		driver.manage().window().maximize();
        return driver;
	}

        public static WebDriver getDriver()
        {
            return driver;
        }

        public static boolean isSessionActive()
        {
            try {

                return driver.findElements(By.tagName("body")).size()>0;

            }
            catch(Exception e)
            {

            }
            return false;
        }


	public static void QuitBrowser() 
	{
	    driver.quit();
      //  WebDriver d = getDriver();
        driver=null;
	}
protected static WebDriver startRemoteWebBrowser(String browser,String URL)
{

    if(AutomationConstants.REMOTE_BROWSER.equalsIgnoreCase("true"))
    {
        try
        {

       //    System.setProperty("webdriver.chrome.driver", "/Users/sriramangajala/Documents/Automation/chromedriver");
            //  driver=new ChromeDriver();
        	System.out.println("grid started...");
        	DesiredCapabilities capabilities = new DesiredCapabilities();
            if(System.getProperty("Browser").equalsIgnoreCase("firefox"))
            {
                capabilities = DesiredCapabilities.firefox();
            }
            else if(System.getProperty("Browser").equalsIgnoreCase("chrome"))
            {
                capabilities = DesiredCapabilities.chrome();
            }

        	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	capabilities.setCapability("platform", Platform.VISTA);
        	driver = new ScreenShotRemoteWebDriver(
					new URL(AutomationConstants.SELENIUM_GRID_URL),
					capabilities);
           // return driver;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    else
    {

        try
        {
            if(browser.equalsIgnoreCase("Firefox"))
            {
            	FirefoxProfile firefoxprofile = new FirefoxProfile(); 
            	firefoxprofile.setAssumeUntrustedCertificateIssuer(true); 
            	firefoxprofile.setAcceptUntrustedCertificates(true); 
            	driver = new FirefoxDriver(firefoxprofile); 
            	//driver.get("https://google.com"); 
                //driver=new FirefoxDriver();

            }
            else if(browser.equalsIgnoreCase("chrome"))
            {
                //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
              //  driver=new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "\\Users\\bijojosephbj\\Desktop\\Automation\\Chromeexe/\\chromedriver");
			       driver=new ChromeDriver();
            }
            else
                throw new RuntimeException("Browser give "+browser+ " did not load..");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Browser give "+browser+ " did not load..");
        }
    }
    driver.get(URL);
    return driver;
    }

        public static class ScreenShotRemoteWebDriver extends RemoteWebDriver implements TakesScreenshot {
            public ScreenShotRemoteWebDriver(URL url, DesiredCapabilities dc) {
                super(url, dc);
            }


            public <X> X getScreenshotAs(OutputType<X> target)
                    throws WebDriverException {
                if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
                    return target.convertFromBase64Png(execute(DriverCommand.SCREENSHOT).getValue().toString());
                }
                return null;
            }
        }


}



