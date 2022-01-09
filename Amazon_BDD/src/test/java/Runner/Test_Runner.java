package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(features={"src\\test\\resources\\AddToCart\\addtocart.feature","src\\test\\resources\\Payment\\Payment.feature"},
	glue= {"StepDefination"},
	dryRun = false,
	monochrome = true, //it will give me a report format properly in console
	//tags="@Cart1",

	plugin={"html:testoutput/puja.html","junit:testoutput/puja.xml","json:testoutput/puja.json"}

	)
	public class Test_Runner {
		
	}



