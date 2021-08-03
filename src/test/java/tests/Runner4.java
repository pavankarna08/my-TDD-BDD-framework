package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//add @regressiontest tag to required scenarios or scenario outlines in featurefiles manually
//which are passed previously but related to failed scenarios
//Regression Testing

@CucumberOptions(
		features= {"src\\test\\resources\\features"},
		glue= {"gluecode"},
		tags="@regressiontest",
		monochrome=true,
		plugin= {"pretty","html:target/regressiontestres","rerun::target/failed/failedfailedregressionres.txt"}
		)


public class Runner4 extends AbstractTestNGCucumberTests
{

}
