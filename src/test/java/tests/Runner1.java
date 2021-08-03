package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//smoketesting
@CucumberOptions(
		features= {"src\\test\\resources\\features"},
		glue= {"src\\test\\resources\\gluecode"},
		tags="@smoketest",
		monochrome=true,
		plugin= {"pretty","html:target/smoketestres","rerun::target/failed/failedsmoketestsscenarios.txt"}
		)

public class Runner1 extends AbstractTestNGCucumberTests
{
	//This folder will be empty by default  
}	

