package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;

public class HomePage extends base{

	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver(); 
	    log.info("driver is intialized");
	    
	    driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName, String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		landingPage lp= new landingPage(driver);
		
		lp.getLogin().click();
		
		loginPage lp1 = new loginPage(driver);
		
		lp1.getEmail().sendKeys(UserName);
		System.out.println(UserName);
		lp1.getPassword().sendKeys(Password);
		System.out.println(Password);
		lp1.getSubmmit().click();
		log.info("Sucessfully validate user name and password");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "devender.geit@gmail.com";
		data[0][1] = "devender08";
		data[1][0] = "sudipamoitra27@gmail.com";
		data[1][1] = "sudipa123";
		
		return data;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
	
	
	
}
