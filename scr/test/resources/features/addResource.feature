Feature: To add Resources in the new Basic  Strategy of Default Acer Farm
        and clone the form to add Foward Scales in the copy of the same farm
         
Background: 
Given User is on the "Login" screen
When User enters username "siva@c4bneeds.com" and password "Test@1234"
And User clicks on Login button
When User clicks on the  button "Create Strategy" button
Scenario: To add different resources and forward scales in the Basic Strategy 
Given User is landed on Planning Model page
Then User verify's on "Planning Model" tab that the text "Create Strategy"  is displayed
Then User selects "Default Acres Farm" Farm Name
And User selects "PracticeFarm5" Strategy Name
And User selects "Acres" Planning Model and enters "5000" Available Acres 
When User clicks on "Income Goal (Optional)" button
And User enters Fixed Costs "2000" and Living Expenses "3000" and Additional Income "5000" and verify's the IncomeGoal value
Then User clicks at "Save & Next" button
Then User verify's on "CROPS & CROP INFO" tab that the text "Crop Choices"  is displayed
When User clicks on "Field Crops" 
And under "Field Crops" User selects the below crops
|Cotton (Pima)|Alfalfa|Corn (silage)|
Then for "Field Crops" User can see the below table and can add details under given below
|Crop         |UOM      |Expected Yield|Expected Price|Production Cost|
|Cotton (Pima)|Bushel(s)|130           |20            |300            |
|Alfalfa      |Bushel(s)|120           |10            |200            |
|Corn (silage)|Bushel(s)|95            |5             |95             |
When User clicks on "Fruits and Vegetables" 
And under "Fruits and Vegetables" User selects the below crops
|Potatoes|
Then for "Fruits and Vegetables" User can see the below table and can add details under given below
|Crop         |UOM      |Expected Yield|Expected Price|Production Cost|
|Potatoes     |Pound(s) |150           |40            |200           |
And User clicks at "Save & Next" button
Then User verify's on "MANAGE RESOURCES" tab that the text "Manage Resources"  is displayed
And User clicks on the edit button and enters the values for the below Resource
|Resource      |Amount Available|EditBtnOptions|
|WorkingCapital|500000          |Update        |
Then User clicks on "+ Add Resource" button to add the "Resources" under "MANAGE RESOURCES" tab 
And User adds the new Resources given below
|Resource                       |Amount Available |EditBtnOptions|
|Seed                           |100             |Save and Add  |
|Fertilizer and soil amendments |200             |Save and Add  |
|Insecticide                    |100             |Save and Add  |
|Defoliant                      |300             |Save and Add  |
|Crop insurance                 |100             |Update        |
Then User clicks at "Save & Next" button
Then User verify's on "MANAGE RESOURCES" tab that the text "Resource Usage"  is displayed
Then User clicks on "+ Add Crop Resource" button to add the "Resources" under "MANAGE RESOURCES" tab 
And User adds the new Resource Usage given below
|Resource                       |Amount Used/Acre |Crop          |EditBtnOptions|
|Fertilizer and soil amendments |20               |Alfalfa       |Save and Add  |
|Seed                           |30               |Potatoes      |Save and Add  |
|Insecticide                    |10               |Corn (silage) |Update        |
Then User clicks at "Save & Next" button
Then User verify's on "FORWARD SALES" tab that the text "Forward Sales"  is displayed
And User clicks at "Save & Next" button
Then User verify's on "CROP LIMITS" tab that the text "Crop Limits"  is displayed
And User enters the below values for the selected crops and saves the details
|Crop         |Min Acres      |Max Acres| RequiredButton |
|Cotton (Pima)|100            |1000     |Update          |
|Alfalfa      |150            |1000     |Update          |
|Corn (silage)|250            |1000     |Update          |
|Potatoes     |200            |1000     |Update          |
And User clicks at "Submit & Review" button
Then User gets the popup screen and User clicks on "Analyze" Button
#Then User verify's on "Planning Dashboard" tab that the text "Planning Dashboard"  is displayed
And User is navigaed to Planning Dashboard page where for strategy "PracticeFarm5" user clicks on the "Clone" button
Then User gets the new strategy created with the same name but date added "PracticeFarm5_08/05/2021" and clicks on the "Edit" button
Then User clicks at "Save & Next" button
Then User clicks at "Save & Next" button
Then User clicks at "Save & Next" button
Then User clicks at "Save & Next" button
Then User verify's on "FORWARD SALES" tab that the text "Forward Sales"  is displayed
When User clicks on "+ Add Forward Sales" button of the "FORWARD SALES" tab then User is able to fill all the below details
|Crop            |Sale Type  |Unit Price  |Quantity   |Button   |
|Cotton (Pima)   |Firm       |10          |100        |Update   |
|Alfalfa         |Proposed   |100         |20         |Update   |
|Corn (silage)   |Proposed   |20          |150        |Update   |
|Potatoes        |Firm       |50          |200        |Update   |
Then User clicks at "Save & Next" button
And User clicks at "Submit & Review" button
Then User gets the popup screen and User clicks on "Analyze" Button
And User is navigaed to Planning Dashboard page where for strategy "PracticeFarm5_08/05/2021" user clicks on the "Result" button







