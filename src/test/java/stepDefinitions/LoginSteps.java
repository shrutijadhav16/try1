package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginSteps {
	BaseClass base = new BaseClass();
	Properties prop;
	WebDriver driver;
	LoginPage login;

	@Given("User is on the {string} screen")
	public void user_is_on_the_screen(String string) throws IOException {
		prop = base.initProperties();
		base.initBrowser(prop.getProperty("browser"));
		driver = BaseClass.getDriver();
		login = new LoginPage(driver);
		login.clickOnLoginLink();

	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String email, String pswd) {
		login.enterCredentials(email, pswd);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		login.clikOnLoginButton();
	}

	@Given("User is successsfully logged in and verify's the {string}")
	public void user_is_successsfully_logged_in_and_verify_s_the(String pageText) {
		login.verifyDashBoardText();
	System.out.println("User landed on Planning Dashboard Page");

	}

}
