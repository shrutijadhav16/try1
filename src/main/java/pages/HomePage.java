package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import utils.Utilities;

public class HomePage {

	WebDriver driver;
	Utilities util = new Utilities();
	private By CreateStrategy = By.xpath("//div[contains(text(),'Create Strategy')]");
	private By StrategyName = By.xpath("//input[@id='inputFarmName']");
	private By AvailableAcres = By.xpath("//input[@id='inputSize']");
	private By IncomeGoalBtn = By.xpath("//div[contains(text(),'Income Goal (Optional)')]");
	private By FixedCosts = By.xpath("//input[@id='inputFixedCosts']");
	private By LivingExpense = By.xpath("//input[@id='inputLivingExpenses']");

	private By AdditionalIncome = By.xpath("//input[@id='inputAdditionalIncome']");

	private By IncomeGoal = By.xpath("//input[@id='inputIncomeGoal']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFarm(String strategy) {
		System.out.println(strategy);
		WebElement strategyBtn = driver.findElement(By.xpath("//button[contains(text(),'" + strategy + "')]"));
		Actions act = new Actions(driver);
		act.moveToElement(strategyBtn).build().perform();
		// util.WaittoCheckIfElementSelected(driver, 10, strategyBtn);
		util.WebDriverWaitMethod(driver, 10, strategyBtn);
		// strategyBtn.click();
//to click on Full farm edit button strategy
//		driver.findElement(By.xpath(
//				"//div[contains(text(),'" + strategy + "')]/following-sibling::div[@class='rt-td PercentWidth50']"
//						+ "/button[@class='btn btn-outline-info btn-rounded waves-effect mr-3 btn-edit']"))
//				.click();

//	driver.findElement(By.xpath("//div[contains(text(),'"+strategy+"')]/following-sibling::div[@class='rt-td PercentWidth50']/button[1]")).click();

	}

	public void verifyPlanningModelTabloaded(String pageTab, String texToVerify) {
		System.out.println("Landed on page tab " + pageTab);
		WebElement pageText = driver.findElement(By.xpath("//div[contains(text(),'" + texToVerify + "')]"));
		util.WebDriverWaitToCheckVisibility(driver, 10, pageText);
		boolean b = pageText.isDisplayed();
		//Assert.assertTrue(b);

	}

	public void selectFarmname(String FarmName) {
		// Thread.sleep(2000);

		WebElement farmName = driver.findElement(By.xpath(
				"//div[@class='col-md-3 padding-zero']//div[@class='appname-select__single-value css-1uccc91-singleValue']"));
		util.WebDriverWaitToCheckVisibility(driver, 6, farmName);
		util.ActionsMethod(driver, farmName);
		if (FarmName.equalsIgnoreCase("Default Acres Farm")) {

			// driver.findElement(By.xpath("//div[@id='react-select-2-option-0']")).click();
			WebElement defaultAcresForm = driver.findElement(By.xpath("//div[@id='react-select-2-option-0']"));
			util.WebDriverWaitToCheckVisibility(driver, 6, defaultAcresForm);
			defaultAcresForm.click();

		} else if (FarmName.equalsIgnoreCase("Default Field Farm")) {
			// driver.findElement(By.xpath("//div[@id='react-select-2-option-1']")).click();
			WebElement fieldAcresForm = driver.findElement(By.xpath("//div[@id='react-select-2-option-1']"));
			util.WebDriverWaitToCheckVisibility(driver, 6, fieldAcresForm);
			fieldAcresForm.click();

		} else if (FarmName.equalsIgnoreCase("Comparison")) {
			// driver.findElement(By.xpath("//div[@id='react-select-2-option-2']")).click();
			WebElement comparisonForm = driver.findElement(By.xpath("//div[@id='react-select-2-option-2']"));
			util.WebDriverWaitToCheckVisibility(driver, 6, comparisonForm);
			comparisonForm.click();
		}

	}

	public void addStrategyName(String Strategyname) {
		driver.findElement(StrategyName).clear();
		driver.findElement(StrategyName).sendKeys(Strategyname);

	}

