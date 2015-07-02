package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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

    if(false)
    {
        try
        {

           System.setProperty("webdriver.chrome.driver", "/Users/sriramangajala/Documents/Automation/chromedriver");
            //  driver=new ChromeDriver();
        	System.out.println("grid started...");
        	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("browser", System.getProperty("browser"));
        	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	capabilities.setCapability("platform", Platform.VISTA);
        	//capabilities.setCapability("version", "33");
			/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("version", "17");
			capabilities.setCapability("platform", Platform.XP);*/
//			driver = new RemoteWebDriver(
//					new URL("http://sansbijo:6504eb7f-2bdf-4f45-b485-6580c876217b@ondemand.saucelabs.com:80/wd/hub"),capabilities);
//					capabilities);
			driver = new RemoteWebDriver(
//					new URL("http://127.0.0.1:4444/wd/hub"),
//					capabilities);
                  //  new URL("http://ctji4eDhjyhlSItJ839igchsEAihFSOH:bYQ52jdcIlnqTH0RAZ0H270wy9E4RjCT@8FY4K0546DEXW8MC.gridlastic.com:80/wd/hub"),
					new URL("http://cb_ram-core:2c259106-416c-4890-9e0a-9f09ccb96c74@ondemand.saucelabs.com:80/wd/hub"),
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


}



