package mytestng;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoOntestng 
{
  @Test
  public void f() throws Exception 
  {
	    System.setProperty("webdriver.chrome.driver","E:\\leelajava\\chromedriver.exe");
	    ChromeDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://www.way2sms.com/");
	    WebDriverWait wait=new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
	    driver.manage().window().maximize();
	    String y=driver.getTitle();
	    if(y.contains("SkjMlS")) 
	    {
	    	Reporter.log("title test passed");
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
	    	Reporter.log("title test passed");
	    	Assert.assertTrue(false);
	    }
	    driver.close();
  }
  
}