	public void selectPlanningModel(String planningModelValue, String availableAcres) throws InterruptedException {
		WebElement PlanningModel = driver.findElement(
				By.xpath("//div[@class='col-md-3']//div[@class='appname-select__control css-yk16xz-control']"));
		Thread.sleep(1000);

		Actions a = new Actions(driver);

		// (planningModelValue.equalsIgnoreCase("Acres") 
			a.moveToElement(PlanningModel).click().sendKeys(planningModelValue).sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			driver.findElement(AvailableAcres).clear();
			driver.findElement(AvailableAcres).sendKeys(availableAcres);
		

//		} else if (planningModelValue.equalsIgnoreCase("Field")) {
//			a.moveToElement(PlanningModel).click().sendKeys(planningModelValue).sendKeys(Keys.ENTER).build().perform();
//
//		}

	}
	public void selectPlanningModelAsField(String planningModelValue) throws InterruptedException {
		WebElement PlanningModel = driver.findElement(
				By.xpath("//div[@class='col-md-3']//div[@class='appname-select__control css-yk16xz-control']"));
		Thread.sleep(1000);

		Actions a = new Actions(driver);
		a.moveToElement(PlanningModel).click().sendKeys(planningModelValue).sendKeys(Keys.ENTER).build().perform();

	}

	public void clickOnIncomeGoalButton(String incomeGoalBtn) {
		WebElement incomeGoaldBtn = driver.findElement(IncomeGoalBtn);
		incomeGoaldBtn.click();
//		Thread.sleep(1000);

	}

	public void enterOptionalFieldValues(String fixedCost, String livingExpense, String additionalIncome) {
		driver.findElement(FixedCosts).clear();

		driver.findElement(FixedCosts).sendKeys(fixedCost);
		driver.findElement(LivingExpense).clear();

		driver.findElement(LivingExpense).sendKeys(livingExpense);
		driver.findElement(AdditionalIncome).clear();

		driver.findElement(AdditionalIncome).sendKeys(additionalIncome);
		String incomeGoalValue = driver.findElement(IncomeGoal).getAttribute("value");
		int IntIncomeGoalValue = Integer.parseInt(incomeGoalValue);
		System.out.println("IncomeGoal value is " + incomeGoalValue);
		int IntFixedValue = Integer.parseInt(fixedCost);
		int IntlivingExpense = Integer.parseInt(livingExpense);

		int IntadditionalIncome = Integer.parseInt(additionalIncome);

		int totalAddition = IntFixedValue + IntlivingExpense + IntadditionalIncome;
		if (totalAddition == IntIncomeGoalValue) {
			System.out.println(
					"Addition of all the values i.e fixedCost and livingExpense and additionalIncome is equal to IncomeGoal");

		}

	}

	public void clickOnSaveAndNextBtn(String button) throws InterruptedException {
		if (button.equalsIgnoreCase("Save & Next")) {
			WebElement saveBtn = driver.findElement(By.xpath("//button[contains(text(),'" + button + "')]"));
//			util.moveToElementAction(driver, saveBtn);
//			util.WebDriverWaitToCheckVisibility(driver, 10, saveBtn);
//			Thread.sleep(2000);

			util.WebDriverWaitToCheckVisibility(driver, 10, saveBtn);

			util.scrollPage(driver, 300);
			Thread.sleep(3000);

			util.moveToElementAction(driver, saveBtn);
			

			Thread.sleep(2000);
			saveBtn.click();

		} else if (button.equalsIgnoreCase("Back to Dashboard")) {
			// button[contains(text(),' Back to Dashboard')]
			WebElement backBtn = driver.findElement(By.xpath("//button[contains(text(),'" + button + "')]"));
			util.WebDriverWaitToCheckVisibility(driver, 6, backBtn);

			util.ActionsMethod(driver, backBtn);

		} else if (button.equalsIgnoreCase("Submit & Review")) {
			WebElement submitAndReviewBtn = driver.findElement(By.xpath("//button[contains(text(),'"+ button +"')]"));
			util.WebDriverWaitToCheckVisibility(driver, 6, submitAndReviewBtn);
			util.scrollPage(driver, 400);
			Thread.sleep(3000);

			util.ActionsMethod(driver, submitAndReviewBtn);
//			Thread.sleep(5000);
//
//			//WebElement popUp= driver.findElement(By.xpath("//div[@class='modal-dialog popup-wid']/div"));
//			driver.findElement(By.xpath("//button[contains(text(),'Analyze')]")).click();

		}
	}

