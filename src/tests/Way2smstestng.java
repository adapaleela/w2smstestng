package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Sendsmspage;

public class Way2smstestng 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Homepage hp;
	public Sendsmspage sp;
	
	@Test(priority=1)
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","E:\\leelajava\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.way2sms.com");
		wait=new WebDriverWait(driver,20);
		hp=new Homepage(driver);
		wait.until(ExpectedConditions.visibilityOf(hp.mbno));
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	@Parameters({"m","p"})
	public void login(String m,String p)throws Exception
	{
		hp.fillmbno(m);
		wait.until(ExpectedConditions.visibilityOf(hp.pwd));
		hp.fillpwd(p);
		wait.until(ExpectedConditions.elementToBeClickable(hp.loginbtn));
		hp.clicklogin();
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	@Parameters({"m","mc","p","pc"})
	public void validateLogin(String m,String mc,String p,String pc)
	{
		try
		{
			if(m.length()==0 && hp.blank_mbnoerr.isDisplayed())
			{
				Reporter.log("blank mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(m.length()<10 && hp.wrong_size_mbnoerr.isDisplayed())
			{
				Reporter.log("wrong size mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(mc.equalsIgnoreCase("invalid") && hp.invalid_mbnoerr.isDisplayed())
			{
				Reporter.log("invalid mobile number test passed");
				Assert.assertTrue(true);
			}
			else if(p.length()==0 && hp.blank_pwderr.isDisplayed())
			{
				Reporter.log("blank password number test passed");
				Assert.assertTrue(true);
			}
			else if(pc.equalsIgnoreCase("invalid") && hp.invalid_pwderr.isDisplayed())
			{
				Reporter.log("invalid password test passed");
				Assert.assertTrue(true);
			}
			else if(mc.equalsIgnoreCase("valid") && pc.equalsIgnoreCase("valid") && sp.sendsmsmessg.isDisplayed())
			{
				wait.until(ExpectedConditions.elementToBeClickable(sp.logoutbtn));
				sp.clicklogout();
				Reporter.log("login test passed");
				Assert.assertTrue(true);
			}
			else
			{
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
				Date d=new Date();
				String fname=sf.format(d)+".png";	
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dest=new File(fname);
				FileHandler.copy(src,dest);
				Reporter.log("login test failed");
				String path="E:\\leelajava\\w2smstestng\\"+fname;
				String code="<img src=\"file:///"+path+"\" alt=\"\"/>";
				Reporter.log(code);
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test(priority=4)
	public void closeSite()
	{
		driver.close();
	}
	
}
