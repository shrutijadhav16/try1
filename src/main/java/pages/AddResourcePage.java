package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class AddResourcePage {
	WebDriver driver;
	Utilities util = new Utilities();

	public AddResourcePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddResourceBtn(String addbutton, String nameToAdd, String tabName) throws InterruptedException {
//		WebElement btn= driver.findElement(By.xpath("//button[contains(text(),'"+addbutton+"')]"));
		WebElement addbtn = driver.findElement(By.xpath("//button[contains(text(),'" + addbutton + "')]"));

		util.moveToElementAction(driver, addbtn);
		Thread.sleep(2000);
		addbtn.click();

	}

	public void addResources(String resourceName, String amtAvl, String btn) throws InterruptedException {

		WebElement resourceTextBox = driver
				.findElement(By.xpath("//div[@class='appname-select__value-container css-1hwfws3']"));
		WebDriverWait W = new WebDriverWait(driver, 10);
		W.until(ExpectedConditions.visibilityOf(resourceTextBox));
		util.moveToElementClickAndSenKeys(driver, resourceTextBox, resourceName);
///
		WebElement avlAmount = driver
				.findElement(By.xpath("//div[contains(text(),'" + resourceName + "')]/parent::div/parent::div/parent::"
						+ "div/parent::div/following-sibling::div/input[@type='number']"));
		util.ActionsMethod(driver, avlAmount);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(avlAmount)).clear();

		avlAmount.sendKeys(amtAvl);

		if (btn.equalsIgnoreCase("Update")) {
			WebElement updateBtn = driver.findElement(By.xpath("//div[contains(text(),'" + resourceName
					+ "')]/parent::div/parent::div/parent::div/parent::div/following-sibling::div/button[contains(text(),'"
					+ btn + "')]"));
			util.WebDriverWaitToCheckVisibility(driver, 10, updateBtn);
			util.ActionsMethod(driver, updateBtn);
			Thread.sleep(2000);
		} else if (btn.equalsIgnoreCase("Cancel")) {
			WebElement cancelBtn = driver.findElement(By.xpath("//div[contains(text(),'" + resourceName
					+ "')]/parent::div/parent::div/parent::div/parent::div/following-sibling::div/button[contains(text(),'"
					+ btn + "')]"));

			util.WebDriverWaitToCheckVisibility(driver, 10, cancelBtn);

			util.ActionsMethod(driver, cancelBtn);
			Thread.sleep(2000);
		} else if (btn.equalsIgnoreCase("Save and Add")) {
			WebElement saveAndAdd = driver.findElement(By.xpath("//div[contains(text(),'" + resourceName
					+ "')]/parent::div/parent::div/parent::div/parent::div/following-sibling::"
					+ "div/button[@class='btn btn-outline-success btn-rounded waves-effect save-and-add']"));
			util.WebDriverWaitToCheckVisibility(driver, 10, saveAndAdd);

			util.ActionsMethod(driver, saveAndAdd);
			Thread.sleep(4000);

		}

	}

	public void addResourceUsage(String resourceName, String amtUsedPerAcer, String cropToSelect, String btn)
			throws InterruptedException {
		Thread.sleep(1000);
//		WebElement resourceUsageTextBox = driver
//				.findElement(By.xpath("//input[@id='react-select-14-input']/parent::div/parent::div/parent::div"));
		WebElement resourceUsageTextBox = driver.findElement(By.xpath("//div[@class='rt-td'][1]"));
		WebDriverWait W = new WebDriverWait(driver, 10);
		W.until(ExpectedConditions.visibilityOf(resourceUsageTextBox));
		Thread.sleep(1000);
/////////
		util.moveToElementClickAndSenKeys(driver, resourceUsageTextBox, resourceName);
		WebElement cropSelect = driver.findElement(By.xpath("//div[contains(text(),'" + resourceName
				+ "')]/parent::div/parent::div/parent::div/parent::div/following-sibling"
				+ "::div//div[@class='appname-select__placeholder css-1wa3eu0-placeholder']"));
		util.WaitToClickOnElement(driver, 10, cropSelect);
		// cropSelect.clear();
		util.moveToElementClickAndSenKeys(driver, cropSelect, cropToSelect);

		WebElement amountUserPerAcer = driver
				.findElement(By.xpath("//div[contains(text(),'" + resourceName + "')]/parent"
						+ "::div/parent::div/parent::div/parent::div/following-sibling::div//input[@type='number']"));
		util.WaitToClickOnElement(driver, 10, amountUserPerAcer);
		// amountUserPerAcer.clear();
		Thread.sleep(3000);
		util.moveToElementClickAndSenKeys(driver, amountUserPerAcer, amtUsedPerAcer);
		if (btn.equalsIgnoreCase("Update")) {
//			WebElement updateBtn = driver.findElement(
//					By.xpath("//div[contains(text(),'" + resourceName + "')]/parent::div/parent::div/parent::\"\r\n"
//							+ "				+ \"div/parent::div/following-sibling::div/button[contains(text(),'" + btn
//							+ "')]"));
			WebElement updateBtn = driver.findElement(
					By.xpath("//button[@class='btn btn-outline-success btn-rounded waves-effect mr-3 btn-update']"));
			util.WebDriverWaitToCheckVisibility(driver, 10, updateBtn);
			util.ActionsMethod(driver, updateBtn);
			Thread.sleep(2000);
		} else if (btn.equalsIgnoreCase("Cancel")) {
//			WebElement cancelBtn = driver.findElement(
//					By.xpath("//div[contains(text(),'" + resourceName + "')]/parent::div/parent::div/parent::\"\r\n"
//							+ "				+ \"div/parent::div/following-sibling::div/button[contains(text(),'" + btn
//							+ "')]"));
			WebElement cancelBtn = driver.findElement(
					By.xpath("//button[@class='btn btn-outline-danger btn-rounded waves-effect mr-3 btn-cancel']"));
			util.WebDriverWaitToCheckVisibility(driver, 10, cancelBtn);

			util.ActionsMethod(driver, cancelBtn);
			Thread.sleep(2000);
		} else if (btn.equalsIgnoreCase("Save and Add")) {
//			WebElement saveAndAdd = driver.findElement(By.xpath("//div[contains(text(),'" + resourceName
//					+ "')]/parent::div/parent::div/parent::div/parent::div/following-sibling::"
//					+ "div/button[@class='btn btn-outline-success btn-rounded waves-effect save-and-add']"));
			WebElement saveAndAdd = driver.findElement(
					By.xpath("//button[@class='btn btn-outline-success btn-rounded waves-effect save-and-add']"));
			util.WebDriverWaitToCheckVisibility(driver, 10, saveAndAdd);

			util.ActionsMethod(driver, saveAndAdd);
			Thread.sleep(4000);

		}

	}

	public void clickOnEditButton(String strategyName, String button) {
		WebElement strategy = driver.findElement(By.xpath("//div[contains(text(),'" + strategyName + "')]"));
		util.WebDriverWaitToCheckVisibility(driver, 20, strategy);
		WebElement Button = driver.findElement(By.xpath("//div[contains(text(),'" + strategyName
				+ "')]/following-sibling::div//button[contains(text(),'" + button + "')]"));
		util.WebDriverWaitMethod(driver, 20, Button);

	}

	public void addForwardUsageDetails(String AddForwardSalesBtn, String forwardUsageTab, String crop, String saleType,
			String unitPrice, String quantity, String button) throws InterruptedException {
		WebElement addForwardUsageBtn = driver
				.findElement(By.xpath("//button[contains(text(),'" + AddForwardSalesBtn + "')]"));
		util.WebDriverWaitToCheckVisibility(driver, 10, addForwardUsageBtn);
		// util.ActionsMethod(driver, addForwardUsageBtn);
		util.moveToElementAction(driver, addForwardUsageBtn);
		Thread.sleep(5000);
		addForwardUsageBtn.click();
		WebElement selectCrop = driver.findElement(
				By.xpath("//div[@id='SalesOrg']//div[@class='appname-select__placeholder css-1wa3eu0-placeholder']"));
		util.moveToElementClickAndSenKeys(driver, selectCrop, crop);
		WebElement selectSale = driver.findElement(By.xpath(
				"//div[@id='authProcessed']//div[@class='appname-select__placeholder css-1wa3eu0-placeholder']"));

		util.moveToElementClickAndSenKeys(driver, selectSale, saleType);
		WebElement UnitPrice = driver.findElement(By.xpath("//div[contains(text(),'" + saleType
				+ "')]/../../../../following-sibling::div[1]/input[@type='number']"));
		util.moveToElementClickAndSenKeys(driver, UnitPrice, unitPrice);

		WebElement Quantity = driver.findElement(By.xpath("//div[contains(text(),'" + saleType
				+ "')]/../../../../following-sibling::div[2]/input[@type='number']"));
		util.moveToElementClickAndSenKeys(driver, Quantity, quantity);

		if (button.equalsIgnoreCase("Update")) {
			WebElement updateBtn = driver.findElement(
					By.xpath("//button[@class='btn btn-outline-success btn-rounded waves-effect mr-3 btn-update']"));
			Thread.sleep(1000);
			util.ActionsMethod(driver, updateBtn);
			Thread.sleep(3000);
			

		} else if (button.equalsIgnoreCase("Cancel")) {
			WebElement cancelBtn = driver.findElement(
					By.xpath("//button[@class='btn btn-outline-danger btn-rounded waves-effect mr-3 btn-cancel']"));
			Thread.sleep(1000);

			util.ActionsMethod(driver, cancelBtn);
		}
		
//		WebElement acres = driver.findElement(By.xpath("//div[contains(text(),'" + saleType
//				+ "')]/../../../../following-sibling::div[3]/input[@type='number']"));
		WebElement acres = driver.findElement(By.xpath("//span[contains(text(),'"+saleType+"')]/../following-sibling::div[3]/div"));
		System.out.println("Acres would be" + acres.getAttribute("value"));
	}
}
