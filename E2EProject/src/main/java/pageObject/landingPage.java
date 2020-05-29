package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		this.driver = driver;	
	}
	
	private By signIn= By.xpath("//span[contains(text(),'Login')]");
	private By feature=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navigationBar=By.xpath("//nav[@class='navbar-collapse collapse']");

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getFeature()
	{
		return driver.findElement(feature);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	
}
