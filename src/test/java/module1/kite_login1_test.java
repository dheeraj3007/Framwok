package module1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import LibraryFiles.Baseclass;
import LibraryFiles.utiltyclass;
import login_model.kite_login1_class;

public class kite_login1_test extends Baseclass
{
	int TCID;
	kite_login1_class login1;
	ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("extentreport.html");

	@BeforeMethod
	public void openbrowser() throws IOException
	{
		Initializebrowser();
		login1=new kite_login1_class(driver);
		
	}
	
	@Test
	public void TC1() throws EncryptedDocumentException, IOException
	{
		TCID =104;
		login1.inpkitelogin1username(utiltyclass.getTDKite(1, 0));
		login1.inpkitelogin1password(utiltyclass.getTDKite(1, 1));
		login1.clickkitelogin1loginbtn();
		
	}
	@Test
	public void TC2() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID =103;
		login1.inpkitelogin1username(utiltyclass.getTDKite(1, 1));
		login1.inpkitelogin1password(utiltyclass.getTDKite(1, 1));
		login1.clickkitelogin1loginbtn();
		Thread.sleep(2000);
		String actErrormsg=login1.verifyErrormsg();
		String expErrormsg=" Invalid username or password.";
		Assert.assertEquals(actErrormsg, expErrormsg,"failed=error msg is not same");
		
		
	}
	@AfterMethod
	public void closeurl(ITestResult s1) throws InterruptedException, IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			utiltyclass.getscreenshot(driver, TCID);
		}
		
		Thread.sleep(2000);
		driver.close();
		
		
	}
}
