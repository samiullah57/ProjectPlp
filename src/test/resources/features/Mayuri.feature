Feature: Regression Test Case for SMax and SAP 

@Test123 
Scenario Outline:
439692: OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service 
	Given I launch ServiceMax application successfully 
	When I Choose to enter credentials for "<UserRole>" 
	When I Choose to open "<case>" 
	When I Choose to navigate to details page 
	When I Choose to click on SFW Section button "<Request a Quote>" 
	
	
	#	When I Choose to Search "<case>" using global search box
	
	Examples: 
		| UserRole    	| case 			|Request a Quote|
		| ServiceAgent 	|0118593251 	|Request a Quote|
		
		
@453845
Scenario Outline: 453845: Mass data upload using ‘Informatica’ 
	Given I launch Informatica application successfully 
	When I Choose to execute accounts workflow 
	When I Choose to execute contact workflow 
	When I Choose to execute Account Partner workflow 
	Given I Choose to enter credentials for "<UserRole>" 
	When I Choose to access accounts report 
	Then I Choose to validate accounts report 
    When I Choose to access contact report
    Then I Choose to validate contact report
	When I Choose to access account partner report
    Then I Choose to validate account partner report  
	
	
	Examples: 
		| UserRole    		| 
		| MasterDataAdmin 	|

		
@437535
Scenario Outline: 437535: Verify IP Staging Improvements
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to update "<Functional_Location>" Name for Staging
    Given I choose to login to SAP system
    When I choose to read all the SAP data required for Tc "437535"
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment1"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment1"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment2"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment2"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment3"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment3"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment4"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment4"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment5"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment5"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment6"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment6"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment7"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment7"
    And I choose to Rewoke "<Functional_Location>" Name for Processing
    And I choose to access "IP Staging" tab
    And I choose to update the "Auto IP1" Filter details
    And I choose to perform force update for "Equipment1"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment1" Details after IP Processing
    And I choose to update the "Auto IP2 and IP3" Filter details
   And I choose to perform force update for "Equipment2"
    And I choose to perform force update for "Equipment3"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment2" Details after IP Processing
    And I choose to verify "Equipment3" Details after IP Processing
    And I choose to update the "Auto IP4 and IP5" Filter details
    And I choose to perform force update for "Equipment4"
    And I choose to perform force update for "Equipment5"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment4" Details after IP Processing
    And I choose to verify "Equipment5" Details after IP Processing
    And I choose to update the "Auto IP6 and IP7" Filter details
    And I choose to perform force update for "Equipment6"
    And I choose to perform force update for "Equipment7"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment6" Details after IP Processing
    And I choose to verify "Equipment7" Details after IP Processing
    When I choose to close SAP Application
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | TcreEqp | tabName | tableName       | Tcode1 | programName         | Functional_Location |
      | MasterDataAdmin | /nie01  | SerData | CreateEquipment | /nse38 | ZR_CS_EQUIP_EXTRACT | ES100026-001-032  |
      
     
      
      @438549
  Scenario Outline: 438549: F16949 - DX Cross Border – To verify flow cross border contract postings from SMax-MP1 for a non-legacy contract

    Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<UserRole>"
    #Then I Choose to verify profile for Logged on user "<UserRole>"
    #When I Choose to Search "<Contract>" using global search box
    #When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<UserRole>"
    #Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceAgent>"
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<UserRole>"
    And I Choose to verify the values in Included services section
    When I Choose to Verify whether a record with Installed Product is displayed
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    Then I choose to get the values from installed product
    Then I choose to click on Product on IP page
    Then I choose to verify values of BG and BU on Product Page
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM for "2" hours
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    And I choose to get the WO1
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician>"
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to open Work Order Line items and save record
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<TCode>"
    When User enters SAPSWO nubmer gererated in servicemax
    When User access Operations Tab
    Then User Verifies the values present in Operations Tab
    When User Clicks on Enhancement Button
    Then User Verifies Enhanceent Details
    When User click on Back Button
    When User Access Settlement Tab
    Then User Verifies Settlement Details
    When Users click on Back button in Settlements page
    When User access Confirmation Page
    When user verifies Confirmation Page Details
    When user Access Main SAP Page
    When User Enters Tcode "<TCode2>"
    When User Search contract bar
    When User Access Sales Details page
    Then User Verifes Sales details
    When I choose to close SAP Application

    Examples: 
      | UserRole        | Contract   | Installed Product | ServiceAgent | ServiceTechnician | ServiceTechnician  | MasterAdmin     | Technician  | EventType | SubEventType | TCode | TCode2 |
      | MasterDataAdmin | CON0351018 |          58438644 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Automation Technician User  | Incident  | Incident     | iw33  | /nva43 |
      
      
       @438548
  Scenario Outline: 438548: F16949 - DX Cross Border – To verify flow cross border contract postings from SMax-MP1 for a non-legacy contract

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<UserRole>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceAgent>"
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<UserRole>"
    And I Choose to verify the values in Included services section
    When I Choose to Verify whether a record with Installed Product is displayed
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    Then I choose to get the values from installed product
    Then I choose to click on Product on IP page
    Then I choose to verify values of BG and BU on Product Page
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM for "2" hours
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    And I choose to get the WO1
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to open Work Order Line items and save record
    Given I Choose to Start LeanFT Run time engine
    #Given I Choose to launche to SAP application
    #When User enters T Code in SAP application as"<TCode>"
    #When User enters SAPSWO nubmer gererated in servicemax
    #When User access Operations Tab
    #Then User Verifies the values present in Operations Tab
    #When User Clicks on Enhancement Button
    #Then User Verifies Enhanceent Details
    #When User click on Back Button
    #When User Access Settlement Tab
    #Then User Verifies Settlement Details
    #When Users click on Back button in Settlements page
    #When User access Confirmation Page
    #When user verifies Confirmation Page Details
    #When user Access Main SAP Page
    #When User Enters Tcode "<TCode2>"
    #When User Search contract bar
    #When User Access Sales Details page
    #Then User Verifes Sales details
    #When I choose to close SAP Application

    Examples: 
      | UserRole        | Contract   | Installed Product | ServiceAgent | ServiceTechnician | L1TechnicianUser  | MasterAdmin     | Technician  | EventType | SubEventType | TCode | TCode2 |
      | MasterDataAdmin | CON0070254 |          34155319 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /nva43 |
      
