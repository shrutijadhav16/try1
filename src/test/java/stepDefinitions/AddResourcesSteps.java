package stepDefinitions;

import java.util.List;
import java.util.Map;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddResourcePage;

public class AddResourcesSteps {
	//to add the resources or forward sales
	AddResourcePage add;
	
	
	@Then("User clicks on {string} button to add the {string} under {string} tab")
	public void user_clicks_on_button_to_add_the_under_tab(String addBtn, String nameToAdd, String tabName) throws InterruptedException {
		add= new AddResourcePage(BaseClass.getDriver());
add.clickOnAddResourceBtn(addBtn, nameToAdd, tabName);
	}
	
	//to add resources
	@Then("User adds the new Resources given below")
	public void user_adds_the_new_resources_given_below(DataTable ResourceDetails) throws InterruptedException {
		List<Map<String,String>> resourceDetails=	ResourceDetails.asMaps();
		for(int i=0;i<resourceDetails.size();i++) {
			String resourceName=	resourceDetails.get(i).get("Resource");
			String resourceAmountAvailable=	resourceDetails.get(i).get("Amount Available");
			String editOptions	=resourceDetails.get(i).get("EditBtnOptions");
			add.addResources(resourceName, resourceAmountAvailable, editOptions);
		}
	}
	
//to add Resource Usage
@Then("User adds the new Resource Usage given below")
public void user_adds_the_new_resource_usage_given_below(DataTable resourceUsage) throws InterruptedException {
	List<Map<String,String>> resourceDetails=	resourceUsage.asMaps();
	for(int i=0;i<resourceDetails.size();i++) {
		String resourceName=	resourceDetails.get(i).get("Resource");
		String amountUsedPerAcer=	resourceDetails.get(i).get("Amount Used/Acre");
		String cropToSelect =	resourceDetails.get(i).get("Crop");

		String editOptions	=resourceDetails.get(i).get("EditBtnOptions");
		add.addResourceUsage(resourceName, amountUsedPerAcer, cropToSelect, editOptions);
	}
	}
	


//click on the edir button of thje clone form
@Then("User gets the new strategy created with the same name but date added {string} and clicks on the {string} button")
public void user_gets_the_new_strategy_created_with_the_same_name_but_date_added_and_clicks_on_the_button(String string, String string2) {
   add.clickOnEditButton(string, string2);
}


//user adds the forward usage details

@When("User clicks on {string} button of the {string} tab then User is able to fill all the below details")
public void user_clicks_on_button_of_the_tab_then_user_is_able_to_fill_all_the_below_details(String addForwardSalesBtn, String ForwardSalesTab, DataTable forwardUsageDetails) throws InterruptedException {
	List<Map<String,String>> forwardUsageFields=	forwardUsageDetails.asMaps();
	for(int i=0;i<forwardUsageFields.size();i++) {
		String crop=	forwardUsageFields.get(i).get("Crop");
		String saleType=	forwardUsageFields.get(i).get("Sale Type");
		String unitPrice =	forwardUsageFields.get(i).get("Unit Price");

		String quantity	=forwardUsageFields.get(i).get("Quantity");
		String btn	=forwardUsageFields.get(i).get("Button");

	add.addForwardUsageDetails(addForwardSalesBtn, ForwardSalesTab, crop, saleType, unitPrice, quantity, btn);
	
}



}




}