package module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kitelogoutpage
{
	@FindBy(xpath="//span[@class='user-id']") private WebElement user;
	@FindBy(xpath="//a[@target='_self']") private WebElement logoutbtn;
	
	public kitelogoutpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickkitelogoutuserid()
	{
		user.click();
	}
	
	public void clickkitelogoutbtn()
	{
		logoutbtn.click();
	}
}
