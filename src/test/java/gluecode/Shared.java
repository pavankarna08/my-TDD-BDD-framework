package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MailsPage;
import utilities.ExcelFileUtility;
import utilities.WebSiteUtility;

public class Shared 
{
	//Global classes related to all instance class
	//No object required for classes which have static methods
	public RemoteWebDriver driver; //SWD class
	public FluentWait<RemoteWebDriver> wait; //SWD class
	public Scenario s; //cucumber java class to create HTML/JSON/XML/TEXT report for scenarios
	public WebSiteUtility su; //utilities class
	public ExcelFileUtility eu; //utilities class
	public HomePage hp; //page class
	public LoginPage lp; //page class
	public ComposePage cp; //page class
	public MailsPage mp; //page class
	public LogoutPage lop; //page class
	
	//method to be executed before for every "Scenario:" or "Scenario Outline:" iterations
	@Before
	public void method1(Scenario s)
	{
		//define driver and wait objects with null by default
		driver = null;
		wait = null;
		//create object to utility classes
		su = new WebSiteUtility();
		eu = new ExcelFileUtility();
		//Create "Scenario" class object to work for current "Scenario:" or "Scenario Outline:"
		this.s=s;
		s.log("\""+s.getName()+"\"execution started");
	}
	
	//method ot be executed after every "Scenario:" or "Scenario Outline:" iteration execution
	@After
	public void method2(Scenario s)
	{
		s.log("\""+s.getName()+"\"execution completed and result is "+s.getStatus().name());
	}
}
