package helpers;

//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {
	
//	public static List<HashMap<String,String>> data()
//	{


//		List<HashMap<String,String>> mydata = null;
//		try
//		{
//
//			FileInputStream fs = new FileInputStream("classpath:TestData-seleniumframework.xlsx");
//			XSSFWorkbook workbook = new XSSFWorkbook(fs);
//			XSSFSheet sheet = workbook.getSheet("SignInSignOut");
//			Row HeaderRow = sheet.getRow(0);
//
//			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
//			{
//				Row currentRow = sheet.getRow(i);
//				HashMap<String,String> currentHash = new HashMap<String,String>();
//				for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
//				{
//					Cell currentCell = currentRow.getCell(j);
//
//					switch (currentCell.getCellType())
//					{
//					case Cell.CELL_TYPE_STRING:
//						System.out.print(currentCell.getStringCellValue() + "\t");
//
//						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
//						break;
//					}
//
//				}
//				mydata.add(currentHash);
//			}
//
//			fs.close();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		return mydata;
//
//	}
//
//	public List<String> testData() throws BiffException, IOException
//	{
//		String FilePath="C:\\Users\\rajesh\\Desktop\\TestData.xls";
//        FileInputStream fs= new FileInputStream(FilePath);
//        Workbook wb= Workbook.getWorkbook(fs);
//
//        Sheet sh= wb.getSheet("Sheet1");
//        int totalrows= sh.getRows();
//        System.out.println("total rows are :"+totalrows);
//        String mydata= sh.getCell(0,0).getContents();
//
//        //System.out.println(mydata);
//
//        /*List<String> list = new ArrayList();
//        for(int i=0; i<=totalrows; i++)
//        {
//        	//mydata=mydata +","+ sh.getCell(0,i).getContents();
//        	list.add(sh.getCell(0,i).getContents());
//        }*/
//        List<String> list = new ArrayList();
//
//        for(int i=0; i<totalrows; i++)
//        {
//        	list.add(sh.getCell(0,i).getContents());
//        	System.out.println(sh.getCell(0,i).getContents());
//        }
//
//        System.out.println("Total list elements : "+list);
//
//        return list;
//	}
}
