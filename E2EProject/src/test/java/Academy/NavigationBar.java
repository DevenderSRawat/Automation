package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;

public class NavigationBar extends base {
	
	public static  Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver(); 
		driver.get(prop.getProperty("url"));	
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{		
		landingPage lp= new landingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		
		 log.info("Navigation is didplsyed");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
	

}
