package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utiltyclass 
{// utility class contain Test data ,screenshot method, handling popups,xcel data call. 
	
	//author : Dheeraj jadhav
	// this class for getting data from excel
	//Need to pass two input 1.rowindex, 2.cellindex
	
	public static String getTDKite(int rowindex, int cellindex) throws EncryptedDocumentException, IOException
	{
		  FileInputStream file=new FileInputStream("C:\\Users\\SANDIP\\Desktop\\eqlips\\Maven\\TestData\\practice.xlsx");
		  Sheet sh= WorkbookFactory.create(file).getSheet("KITE_LOGIN");
		  String value=sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		  return value;
		  
	}
	public static void getscreenshot(WebDriver driver, int TCID) throws IOException 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\SANDIP\\Desktop\\eqlips\\Maven\\Screenshot\\TestcaseID"+TCID+"jpg");
		FileHandler.copy(src, dest);
	}
	
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\SANDIP\\Desktop\\eqlips\\Maven\\property file.properties");
		Properties p=new Properties();
		p.load(file);
		String value=p.getProperty(key);
		return value;
	}
}
