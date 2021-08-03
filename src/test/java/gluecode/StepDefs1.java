package gluecode;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MailsPage;

public class StepDefs1 
{
	public Shared sh;
	
	
	public StepDefs1(Shared sh)
	{
		this.sh=sh;
	}
	
	
	@Given("launch site using {string} in {string} environment")
	public void method2(String bn, String evn) throws Exception
	{
		//open browser
		sh.driver=sh.su.openBrowser(bn);
		sh.wait=sh.su.defineWait(sh.driver);
		sh.hp=new HomePage(sh.driver,sh.wait);
		sh.lp=new LoginPage(sh.driver,sh.wait);
		sh.cp=new ComposePage(sh.driver,sh.wait);
		sh.mp=new MailsPage(sh.driver,sh.wait);
		sh.lop=new LogoutPage(sh.driver,sh.wait);
		//Launch site by using url from properties file
		sh.su.launchSite(sh.driver, evn);
	}
	
	@Then("title should be {string}")
	public void method3(String expected)
	{
		String actual = sh.driver.getTitle();
		if(expected.equals(actual))
		{
			sh.s.log("Gmail title test passed");
			Assert.assertTrue(true); //TestNG
		}
		else
		{
			byte[] b = sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
			sh.s.attach(b,"image/png","Gmail tilte test failed"); //cucumber-java
			Assert.fail(); //TestNG
		}
	}
	
	@And("quit site")
	@When("close site")
	public void method4() throws Exception
	{
		sh.su.closeSite(sh.driver);
	}
	
	@When("enter userid as {string}")
	public void method5(String uid)
	{
		sh.hp.uidFill(uid);
	}
	
	@And("click userid next button")
	public void method6() throws Exception
	{
		sh.hp.uidNextClick();
		Thread.sleep(5000);
	}
	
	@Then("validate outcome related to given userid criteria like {string}")
	public void method7(String c)
	{ 
		try
		{
			if(c.equals("blank") && sh.hp.isBlankUseridError())
			{
				sh.s.log("Blank uid test was passed");
			}
			else if(c.equals("invalid") && sh.hp.isInValidUseridError())
			{
				sh.s.log("Invalid uid test was passed");
			}
			else if(c.equals("valid") && sh.hp.isPasswordDisplayed())
			{
				sh.s.log("valid uid test was passed");
			}
			else
			{
				byte[] b = sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
				sh.s.attach(b,"image/png","Gmail UID test failed"); //cucumber-java
				Assert.assertTrue(false); //TestNG
			}
		}
		catch(Exception ex)
		{
			byte[] b = sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
			sh.s.attach(b,"png",ex.getMessage()); //cucumber-java
			Assert.assertTrue(false);
		}
	}
	
	@And("enter password as {string}")
	public void method8(String p)
	{
		sh.lp.pwdfill(p);
	}
	
	@And("click password next button")
	public void method9() throws Exception
	{
		sh.lp.pwdnextclick();
		Thread.sleep(5000);
	}
	
	@Then("^validate outcome related to given password criteria like \"(.*)\"$")
	public void method10(String p)
	{
		try
		{
			if(p.equals("blank") && sh.lp.isBlankpwdError())
			{
				sh.s.log("Blank pwd test was passed");
			}
			else if(p.equals("invalid") && sh.lp.isInvalidPwdError())
			{
				sh.s.log("invalid pwd test was passed");
			}
			else if(p.equals("valid") && sh.lp.isComposeDispalyed())
			{
				sh.s.log("valid pwd test was passed");
			}
			else
			{
				byte[] b = sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
				sh.s.attach(b,"image/png","Gmail PWD test failed"); //cucumber-java
				Assert.assertTrue(false); //TestNG
			}
		}
		catch(Exception ex)
		{
			byte[] b = sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
			sh.s.attach(b,"image/png",ex.getMessage()); //cucumber-java
			Assert.assertTrue(false);
		}
	}
		
	@And("send mail and test")
	public void method11(DataTable dt) throws Exception
	{
		List<Map<String, String>> l=dt.asMaps();
		for(int i=0;i<l.size();i++)
		{
			sh.cp.clickCompose();
			sh.cp.fillTo(l.get(i).get("to"));
			sh.cp.fillSubject(l.get(i).get("subject"));
			sh.cp.fillBody(l.get(i).get("body"));
			sh.cp.attachment(l.get(i).get("attachment"));
			sh.cp.clickSend();
			//compose test
			String msg = sh.cp.getOutputMessage();
			if(!msg.contains("Sorry"))
			{
				sh.s.log("compose test passed and we got"+msg);
				Assert.assertTrue(true); //optional
			}
			else
			{
				byte[] b = sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
				sh.s.attach(b,"image/png","mail compose test failed"); //cucumber-java
				Assert.fail();
			}
		}
	}
	
	@When("do logout")
	public  void method12()
	{
		sh.lop.clickProfilePic();
		sh.lop.clickSignOut();
	}
}
