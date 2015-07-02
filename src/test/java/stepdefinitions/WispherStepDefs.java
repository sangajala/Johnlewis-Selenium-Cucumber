package stepdefinitions;

public class WispherStepDefs {
//    public WebDriver driver = BrowserFactory.getBrowser();
//    public LoginPage loginPage = new LoginPage();
//    @When("^Click on new message$")
//    public void click_on_new_mes() throws Throwable {
//        driver.findElement(By.xpath("//nav[@id='menu']/ul/li[1]/div/h2")).click();
//        Thread.sleep(6000);
//        driver.findElement(By.xpath("//*[@id='menu']/ul/li[1]/ul/li/div[1]/div[1]/ul/li[3]/a")).click();
//        Thread.sleep(6000);
//
//    }
//
//    @When("^enter details$")
//    public void enter_details() throws Throwable {
//
//	/*driver.findElement(By.xpath("//input[@id='toList']")).sendKeys("918885252461");
//    driver.findElement(By.xpath("//input[@id='tagsElem']")).sendKeys("testing");
//    driver.findElement(By.xpath("//input[@id='Subject']")).sendKeys("testMessage");
//
//    //driver.switchTo().frame("iframeHtmlCommonBody");
//    driver.switchTo().frame(0);
//
//    driver.findElement(By.xpath("//body[@id='editableContent']")).sendKeys("Test Discription");
//    //driver.switchTo().window(null);
//    driver.switchTo().defaultContent();
//    driver.findElement(By.xpath("//*[@id='web_com_0200']/div[12]/button[1]")).click();;
//    Thread.sleep(6000);*/
//        DataHelper dh = new DataHelper();
//        System.out.println("Phone number " + dh.testData());
//        List<String> list = dh.testData();
//        System.out.println("Size@@" + list.size());
//	/*System.out.println("label number "+dh.data().get(1));
//	System.out.println("subject number "+dh.data().get(2));
//	System.out.println("Discription number "+dh.data().get(3));*/
//        driver.findElement(By.xpath("//input[@id='toList']")).sendKeys(list.get(0));
//        driver.findElement(By.xpath("//input[@id='tagsElem']")).sendKeys(list.get(1));
//        driver.findElement(By.xpath("//input[@id='Subject']")).sendKeys(list.get(2));
//
//        //driver.switchTo().frame("iframeHtmlCommonBody");
//        driver.switchTo().frame(0);
//
//        driver.findElement(By.xpath("//body[@id='editableContent']")).sendKeys(list.get(3));
//        //driver.findElement(By.xpath("//body[@id='editableContent']")).sendKeys("Test Discription");
//        //driver.switchTo().window(null);
//        driver.switchTo().defaultContent();
//        driver.findElement(By.xpath("//*[@id='web_com_0200']/div[12]/button[1]")).click();
//        ;
//        Thread.sleep(6000);
//    }
//
//    @Then("^validate result$")
//    public void validate_result() throws Throwable {
//
//    }
//
//
//    @Given("^I open the url$")
//    public void i_open_the_url() throws Throwable {
//        driver.get("https://au.whispir.com");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
//
//    @When("^I input my user name and password$")
//    public void i_input_my_user_name_and_password() throws Throwable {
//        driver.findElement(By.xpath("//input[@id='id-username']")).sendKeys(
//                "rrekna");
//
//        // this is for pwd
//        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(
//                "enter12345");
//
//        // this is for login button
//        driver.findElement(
//                By.xpath("//section[@id='whp-login-card']/form/button"))
//                .click();
//
//        Thread.sleep(6000);
//    }
//
//    @Then("^I should go to the home page$")
//    public void i_should_go_to_the_home_page() throws Throwable {
//        String text = driver.findElement(By.xpath("//div[@id='mainContent']/form[4]/h1")).getText();
//        assertEquals("View My Messages", text);
//        System.out.println("Welcome to Home Page  ");
//    }
//
//
//    @Given("^I am logged in user$")
//    public void i_am_logged_in_user() throws Throwable {
//
//        loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD);
//
//    }
//
//    @When("^I want to create a message with type \"(.*?)\"$")
//    public void i_want_to_create_a_message_with_type(String arg1) throws Throwable {
//    }
//
//    @When("^full the receipt field To \"(.*?)\" label \"(.*?)\" Subject \"(.*?)\"$")
//    public void full_the_receipt_field_To_label_Subject(String arg1, String arg2, String arg3) throws Throwable {
//    }
//
//    @When("^enter the body of the message as \"(.*?)\"$")
//    public void enter_the_body_of_the_message_as(String arg1) throws Throwable {
//    }
//
//    @When("^send the message$")
//    public void send_the_message() throws Throwable {
//    }
//
//    @Then("^the Subject should be \"(.*?)\"$")
//    public void the_Subject_should_be(String arg1) throws Throwable {
//
//    }
//
//    @After
//    /**
//     * Embed a screenshot in test report if test is marked as failed
//     */
//    public void embedScreenshot(Scenario scenario) {
//
//        if (scenario.isFailed()) {
//            try {
//                scenario.write("Current Page URL is " + driver.getCurrentUrl());
////            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
//                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/png");
//            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
//                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//            }
//
//        }
//
//    }
}