package module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kitelogin1page 
{
	@FindBy(xpath="//input[@type='text']") private WebElement UID;
	@FindBy(xpath="//input[@type='password']") private WebElement PWD;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbtn;
	
	public kitelogin1page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpkitelogin1username(String username) 
	{
		try
		{
		if(UID.isDisplayed())
		{
			UID.sendKeys(username);
		}}
		catch (NullPointerException e) 
		{
			System.out.println("UID not found");
			
		}
		
	}
	
	public void inpkitelogin1password(String password)
	{
		PWD.sendKeys(password);
	}
	public void clickkitelogin1loginbtn()
	{
		loginbtn.click();
	}
	

}
