package login_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kite_login1_class 
{
	@FindBy(xpath="//input[@type='text']") private WebElement UID;
	@FindBy(xpath="//input[@type='password']") private WebElement PWD;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbtn;
	@FindBy(xpath="//*[@id=\"container\"]/div/div/div/form/p[1]") private WebElement errormsg;
	
	public kite_login1_class(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpkitelogin1username(String username) 
	{
		
			UID.sendKeys(username);
		
	}
	
	public void inpkitelogin1password(String password)
	{
		PWD.sendKeys(password);
	}
	public void clickkitelogin1loginbtn()
	{
		loginbtn.click();
	}
	
	public String verifyErrormsg()
	{
		String acterrormsg=errormsg.getText();
		return acterrormsg;
	}
	

}



