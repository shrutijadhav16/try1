package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utilities;

public class DefaultFieldFarm_BasicStrategyPage {
	WebDriver driver;
	Utilities util = new Utilities();
	public DefaultFieldFarm_BasicStrategyPage(WebDriver driver) {
		this.driver= driver;
		
	}
	public void  addFieldsAndFieldInfo(String fieldName, String sizeInAcres, String lastCrop,String checkBox, String button ) throws InterruptedException {
		
WebElement FieldName=	driver.findElement(By.xpath("//input[@style='background-color: rgb(250, 250, 250); width: 100%;']"));
util.moveToElementClickAndSenKeys(driver, FieldName, fieldName);
WebElement SizeInAcres= driver.findElement(By.xpath("//input[@type='number' and @min='0']"));
util.moveToElementClickAndSenKeys(driver, SizeInAcres, sizeInAcres);
WebElement LastCrop= driver.findElement(By.xpath("//div[@class='appname-select__placeholder css-1wa3eu0-placeholder']"));
util.moveToElementClickAndSenKeys(driver, LastCrop, lastCrop);
if(checkBox.equalsIgnoreCase("Check")) {
	WebElement CheckBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
	CheckBox.click();
}
if (button.equalsIgnoreCase("Update")) {

	WebElement updateBtn = driver.findElement(
			By.xpath("//button[@class='btn btn-outline-success btn-rounded waves-effect mr-3 btn-update']"));
	util.WebDriverWaitToCheckVisibility(driver, 10, updateBtn);
	util.ActionsMethod(driver, updateBtn);
	Thread.sleep(2000);
} else if (button.equalsIgnoreCase("Cancel")) {

	WebElement cancelBtn = driver.findElement(
			By.xpath("//button[@class='btn btn-outline-danger btn-rounded waves-effect mr-3 btn-cancel']"));
	util.WebDriverWaitToCheckVisibility(driver, 10, cancelBtn);

	util.ActionsMethod(driver, cancelBtn);
	Thread.sleep(2000);
} else if (button.equalsIgnoreCase("Save and Add")) {

	WebElement saveAndAdd = driver.findElement(
			By.xpath("//button[@class='btn btn-outline-success btn-rounded waves-effect save-and-add']"));
	util.WebDriverWaitToCheckVisibility(driver, 10, saveAndAdd);

	util.ActionsMethod(driver, saveAndAdd);
	Thread.sleep(3000);

}


	}
	public void checkTheCropCheckBox(String radioBtn, String fieldName, String cropNumber) {
		if(radioBtn.equalsIgnoreCase("OFF")) {
		int cropNum=	Integer.parseInt(cropNumber);
		WebElement field= driver.findElement(By.xpath("//div[contains(text(),'"+fieldName+"')]"));
		util.WebDriverWaitToCheckVisibility(driver, 10, field);
		WebElement cropCheck =driver.findElement(By.xpath("//div[contains(text(),'"+fieldName+"')]/following-sibling::div["+(cropNum+2)+"]//input[@type='checkbox']"));
		cropCheck.click();
		}
	}

	

	public void clickOndefaultFeildFarmLink(String fieldFarm) throws InterruptedException {
		Thread.sleep(1000);
driver.navigate().refresh();
		WebElement FieldFarmLink= driver.findElement(By.xpath("//h6[contains(text(),'Default Field Farm')]"));
		util.WebDriverWaitMethod(driver, 10, FieldFarmLink);
		Thread.sleep(2000);
	}



}
