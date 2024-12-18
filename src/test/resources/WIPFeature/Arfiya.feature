Feature: ServiceMAx

  @878813
  Scenario Outline: 878813: To verify Subcontractor PM Plan Logic for Automated PM
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>" 
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" the above record
    Then I Choose to get the contract Start Date
    Then I Choose to open preventive maintenance plan with "<Contract>"
    And I verify PM plan start date with contract start date
    When I Choose to Open WorkOrder "<DebriefedWorkorder>" from Work Orders list
    When I Choose to View System Information
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole1>"   
    When I Choose to Search "<Contract1>" using global search box
    When I Choose to Open "<Contract1>" the above record
    Then I Choose to Enter details in Contract Renewal section
    Then I Choose to Renew Service Contract
    Then I Choose 'Send to SAP' SFM
    Then I Choose to 'Activate Contract'SFM
    Then I Choose to log out of the application
    
    When I Choose to enter credentials for "<UserRole>" 
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" the above record
    Then I Choose to open preventive maintenance plan with "<Contract>"
    And I verify PM plan start date with contract start date
    Then I verify 'Last Delivered PM Sequence' field is equal to Debrief Date of WO1
    And I verify 'Last Delivered PM Date' field is equal to 'Service Activity' of WO1
 	
 	
 	
    	
 	Examples:
 	  |   UserRole   | Contract   | DebriefedWorkorder |   UserRole1  	 | Contract1   |
      | ServiceAgent | CON0438456 | WO-03947821        | MasterDataAdmin | CON0438456  |
      
      
  @645138
  Scenario Outline: 645138: OneEMS Regression – Test to verify OneEMS case closure of service type Remote Service
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to open "<case>"
    When I Choose to navigate to details page
    When I Choose to click on SFW Section button "<Request a Quote>"
    When I choose to select new quote request
    When I choose to enter mandatory fields of quote page
    When I Choose to select new work order
    When I choose to fill Parts details
    When I choose to fill labor details
    Then I choose to click on Get Price
    Then I choose to click on Pull discounts
    Then I choose to validate the calculations
    Then I choose to release quote




    Examples:
      | UserRole | case |Request a Quote|
      | ServiceAgent |0118595250 |Request a Quote|      
      
      
@438536
  Scenario Outline: 438536: Installed Base Management – Warranty is getting created for the IP created from SAP automatically
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<WarrantyTerms>" using global search box
    When I Choose to Open "<WarrantyTerms>" the above record
    Then I choose to create new applicable product "453561497451" in Warranty Terms
    When I Choose "<IP>" from search list
    Then I Choose to enter details in IP detail page
    And I Choose to verify Warranty Term details under Product warranty section
    Then I Choose to log out of the application
    #Part2
    
    When I Choose to enter credentials for "ServiceAgent"
    When I Choose to open "<case>"
    When I Choose to Create Onsite Work Order SFM
    Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
    When I Choose to Search Work Order using global search box
    When I Choose to 'Parts Ordering' SFM "453561497451"
	When I Choose to capture 'ASO number'
    #SAP part from 18 to 30 steps
    Then I Choose to log out of the application
    
    #Part3
    When I Choose to enter credentials for "<UserRole1>"
	When I Choose to Search Work Order using global search box
#	When I Choose to Search "<WorkOrder>" using global search box
#   When I Choose to Open "<WorkOrder>" the above record
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order
    Then I Choose to log out of the application    

	Examples:
      | UserRole 	    | case  	 |IP      | WarrantyTerms     | UserRole1   | WorkOrder|
      | MasterDataAdmin |0118606320 |96008937 |1Yr Onsite - PCMS |  ServiceTechnician | WO-04659086 |