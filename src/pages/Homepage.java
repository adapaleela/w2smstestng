package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	public WebDriver driver;
	
	@FindBy(name="mobileNo")
	public WebElement mbno;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="(//button[contains(text(),'Login')])[1]")
	public WebElement loginbtn;
	
	@FindBy(xpath="//*[text()='Enter your mobile number']")
	public WebElement blank_mbnoerr;
	
	@FindBy(xpath="//*[text()='Enter valid mobile number']")
	public WebElement wrong_size_mbnoerr;
	
	@FindBy(xpath="(//*[contains(text(),'Your mobile number is not register')])[1]")
	public WebElement invalid_mbnoerr;
	
	@FindBy(xpath="(//*[text()='Enter password'])[1]")
	public WebElement blank_pwderr;
	
	@FindBy(xpath="(//*[contains(text(),'Try Again')])[1]")
	public WebElement invalid_pwderr;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void fillmbno(String x)
	{
		mbno.sendKeys(x);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clicklogin()
	{
		loginbtn.click(); 
	}
}
