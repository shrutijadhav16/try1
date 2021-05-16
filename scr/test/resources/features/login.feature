Feature: To Test Basic Startegy for Default Acer Farm
         
Background: 
Given User is on the "Login" screen
When User enters username "siva@c4bneeds.com" and password "Test@1234"
And User clicks on Login button
When User clicks on the  button "Create Strategy" button

         
#Scenario: To test if the user is successfulyy able to login to the portal
#Given User is successsfully logged in and verify's the "Planning Dashboard"

Scenario: User fills the Basic Strategy for Default Acer Farm
Given User is landed on Planning Model page
Then User verify's on "Planning Model" tab that the text "Create Strategy"  is displayed
Then User selects "Default Acres Farm" Farm Name
And User selects "PracticeFarm2" Strategy Name
And User selects "Acres" Planning Model and enters "1000" Available Acres 
When User clicks on "Income Goal (Optional)" button
And User enters Fixed Costs "2000" and Living Expenses "3000" and Additional Income "5000" and verify's the IncomeGoal value
Then User clicks at "Save & Next" button
Then User verify's on "CROPS & CROP INFO" tab that the text "Crop Choices"  is displayed
When User clicks on "Field Crops" 
And under "Field Crops" User selects the below crops
|Cotton (Pima)|Sunflowers|Peanuts|Hemp|Corn (feed)|
Then for "Field Crops" User can see the below table and can add details under given below
|Crop         |UOM      |Expected Yield|Expected Price|Production Cost|
|Cotton (Pima)|Bushel(s)|130           |20            |300            |
|Sunflowers   |Bushel(s)|120           |10            |200            |
|Peanuts      |Bushel(s)|95            |5             |95             |
|Hemp         |Bushel(s)|85            |4             |85             |
|Corn (feed)  |Bushel(s)|75            |3             |75             |
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
|WorkingCapital|1000000          |Update        |
Then User clicks at "Save & Next" button
Then User verify's on "FORWARD SALES" tab that the text "Forward Sales"  is displayed
And User clicks at "Save & Next" button
Then User verify's on "CROP LIMITS" tab that the text "Crop Limits"  is displayed
And User enters the below values for the selected crops and saves the details
|Crop         |Min Acres      |Max Acres| RequiredButton |
|Cotton (Pima)|100            |1000     |Update          |
|Sunflowers   |150            |1000     |Update          |
|Peanuts      |20             |1000     |Update          |
|Hemp         |50             |1000     |Update          |
|Corn (feed)  |150            |1000     |Update          |
|Potatoes     |200            |1000     |Update          |
And User clicks at "Submit & Review" button
Then User gets the popup screen and User clicks on "Analyze" Button
And User is navigaed to Planning Dashboard page where for strategy "PracticeFarm2" user clicks on the "Result" button