	public void clickOnFieldCropsBtn(String cropBtn) {
		if (cropBtn.equalsIgnoreCase("Field Crops")) {
//			Thread.sleep(1000);
			WebElement fieldCrop = driver.findElement(By.xpath("//button[contains(text(),'" + cropBtn + "')]"));
			util.WebDriverWaitToCheckVisibility(driver, 10, fieldCrop);
			util.WebDriverWaitMethod(driver, 10, fieldCrop);
		} else if (cropBtn.equalsIgnoreCase("Fruits and Vegetables")) {
			WebElement VegCrop = driver.findElement(By.xpath("//button[contains(text(),'" + cropBtn + "')]"));
			util.WebDriverWaitToCheckVisibility(driver, 10, VegCrop);

			util.WebDriverWaitMethod(driver, 10, VegCrop);
			util.scrollPage(driver, 200);

		}

	}

	public void selectRequiredCrops(String cropBtn, String crop) {
		if (cropBtn.equalsIgnoreCase("Field Crops")) {
			switch (crop) {
			case "Alfalfa":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Barley":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Canola":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Corn (feed)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Corn (grain)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Corn (silage)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Corn (sweet)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Cotton (upland)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Hemp":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Lentils":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Cotton (Pima)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Oats":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Peanuts":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;
			case "Potatoes":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;
			case "Rice":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;
			case "Rye":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;
			case "Sorghum":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;
			case "Soybeans":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;
			case "Sunflowers":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			default:
				System.out.println("Please select proper crop from the given list");
				System.out.println(crop);
				break;

			}
		} else if (cropBtn.equalsIgnoreCase("Fruits and Vegetables")) {

			switch (crop) {
			case "Beans":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Broccoli":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Cabbage":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Cantaloupes":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Carrots":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Cauliflower":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Celery":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Cucumbers":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Garlic":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Lettuce (iceberg)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Lettuce (leaf)":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Onions":
				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Peppers":

				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			case "Potatoes":

				if (driver.findElement(By.xpath("//div[@class='collapse show']//input[@value='" + crop + "']"))
						.isSelected()) {
					break;
				} else
					driver.findElement(By.xpath("//div[@class='collapse show']//input[@value='" + crop + "']")).click();

				break;

			case "Spinach":

				if (driver.findElement(By.xpath("//input[@value='" + crop + "']")).isSelected()) {
					break;

				} else {
					driver.findElement(By.xpath("//input[@value='" + crop + "']")).click();
				}
				break;

			default:
				System.out.println("Please select proper fruits and vegetables from the given list");
				break;

			}

		}

	}

//adding the crop exp yield, price and pro cost and calculating the estimated cost
	public void addCropDetails(String cropChoicesBtn, String crops, String UOM, String expYield, String expPrice,
			String prodCost) {
		Actions act = new Actions(driver);
		if (cropChoicesBtn.equalsIgnoreCase("Field Crops")
				|| cropChoicesBtn.equalsIgnoreCase("Fruits and Vegetables")) {
			// Thread.sleep(1000);
			// driver.findElement(By.xpath("//div[@class='panel-wrap
			// active-panel']//div[contains(text(),'"+crops+"')]"));
			// click on to select UOM depending upon what crop selected
			System.out.println(crops);
			WebElement UOMField = driver
					.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops
							+ "')]/following-sibling::div"
							+ "//div[@class='appname-select__value-container appname-select__value-container--has-value css-1hwfws3']"));
			// Thread.sleep(1000);
			if (UOM.equalsIgnoreCase("Bushel(s)")) {
				// WebElement
				// uom=driver.findElement(By.xpath("//div[@id='react-select-13-option-0']"));
				act.moveToElement(UOMField).click().sendKeys(UOM).sendKeys(Keys.ENTER).build().perform();
				// driver.findElement(By.xpath("//div[@id='react-select-13-option-0']")).click();
			} else if (UOM.equalsIgnoreCase("Crate(s)")) {
				act.moveToElement(UOMField).click().sendKeys(UOM).sendKeys(Keys.ENTER).build().perform();

				// driver.findElement(By.xpath("//div[@id='react-select-13-option-1']")).click();
			} else if (UOM.equalsIgnoreCase("Pound(s)")) {
				act.moveToElement(UOMField).click().sendKeys(UOM).sendKeys(Keys.ENTER).build().perform();

				// driver.findElement(By.xpath("//div[@id='react-select-13-option-2']")).click();

			}

