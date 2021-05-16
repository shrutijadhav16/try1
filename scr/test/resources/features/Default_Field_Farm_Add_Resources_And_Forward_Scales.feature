Feature: To add the resources and forward scales in the Basic Startegy of Default Field Farm

Background: 
Given User is on the "Login" screen
When User enters username "siva@c4bneeds.com" and password "Test@1234"
And User clicks on Login button
When User clicks on the  button "Create Strategy" button

Scenario: Add resources and Forward scales for Default Field Farm
Given User is landed on Planning Model page
Then User verify's on "Planning Model" tab that the text "Create Strategy"  is displayed
Then User selects "Default Field Farm" Farm Name
And User selects "Field Farm" Strategy Name
And User selects "Field" Planning Model and enters no Available Acres  required
When User clicks on "Income Goal (Optional)" button
And User enters Fixed Costs "2000" and Living Expenses "3000" and Additional Income "5000" and verify's the IncomeGoal value
Then User clicks at "Save & Next" button
Then User verify's on "CROPS & CROP INFO" tab that the text "Crop Choices"  is displayed
When User clicks on "Field Crops" 
And under "Field Crops" User selects the below crops
|Alfalfa|Barley|Cotton (upland)|
Then for "Field Crops" User can see the below table and can add details under given below
|Crop           |UOM      |Expected Yield|Expected Price|Production Cost|
|Alfalfa        |Bushel(s)|130           |20            |300            |
|Barley         |Bushel(s)|120           |10            |200            |
|Cotton (upland)|Bushel(s)|95            |5             |95             |
When User clicks on "Fruits and Vegetables" 
And under "Fruits and Vegetables" User selects the below crops
|Cauliflower|Broccoli|Lettuce (iceberg)|
Then for "Fruits and Vegetables" User can see the below table and can add details under given below
|Crop             |UOM      |Expected Yield|Expected Price|Production Cost|
|Cauliflower      |Pound(s) |150           |40            |200            |
|Broccoli         |Bushel   |150           |40            |200            |
|Lettuce (iceberg)|Pound(s) |150           |40            |200            |
And User clicks at "Save & Next" button
Then User verify's on "FIELDS & FIELD INFO" tab that the text "Field Information"  is displayed
Then User clicks on "+ Add Field" button to add the "Field Information" under "FIELDS & FIELD INFO" tab 
And User adds the new Field Information given below
|Field      |Size (acres)   |Last Crop         |Fallow   |Button          |
|Model 1    |120            |Cotton (upland)   |Check    |Save and Add    |
|Model 2    |100            |Lentils           |Check    |Save and Add    |
|Model 3    |110            |Corn (silage)     |Check    |Update          |
Then User clicks at "Save & Next" button
Then User verify's on "CROP/ FIELD CHOICES" tab that the text "CROP / FIELD CHOICES  is displayed
Then User unchecks the crop below depending upon the radio button is on or off which is "OFF" here 
|Field   | Crop               |Crop Number   |
|Model 1 |Lettuce (iceberg)   | 1            |
|Model 1 |Broccoli            | 2            |
|Model 1 |Cauliflower         | 3            |
|Model 1 |Cotton (upland)     | 4            |
|Model 1 |Barley              | 5            |
|Model 1 |Alfalfa             | 6            |
|Model 2 |Lettuce (iceberg)   | 1            |
|Model 2 |Broccoli            | 2            |
|Model 2 |Cauliflower         | 3            |
|Model 3 |Cotton (upland)     | 4            |
|Model 3 |Barley              | 5            |
|Model 3 |Alfalfa             | 6            |
Then User clicks at "Save & Next" button
Then User verify's on "MANAGE RESOURCES" tab that the text "Manage Resources"  is displayed
And User clicks on the edit button and enters the values for the below Resource
|Resource      |Amount Available|EditBtnOptions |
|WorkingCapital|1000000          |Update        |
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
|Resource                       |Amount Used/Acre |Crop           |EditBtnOptions|
|Fertilizer and soil amendments |20               |Alfalfa        |Save and Add  |
|Seed                           |30               |Barley         |Save and Add  |
|Insecticide                    |10               |Cotton (upland)|Update        |
Then User clicks at "Save & Next" button
Then User verify's on "FORWARD SALES" tab that the text "Forward Sales"  is displayed
And User clicks at "Save & Next" button
Then User verify's on "CROP LIMITS" tab that the text "Crop Limits"  is displayed
And User enters the below values for the selected crops and saves the details
|Crop             |Min Acres      |Max Acres| RequiredButton |
|Lettuce (iceberg)|100            |1000     |Update          |
|Cotton (upland)  |150            |1000     |Update          |
|Cauliflower      |250            |1000     |Update          |
|Alfalfa          |200            |1000     |Update          |
|Barley           |300            |1000     |Update          |
|Broccoli         |100            |1000     |Update          |
And User clicks at "Submit & Review" button
Then User gets the popup screen and User clicks on "Analyze" Button
Then User clicks on "Default Field Farm" link to view Field Farms
Then User clicks on "Default Field Farm" link to view Field Farms
Then User verify's on "Planning Dashboard" tab that the text "Planning Dashboard"  is displayed
And User is navigaed to Planning Dashboard page where for strategy "Field Farm" user clicks on the "Clone" button
Then User gets the new strategy created with the same name but date added "Field Farm_06/05/2021" and clicks on the "Edit" button
Then User clicks at "Save & Next" button
Then User clicks at "Save & Next" button
Then User clicks at "Save & Next" button
Then User verify's on "CROP/ FIELD CHOICES" tab that the text "CROP CHOICES"  is displayed
Then User unchecks the crop below depending upon the radio button is on or off which is "OFF" here 
|Field   | Crop               |Crop Number   |
|Model 1 |Lettuce (iceberg)   | 1            |
|Model 1 |Broccoli            | 2            |
|Model 1 |Cauliflower         | 3            |
|Model 1 |Cotton (upland)     | 4            |
|Model 1 |Barley              | 5            |
|Model 1 |Alfalfa             | 6            |
Then User clicks at "Save & Next" button
Then User verify's on "MANAGE RESOURCES" tab that the text "Manage Resources"  is displayed
Then User clicks at "Save & Next" button
Then User clicks at "Save & Next" button
Then User verify's on "FORWARD SALES" tab that the text "Forward Sales"  is displayed
When User clicks on "+ Add Forward Sales" button of the "FORWARD SALES" tab then User is able to fill all the below details
|Crop                |Sale Type  |Unit Price  |Quantity   |Button   |
|Lettuce (iceberg)   |Firm       |10          |100        |Update   |
|Broccoli            |Proposed   |100         |20         |Update   |
|Barley              |Proposed   |20          |150        |Update   |
|Cauliflower         |Firm       |50          |200        |Update   |
Then User clicks at "Save & Next" button

And User clicks at "Submit & Review" button
Then User gets the popup screen and User clicks on "Analyze" Button
Then User clicks on "Default Field Farm" link to view Field Farms
Then User clicks on "Default Field Farm" link to view Field Farms
And User is navigaed to Planning Dashboard page where for strategy "Field Farm_06/05/2021" user clicks on the "Result" button
