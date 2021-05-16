package stepDefinitions;

import java.util.List;
import java.util.Map;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.DefaultFieldFarm_BasicStrategyPage;

public class DefaultFieldFarm_BasicStrategySteps {
	
	
	DefaultFieldFarm_BasicStrategyPage basic;

	@Then("User adds the new Field Information given below")
	public void user_adds_the_new_field_information_given_below(DataTable fieldInfo) throws InterruptedException {
	basic = new DefaultFieldFarm_BasicStrategyPage(BaseClass.getDriver());
	List<Map<String,String>> fieldDetails=	fieldInfo.asMaps();
	for(int i=0;i<fieldDetails.size();i++) {
		String fieldName=	fieldDetails.get(i).get("Field");
		String sizeAcres=	fieldDetails.get(i).get("Size (acres)");
		String lastCrop	=fieldDetails.get(i).get("Last Crop");
		String checkBox	=fieldDetails.get(i).get("Fallow");
		String btn	=fieldDetails.get(i).get("Button");
		basic.addFieldsAndFieldInfo(fieldName, sizeAcres, lastCrop, checkBox, btn);

	}
	
	
}
	

	@Then("User unchecks the crop below depending upon the radio button is on or off which is {string} here")
	public void user_unchecks_the_crop_below_depending_upon_the_radio_button_is_on_or_off_which_is_here(String radioBtn, DataTable cropfieldDetails) {

		List<Map<String,String>> cropfield=	cropfieldDetails.asMaps();
		for(int i=0;i<cropfield.size();i++) {
			String fieldName=	cropfield.get(i).get("Field");
			String crop=	cropfield.get(i).get("Crop");
			String cropNum	=cropfield.get(i).get("Crop Number");
		
			basic.checkTheCropCheckBox(radioBtn, fieldName, cropNum);

		}
	}


	@Then("User clicks on {string} link to view Field Farms")
	public void user_clicks_on_link_to_view_field_farms(String DefaultfieldFarmLink) throws InterruptedException {
	  basic.clickOndefaultFeildFarmLink(DefaultfieldFarmLink);
	}
	

}