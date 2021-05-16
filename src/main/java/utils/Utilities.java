package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {
	public void ActionsMethod(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

	}

	public void WebDriverWaitMethod(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	}

	public void scrollPage(WebDriver driver, int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + value + ")");

	}

	public void clickOnElementUsingJS(WebDriver driver, String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
		//js.executeScript("document.getElementsByClassName('"+element+"').click()");

	}

	public void WebDriverWaitToCheckVisibility(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
//Assert.assertEquals(true, element.isDisplayed());		

	}

	public void moveToElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

	}

	public void WaittoCheckIfElementSelected(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeSelected(element));

	}
public void moveToElementClickAndSenKeys(WebDriver driver, WebElement element, String value) {
	Actions action= new Actions(driver);
	action.moveToElement(element).click().sendKeys(value).sendKeys(Keys.ENTER).build().perform();
}

public void WaitToClickOnElement(WebDriver driver, int time, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void scrollToTopViewOfPage(WebDriver driver) {
	
Actions a= new Actions(driver);
a.sendKeys(Keys.HOME).build().perform();
	
	
}
public void scrollToViewElement(WebDriver driver,WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("argument[0].scrollIntoView(true);",element);
}
}