			// enter expectedyield values
			WebElement ExpYield = driver
					.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops
							+ "')]" + "/following-sibling::div[2]//input[@type='number']"));
			util.WebDriverWaitMethod(driver, 5, ExpYield);
			ExpYield.sendKeys(expYield);

			// enter expectedprice values
			driver.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops + "')]"
					+ "/following-sibling::div[3]//input[@type='number']")).click();
			driver.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops + "')]"
					+ "/following-sibling::div[3]//input[@type='number']")).sendKeys(expPrice);

			// enter proCost values
			driver.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops + "')]"
					+ "/following-sibling::div[4]//input[@type='number']")).click();
			driver.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops + "')]"
					+ "/following-sibling::div[4]//input[@type='number']")).sendKeys(prodCost);
			// calculate Estimated Cost
			String estimatedCost = driver
					.findElement(By.xpath("//div[@class='panel-wrap active-panel']//div[contains(text(),'" + crops
							+ "')]/following-sibling::div[5]"))
					.getText();
			System.out.println("Estimated Cost is " + estimatedCost);
			int IntegerEstimatedCost = Integer.parseInt(estimatedCost);

			int IntegerexpYieldt = Integer.parseInt(expYield);

			int IntegerexpPrice = Integer.parseInt(expPrice);

			int IntegerprodCost = Integer.parseInt(prodCost);

			int totalField = (IntegerexpYieldt * IntegerexpPrice) - (IntegerprodCost);
			//Assert.assertEquals(totalField, IntegerEstimatedCost);
			if (IntegerEstimatedCost == totalField) {
				System.out.println("expyied * expprice-prodCost = EstimatedCost where total is " + totalField
						+ "and estimated cost is" + IntegerEstimatedCost);
			} else {
				System.out.println("values of estimated cost doesnot match with the totalField values");
			}

		}

	}

	// editing the amount of Resource available amount in the Manage Resource Tab
	public void editResourceDetails(String resourceName, String availableAmount, String button)
			throws InterruptedException {
		WebElement ResourceName = driver.findElement(By.xpath("//span[contains(text(),'" + resourceName + "')]"));
		WebElement editButton = driver.findElement(By.xpath("//span[contains(text(),'" + resourceName
				+ "')]/parent::div/following-sibling::div[@class='rt-td hideActionBtn']"
				+ "/button[@class='btn btn-outline-info btn-rounded waves-effect btn-edit']"));

		util.ActionsMethod(driver, editButton);

		WebElement avlAmount = driver.findElement(By.xpath("//span[contains(text(),'" + resourceName + "')]"
				+ "/parent::div/following-sibling::div//input[@type='number']"));
		util.ActionsMethod(driver, avlAmount);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(avlAmount)).clear();

		avlAmount.sendKeys(availableAmount);

		if (button.equalsIgnoreCase("Update")) {
			WebElement updateBtn = driver.findElement(
					By.xpath("//span[contains(text(),'" + resourceName + "')]/parent::div/following-sibling::div"
							+ "//button[@type='button' and text()='" + button + "']"));
			util.WebDriverWaitToCheckVisibility(driver, 10, updateBtn);
			util.ActionsMethod(driver, updateBtn);
			Thread.sleep(2000);
		} else if (button.equalsIgnoreCase("Cancel")) {
			WebElement cancelBtn = driver.findElement(
					By.xpath("//span[contains(text(),'" + resourceName + "')]/parent::div/following-sibling::div"
							+ "//button[@type='button' and text()='" + button + "']"));
			util.WebDriverWaitToCheckVisibility(driver, 10, cancelBtn);

			util.ActionsMethod(driver, cancelBtn);
			Thread.sleep(2000);
		}

	}

	// adding cropLimitDetails
	public void cropLimitDetails(String cropName, String minAcres, String maxAcres, String button)
			throws InterruptedException {
		// for the below crop, we add minacres and max acres amount
		WebElement crop = driver.findElement(By.xpath("//div[contains(text(),'" + cropName + "')]"));
		WebElement editBtn = driver.findElement(
				By.xpath("//div[contains(text(),'" + cropName + "')]/following-sibling::div//button[@type='button']"));
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeSelected(editBtn));
		util.ActionsMethod(driver, editBtn);
		WebElement MinAcres = driver.findElement(By
				.xpath("//div[contains(text(),'" + cropName + "')]/following-sibling::div[1]//input[@type='number']"));
		util.WebDriverWaitToCheckVisibility(driver, 10, MinAcres);
		MinAcres.click();
		//Thread.sleep(1000);

		MinAcres.clear();
		MinAcres.sendKeys(minAcres);
		WebElement MaxAcres = driver.findElement(By
				.xpath("//div[contains(text(),'" + cropName + "')]/following-sibling::div[3]//input[@type='number']"));
		util.WebDriverWaitToCheckVisibility(driver, 10, MaxAcres);
