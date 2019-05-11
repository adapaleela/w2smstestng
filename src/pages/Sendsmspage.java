package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sendsmspage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[text()='Send SMS']")
	public WebElement sendsmsmessg;
	
	@FindBy(xpath="//*[@class='logout']")
	public WebElement logoutbtn;
	
	public Sendsmspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clicklogout()
	{
		logoutbtn.click();
	}
}
