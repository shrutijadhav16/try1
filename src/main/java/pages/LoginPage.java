package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	private By unsecurePagLoginLink = By.xpath("//a[contains(text(),'Login')]");
	private By emailAdd = By.xpath("//input[@id='inputEmailAddress']");
	private By password = By.xpath("//input[@id='inputPassword']");
	private By loginButton = By.xpath("//button[contains(text(),'Login')]");
	private By projectDashBoard = By.xpath("//div[contains(text(),'Planning Dashboard')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLoginLink() {
		driver.findElement(unsecurePagLoginLink).click();
	}

	public void enterCredentials(String username, String pwsd) {
		driver.findElement(emailAdd).sendKeys(username);
		driver.findElement(password).sendKeys(pwsd);

	}

	public void clikOnLoginButton() throws InterruptedException {
		driver.findElement(loginButton).click();
		Thread.sleep(5000);
	}

	public boolean verifyDashBoardText() {
		return driver.findElement(projectDashBoard).isDisplayed();
	}

}