//		MaxAcres.click();
//		MaxAcres.clear();
//		//Thread.sleep(1000);
//
//		MaxAcres.sendKeys(maxAcres);
		if (button.equalsIgnoreCase("Update")) {

			WebElement editButton = driver.findElement(By.xpath("//div[contains(text(),'" + cropName
					+ "')]/following-sibling::div//button[contains(text(),'" + button + "')]"));
//			util.WebDriverWaitMethod(driver, 10, editButton);
			editButton.click();
		} else if (button.equalsIgnoreCase("Cancel")) {
			driver.findElement(By.xpath("//div[contains(text(),'" + cropName
					+ "')]/following-sibling::div//button[contains(text(),'" + button + "')]")).click();
		}

		Thread.sleep(3000);

	}

	public void thepopupWindow(String button) throws InterruptedException {
		Thread.sleep(3000);

		WebElement popUp = driver.findElement(By.xpath("//div[@class='modal-dialog popup-wid']/div"));
		util.WebDriverWaitToCheckVisibility(driver, 20, popUp);
		// util.WebDriverWaitToCheckVisibility(driver, 10, popUp);
		if (button.equalsIgnoreCase("Close")) {
			WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'" + button + "')]"));
			util.WebDriverWaitToCheckVisibility(driver, 20, popUp);
			btn.click();
		} else if (button.equalsIgnoreCase("Analyze")) {
			WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'" + button + "')]"));
			util.WebDriverWaitToCheckVisibility(driver, 20, popUp);
			btn.click();
			Thread.sleep(10000);

		}
	}
//  to click  clone button or result button
	public void viewResult(String strategyName, String button) throws InterruptedException {
		Thread.sleep(6000);

		WebElement strategy = driver.findElement(By.xpath("//div[contains(text(),'" + strategyName +"')]"));
		util.WebDriverWaitToCheckVisibility(driver, 20, strategy);
		WebElement Button = driver.findElement(By.xpath("//div[contains(text(),'"+ strategyName+"')]/following-sibling::div//button[contains(text(),'" + button + "')]"));
		Thread.sleep(2000);
		util.WebDriverWaitMethod(driver, 20, Button);
		Thread.sleep(5000);
		if (button.equalsIgnoreCase("Result")) {
//			WebElement strategytype = driver.findElement(By.xpath("//td[contains(text(),'Default Acres Farm')]"));
//			util.WebDriverWaitToCheckVisibility(driver, 10, strategytype);
//			// util.scrollPage(driver, -200);
//			Thread.sleep(2000);
//			util.scrollToTopViewOfPage(driver);
//			Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);


		}

	}

}
