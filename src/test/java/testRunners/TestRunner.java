package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\scr\\test\\resources\\features\\Default_Fied_Farm_Basic_Form.feature",
//		features="C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\scr\\test\\resources\\features\\login.feature",
//		features="C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\scr\\test\\resources\\features\\addResource.feature",
//		features="C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\scr\\test\\resources\\features\\Default_Field_Farm_Add_Resources_And_Forward_Scales.feature",
//		features="C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\scr\\test\\resources\\features\\Default_Acer_Farm_FullFarm.feature",

		glue= {"stepDefinitions"},
		plugin= {"pretty","json:target\\reports\\cucumber.json","junit:reports\\junit\\cucumber.xml"},
		dryRun=false,
		monochrome= true,
		publish = true
		
		)


public class TestRunner {

}
