package Utils;



import net.masterthought.cucumber.sandwich.CucumberReportMonitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Run this once before starting the tests
 * This will monitor the specified folders and generate tests automatically
 * 
 * assumptions:
 * 	input folder is the target folder

 * @author Noor
 *
 */
public class CreatePrettyReport {

	public static void main(String[] args) {
		CreatePrettyReport cpr = new CreatePrettyReport();
		cpr.monitorFolder("Pretty");
	}

	/**
	 * Monitors folder for changes and than generates pretty reports
	 */
	public void monitorFolder(String outFolderName) {
		//Where to put pretty reports
		String res = new File("").getAbsolutePath();
		String location = getLocation();
		String [] aaa = new String[4];
		aaa[0] = "-f";
		aaa[1] = res + File.separatorChar + "target" ;
		aaa[2] = "-o";
		String outFile = aaa[1] + File.separatorChar + outFolderName + File.separatorChar + "report" + File.separatorChar + location  ;//+ new Date().toString().replace(":", "").substring(0,16).replace(" ", "");
		//System.out.println(outFile);
		//Create folder
		File f = new File(outFile);
		f.mkdirs();
		aaa[3] = outFile;
		try {
			CucumberReportMonitor.main(aaa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
	}

	private String getLocation() {
        Calendar cal = Calendar.getInstance();
        String month = (new SimpleDateFormat("MMM").format(cal.getTime()));
        String day = ""+ cal.get(Calendar.DAY_OF_MONTH);
        String hour = ""+ cal.get(Calendar.HOUR_OF_DAY);
        String min = ""+ cal.get(Calendar.MINUTE);
		return month + File.separatorChar + day + File.separatorChar + hour + "_" + min ;
	}
}
