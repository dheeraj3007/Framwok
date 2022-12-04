package module1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import LibraryFiles.Baseclass;
import LibraryFiles.utiltyclass;

public class kitelogintest extends Baseclass
// base class should be extended bcoz its required in every test
{
	int TCID;
	kitelogin1page login1;
	kitelogin2page login2;
	kitehomepage home;
	kitelogoutpage logout;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("extentreport.html");
	
	@BeforeClass
	public void openbrowser() throws IOException
	{	
	   Initializebrowser();// can cl non static method in non static method
	   login1= new kitelogin1page(driver);
	   login2= new kitelogin2page(driver);
	   home=new kitehomepage(driver);
	   logout=new kitelogoutpage(driver);
	   
	  
	   
	}
	
	@BeforeMethod
	public void logininapp() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		login1.inpkitelogin1username(utiltyclass.getPFdata("UN"));
		login1.inpkitelogin1password(utiltyclass.getPFdata("PWD"));
		login1.clickkitelogin1loginbtn();
		
		login2.inpkitelogin2pin(utiltyclass.getPFdata("PIN"));
		login2.clickkitelogin2cntbtn();
	}
	
	@Test
	public void verifylogin() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		TCID=101;
        String expuserID =utiltyclass.getTDKite(1, 3);
        String actuserID=home.verifykitehomeUID();
        Assert.assertEquals(actuserID,expuserID,"Failed:used id is not same");
		Thread.sleep(2000);
	}
	@Test
	public void verifylogin1() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		TCID=102;
        String expuserID =utiltyclass.getTDKite(1, 2);
        String actuserID=home.verifykitehomeUID();
        Assert.assertEquals(actuserID,expuserID,"Failed:used id is not same");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logoutapp(ITestResult s1) throws InterruptedException, IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			utiltyclass.getscreenshot(driver, TCID);
		}
		
		
		
		Thread.sleep(2000);
		logout.clickkitelogoutuserid();
		Thread.sleep(2000);
		logout.clickkitelogoutbtn();	
		
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		driver.close();
	}
	

	
}
