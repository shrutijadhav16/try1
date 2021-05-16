package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	@After
	public void takeScreenShot(Scenario sc) throws IOException {
		driver= BaseClass.getDriver();
		String failedScenario=	sc.getName().replaceAll(" ", "_");

		if(sc.isFailed()) {
			TakesScreenshot ts =((TakesScreenshot)driver);
		byte[] b=	ts.getScreenshotAs(OutputType.BYTES);
		sc.attach(b,"image/png", failedScenario);
		File ss=	ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\failedScenarioScreenShots\\Failed\\"+failedScenario+".png"));
	

		}
		
	}

	@After
	public void afterScenarioSS(Scenario sc) throws IOException, InterruptedException {
		//Thread.sleep(2000);
		driver= BaseClass.getDriver();
		
		TakesScreenshot ts =((TakesScreenshot)driver);
		byte[] b=	ts.getScreenshotAs(OutputType.BYTES);
		String lastStep=	sc.getName().replaceAll(" ", "_");

		sc.attach(b,"image/png", lastStep);
		File ss=	ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:\\Users\\shrut\\eclipse-workspace\\Planting Profits\\PassedScenarioScreenShots\\Passed\\"+lastStep+".png"));
		
	}
}
