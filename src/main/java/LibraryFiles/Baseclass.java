package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseclass 
{
	public WebDriver driver;
	public void Initializebrowser() throws IOException
	{
		//for block notification
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SANDIP\\Desktop\\eqlips\\Maven\\Browser\\chromedriver.exe");
	    driver=new ChromeDriver(option);
	    driver.get(utiltyclass.getPFdata("URL"));
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	   
	    
	}

}
