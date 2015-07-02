package helpers;

import org.openqa.selenium.WebDriver;

public class DataFromExcel {
	 WebDriver driver;
//	 @Before
//	 public void setup(){
//	//  driver= new FirefoxDriver();
//	  //System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Scripts\\lib\\chromedriver.exe");
//	     driver=new ChromeDriver();
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//
//
//	 }
//	 @After
//	 public void teardown(){
//	  driver.quit();
//	 }
//	 @Test
//	 public void test_Google() throws Exception{
//	  String FilePath="C:\\Users\\rajesh\\Desktop\\TestData.xls";
//	        FileInputStream fs= new FileInputStream(FilePath);
//	        Workbook wb= Workbook.getWorkbook(fs);
//
//	        Sheet sh= wb.getSheet("Sheet1");
//	        int totalrows= sh.getRows();
//
//	        String mydata= sh.getCell(0,0).getContents();
//	        //System.out.println(mydata);
//
//	        List<String> list = new ArrayList();
//	        for(int i=0; i<=totalrows; i++)
//	        {
//	        	list.add(sh.getCell(0,i).getContents());
//	        	System.out.println(sh.getCell(0,i).getContents());
//	        }
//	        System.out.println("Total list elements : "+list);
//
//	  driver.get("https://www.google.co.in/?gws_rd=ssl");
//	  driver.findElement(By.id("lst-ib")).sendKeys(mydata);
//	  driver.findElement(By.name("btnG")).click();
//	  Thread.sleep(3000);
//	 }


	}

