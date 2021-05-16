package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {

	HomePage home;
//user clicks on create strategy button
	@When("User clicks on the  button {string} button")
	public void user_clicks_on_the_button_button(String startegy) {
		home = new HomePage(BaseClass.getDriver());
		home.selectFarm(startegy);
	}

	@Then("User is landed on Planning Model page")
	public void user_is_landed_on_planning_model_page() {
		System.out.println("Successfully clicked on Created Strategy button");
	}
	//user verify the new tab text nd if the tabs are loaded properly
	@Then("User verify's on {string} tab that the text {string}  is displayed")
	public void user_verify_s_on_tab_that_the_text_is_displayed(String pageTab, String textToVerify) {
		home.verifyPlanningModelTabloaded(pageTab,textToVerify);

	}
//user enter the farm name in the planningmodel tab
	@Then("User selects {string} Farm Name")
	public void user_selects_farm_name(String FarmName) {
		home.selectFarmname(FarmName);

	}
//user given the strategy name under planning model tab
	@Then("User selects {string} Strategy Name")
	public void user_selects_strategy_name(String StrategyName) {
		home.addStrategyName(StrategyName);

	}
//under planning model tab user select the Acres value and decides the values of Available Acres
	@Then("User selects {string} Planning Model and enters {string} Available Acres")
	public void user_selects_planning_model_and_enters_available_acres(String planningModelValue, String availableAcres)
			throws InterruptedException {
		home.selectPlanningModel(planningModelValue, availableAcres);
		
	}
	
	//under planning model tab user select the Field value and decides the values of Available Acres

	@Then("User selects {string} Planning Model and enters no Available Acres  required")
	public void user_selects_planning_model_and_enters_no_available_acres_required(String planningModelValue) throws InterruptedException {
		home.selectPlanningModelAsField(planningModelValue);
	}



	//user clicks on income goal btn on the planning model page
	@When("User clicks on {string} button")
	public void user_clicks_on_button(String IncomeGoalButton)  {
		home.clickOnIncomeGoalButton(IncomeGoalButton);

	}
//user enter the income goal values under planning model page
	@When("User enters Fixed Costs {string} and Living Expenses {string} and Additional Income {string} and verify's the IncomeGoal value")
	public void user_enters_fixed_costs_and_living_expenses_and_additional_income_and_verify_s_the_income_goal_value(
			String fixedCost, String livingExpense, String additionalIncome) {
		home.enterOptionalFieldValues(fixedCost, livingExpense, additionalIncome);
	}
//user click on save and next btn
	@Then("User clicks at {string} button")
	public void user_clicks_at_button(String button) throws InterruptedException {
		home.clickOnSaveAndNextBtn(button);

	}
//user clicks on fieldCrop or fruits and vegetables crop btn
	@When("User clicks on {string}")
	public void user_clicks_on(String crops) {
		home.clickOnFieldCropsBtn(crops);
	}
//user selects the crops
	@When("under {string} User selects the below crops")
	public void under_user_selects_the_below_crops(String cropBtn, DataTable dataTable) throws InterruptedException {
		
		List<String> fieldCrop=	dataTable.asList();
		for(int i=0;i<fieldCrop.size();i++) {
		String crop=	fieldCrop.get(i);
       home.selectRequiredCrops(cropBtn, crop);
       Thread.sleep(1000);
		}
		Thread.sleep(1000);

		home.clickOnFieldCropsBtn(cropBtn);
		Thread.sleep(1000);

		
		
//		List<List<String>> fieldCropsList = dataTable.asLists();
//		System.out.println("Size of the list is " +fieldCropsList.size());
//		for (int i = 0; i < fieldCropsList.size()-1; i++) {
//			List<String> allValues = new ArrayList<String>();
//
//			for (int j = 0; j <5 ; i++) {
//				
//				String values = fieldCropsList.get(i).get(j);
//				allValues.add(values);
//				System.out.println(allValues.get(j));
////
//			}
//			home.selectRequiredCrops(cropBtn,allValues.get(i) );
//			Thread.sleep(1500);
//		}
//		home.clickOnFieldCropsBtn(cropBtn);
//		Thread.sleep(1000);

	}
	//user entersd the crop values i.e exp yiedl and price and prod cost and verifys estimated cost
	@Then("for {string} User can see the below table and can add details under given below")
	public void for_user_can_see_the_below_table_and_can_add_details_under_given_below(String cropChoices, DataTable dataTable)  {
	List<Map<String,String>> cropMapList=	dataTable.asMaps();
	//cropMapList.size();
	for(int i=0; i<cropMapList.size(); i++) {
		String cropName=	cropMapList.get(i).get("Crop");
		String uom= cropMapList.get(i).get("UOM");
		String expYield= cropMapList.get(i).get("Expected Yield");

		String expPrice= cropMapList.get(i).get("Expected Price");

		String prodCost= cropMapList.get(i).get("Production Cost");
		home.addCropDetails(cropChoices, cropName, uom, expYield, expPrice, prodCost);
System.out.println(cropName);
	}
		
	}
	//user tries to edit the details of manage resource tab
	@Then("User clicks on the edit button and enters the values for the below Resource")
	public void user_clicks_on_the_edit_button_and_enters_the_values_for_the_below_resource(DataTable ResourceDetails) throws InterruptedException {
	List<Map<String,String>> resourceDetails=	ResourceDetails.asMaps();
		for(int i=0;i<resourceDetails.size();i++) {
		String resourceName=	resourceDetails.get(i).get("Resource");
		String resourceAmountAvailable=	resourceDetails.get(i).get("Amount Available");
		String editOptionsOption=	resourceDetails.get(i).get("EditBtnOptions");

		home.editResourceDetails(resourceName, resourceAmountAvailable, editOptionsOption);

		}
	  
	}
	

@Then("User enters the below values for the selected crops and saves the details")
public void user_enters_the_below_values_for_the_selected_crops_and_saves_the_details(DataTable cropLimitsDetails) throws InterruptedException {
	List<Map<String,String>> cropLimitsList=	cropLimitsDetails.asMaps();
	for(int i=0;i<cropLimitsList.size();i++) {
	String  cropName=	cropLimitsList.get(i).get("Crop");
	String minAcres=	cropLimitsList.get(i).get("Min Acres");
	String maxAcres=	cropLimitsList.get(i).get("Max Acres");
	String button=	cropLimitsList.get(i).get("RequiredButton");
	
	home.cropLimitDetails(cropName, minAcres, maxAcres, button);

	}
}
//user submits the strategy and can see the popup to click on Analyze button
@Then("User gets the popup screen and User clicks on {string} Button")
public void user_gets_the_popup_screen_and_user_clicks_on_button(String button) throws InterruptedException {
  home.thepopupWindow(button);
}
//user click on result button of the planning dashboard page to view the result


@Then("User is navigaed to Planning Dashboard page where for strategy {string} user clicks on the {string} button")
public void user_is_navigaed_to_planning_dashboard_page_where_for_strategy_user_clicks_on_the_button(String strategyName, String button) throws InterruptedException {
   home.viewResult(strategyName, button);
}




}
