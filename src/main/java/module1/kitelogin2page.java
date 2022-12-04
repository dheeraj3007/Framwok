package module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kitelogin2page 
{
	@FindBy(xpath="//input[@id='pin']") private WebElement PIN;
	@FindBy(xpath="//button[@type='submit']") private WebElement cntbtn;
	
	public kitelogin2page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpkitelogin2pin(String pin)
	{
		PIN.sendKeys(pin);
	}
	public void clickkitelogin2cntbtn()
	{
		cntbtn.click();
	}
}
