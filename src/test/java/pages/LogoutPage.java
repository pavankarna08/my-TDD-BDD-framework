package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LogoutPage 
{
	//Locators as properties
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	
	@FindBy(how=How.XPATH,using="//a[starts-with(@aria-label,'Google Account')]/img")
	private WebElement profilepic;
	
	@FindBy(how=How.XPATH,using="//a[text()='Sign out']")
	private WebElement signout;
	
	@FindBy(how=How.XPATH,using="//*[text()='Choose an account']")
	private WebElement relogin;
	
	//constructor method for connecting runner class
	public LogoutPage (RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait)
	{
		AjaxElementLocatorFactory af = new AjaxElementLocatorFactory(driver,50);
		PageFactory.initElements(af,this);
		this.driver=driver;
		this.wait=wait;
	}
	
	//Operational methods to operate element
	public void clickProfilePic()
	{
		wait.until(ExpectedConditions.elementToBeClickable(profilepic)).click();
	}
	
	public void clickSignOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signout)).click();
		wait.until(ExpectedConditions.visibilityOf(relogin));
	}

}
