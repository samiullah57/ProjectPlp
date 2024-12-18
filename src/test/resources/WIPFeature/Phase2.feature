Feature: Phase2 Automation R2R

  @652406
  Scenario Outline: 652406: RT for Supplementary Services Consultancy for Clinical On-Site
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "Quote Admin"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Service Request" on Installed Product
    When I Choose to Request a Quote SFM "Draft"
    When I Choose to Release Quote SFM
    When I Choose to Approve Quote
    When I Choose to Generate Quote PDF SFM
    When I Choose to Accept Quote
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "case" from search list
    When I Choose to Create Clinical Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician>"
    When I Choose "Work Order" from search list
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<MasterDataAdmin>"
    When I Choose "Work Order" from search list
    When I choose to update WO as Fixed
    When I Choose "case" from search list
    When I Choose to perform case closure using Business Complete SFM

    Examples: 
      | UserRole            | IP       | ServiceTechnician | MasterDataAdmin |
      | ServiceAgent | 62794133 | ServiceTechnician | MasterDataAdmin |

  @1148712
  Scenario Outline: 1148712: Distributor Incident with Parts
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I choose to search for Account using Search Criteria

      | Account Name | contains | S&T Slovakia s.r.o. |
      | Account Type | contains | ServiceMax Account  |
    When I choose to Create Contact from Account
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "Yes"
    When I Choose to Create "Distributor WO" Work Order SFM
    And I choose to verify WO updates
    #And I verify trackwise record updated correctly
    #Scenario2
    When I Choose "<IP2>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "Yes"
    When I Choose to Create "Distributor WO" Work Order SFM
    When I choose to request part in Hybris
      | 453566186571 | 453564235171 |
    Then I choose to verify ASO number on WO Page
    #Scenario3 - Verify Partner Portal: Mass Load of Safety Questions for Incidents
    And I choose to click on All Tabs
    And I click on object "<Object Name>"
    And I Choose to select listview option "<List View Option>"
    And I Choose to create records using IMU SCV file
    And I Choose to verify the IMU records created
      | Created Date | equals   | TODAY                           |
      | Created By   | contains | Distributor S&T Slovakia s.r.o. |
    And I Choose to Create Case on IMU records
    And I Choose to select listview option "<List View Option2>"
    And I Choose to verify the Trackwise Status on IMU "Record2" "<Trackwise Status on Record2>"
    And I Choose to verify the Trackwise Status on IMU "Record1" "<Trackwise Status on Record1>"

    Examples: 
      | UserRole         | IP       | IP2      | Object Name           | List View Option | List View Option2    | Trackwise Status on Record2                                                       | Trackwise Status on Record1                    |
      | Distributor user | 83275202 | 59029166 | Incident Mass Uploads | All              | My_Processed_Records | This is PIL TW.Upload Safety Answer Not provided,Please Answer Questions Manually | This is PIL TW.Upload Safety Answer Successful |

  # Provide unique FCO Header Number in FCO Header file and execute Part1
  @737463
  Scenario Outline: 737463:Test to verify as a Distributor able to order FCO parts once per FCO
    Given I launch ServiceMax application successfully
    And I Choose to enter credentials for "<BGFCO>"
    And I Choose to Load Data "<SheetName>"
    Then I Choose to open Data Import Wizard "<BGFCO>"
    When I Choose to Import FCO data to ServiceMax
    When I Choose to Verify FCO data import to ServiceMax
    When I Choose to Save and Update FCO Header Details
    When I Choose to Update FCO Record Details to FCO Header "UAL" File
    Then I Choose to open Data Import Wizard "<BGFCO>"
    When I Choose to Import UAL data to ServiceMax
    When I Choose to Verify FCO data import to ServiceMax
    And I Choose "fco" from search list
    When I Choose to Create Parts on FCO
      | 453561407812 | 1 |
      | 453563476891 | 4 |
      | 453561343282 | 1 |
    When I Chosse to Edit the created parts
      | 453561407812 | 2 |
      | 453563476891 | 3 |
    When I Choose to create CALorDAL from UAL
    When I Choose to Create "DAL" Case and verify case type
    When I Choose to Create "DAL" WO and verify WO type
    When I Choose to create Parts WO on created parts
    When I Choose to capture "DAL" WOs "Parts WO"
    When I Choose to verify parts WO created
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to complete Q&R WO
    When I Choose to Search WorkOrder "WorkOrder2" using global search box
    When I Choose to Open WorkOrder "WorkOrder2" from the search result
    When I Choose to perform Sync IP and Parts Count
    When I choose to request part in Hybris
      | 453561407812 | 453563476891 | 453561343282 |
    Then I choose to verify ASO number on WO Page
    Then I Choose to log out of the application
    And I Choose to enter credentials for "<BGFCO>"
    And I Choose "fco" from search list
    When I Chosse to Edit the created parts
      | 453563476891 | 5 |
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder2" using global search box
    When I Choose to Open WorkOrder "WorkOrder2" from the search result
    When I Choose to perform Sync IP and Parts Count
    When I choose to request part in Hybris
      | 453561407812 | 453563476891 | 453561343282 |
    Then I choose to verify ASO number on WO Page
    When I Choose to Complete FCO Parts WO

    Examples: 
      | BGFCO | SheetName | UserRole     | ServiceTechnician | UserRole2        |
      | BGFCO |    440278 | ServiceAgent | ServiceTechnician | Distributor user |
      
      
  @1497135
    Scenario Outline: 1497135:Test to verify that user is able to create Case from the "Create T&M Case and Caseline" SFM
    Given I launch ServiceMax application successfully
    And I Choose to enter credentials for "Quote Admin"
    And I Choose to capture test data details
     | 88967334 | 850004 | 999999888888777780 | US115373-999-10 | Armstrong Relocation & Co |
     | 88967332 | 850004 | 999999888888777778 | US115373-999-10 | Armstrong Relocation & Co |
   	And I Choose "location" from search list
   	When I Choose to create TM Case and Caselines
   	When I Choose to add CaseLines in the TM Case created
   	When I Choose to verify Caseline Checkbox
   #	#when there is no IP with PM Plan in the same location use different location and IP
   #	And I Choose to capture test data details
     #| 88955417 | 866199 | 6305274736 | ES101086-002-06 | TRANSPORTES TRANSCARSON |
   #	And I Choose "location" from search list
   #	#observed unexpected behaviour in below step - Validation yet to be added
   #	When I Choose to verify error message when creating TM Case with PM History
   #	#script step6 after KT
    When I Choose "case" from search list
   	When I Choose to Request a Quote SFM "Draft"
    When I Choose to Release Quote SFM
    When I Choose to Generate Quote PDF SFM
    When I Choose to Accept Quote
   	 Then I verify Debit Memo Integration Status "<dmrStatus>"
   	# When I Choose to Open Case From Service Quote Detail Page
   	Then I Choose to log out of the application
   	  When I Choose to enter credentials for "<UserRole>"
    When I Choose "case" from search list
   	 When I Choose to Create Onsite Work Order SFM
   	 When I Choose to Initiate SWO
   	  When I Choose to add Parts Ordering SFM "45354175680"
   	  When I Choose to capture 'ASO number'
    Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
#    
#    # SAP PGI
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "/nva03" T Code in the I2M SAP application
    When I Choose to Search "ASO-Item" in Order Field
    When I Choose to Click "Item-Overview" Tab of "ASO-Item" Window
    When I Choose to Select ASO Item
    When I Choose to Select "Sales Document and Deliver" Menu Item
    When I Choose to Click "Picking" Tab of "ASO-Delivery" Window
    When I Choose to Update Picking Quantity
    When I Choose to Select "Extras Serialize Number" Menu Item
    When I Choose to Pack ASO Delivery Items
    When I Choose to Update Packing Materials
    When I Choose to update Identification in ASO Delivery Handling
    When I Choose to Click on Back Menu Bar
    When I Choose to Pack each ASO Delivery Items
    When I Choose to enter "/nvl02n" Delivery in the SAP application
    When I Choose to Search "ASO-Delivery" in Order Field
    When I Choose to Post ASO Goods Issues
#     # SAP PGI - END
     
    When I Choose to enter credentials for "<ServiceTechnician>"
    When I Choose "Work Order" from search list
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<MasterDataAdmin>"
    When I Choose "Work Order" from search list
    When I choose to update WO as Fixed
    When I Choose "case" from search list
    When I Choose to perform case closure using Business Complete SFM
     
    Examples: 
      | AgentNonEvent | UserRole     |  Location | dmrStatus | ServiceTechnician | MasterDataAdmin |
      | AgentNonEvent | AutomationAgentUser | Armstrong Relocation & Co | Debit memo creation success | AutomationTechnicianUser | MasterDataAdmin |
      
   @440383
  Scenario Outline: 440383: Remote with RSW (Remote Service Workspot) to Onsite Follow up with incomplete scenarios in iPad and Sub-Contractor Flow 
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "<IP>" from search list
   	When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
   	When I Choose to Open Case and create safety questionnaire "Yes"
   #	Then I choose to verify TW updates are created
   	 When I Choose to Create 'Remote Service Workorder'
   	 Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to 'Initiate Remote Service' SFM
    When I Choose to transfer and verify WO details to RSW
    When I Choose to enter field values in RSW
    Then I Choose to publish service report to Smax from RSW
    
    Examples:
    |UserRole| IP | UserRole2 |
    |ServiceAgent| 67914456 | ServiceTechnician |
    
     @438542
  Scenario Outline: 438542: OneEMS and SMax - QCM Trackwise - PIL Case flow verification
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #When I Choose "<IP1>" from search list
    #When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
   #	When I Choose to Open Case and create safety questionnaire "Yes"
    #And I Verify TW record is "Created"
    #When I Choose to Create Onsite Work Order SFM
    #When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose "Work Order" from search list
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order
    Then I Choose to log out of the application
  #
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose "<IP1>" from search list
   	When I Choose to create Case of Event Type "Predictive / Preventative Maintenance" and Event Sub Type "Predictive / Preventative Maintenance" on Installed Product
   	And I Verify TW record is "Not Created"
   	
   	 When I Choose "<IP1>" from search list
   	When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Service Request" on Installed Product
   	And I Verify TW record is "Not Created"
   	
   	 When I Choose "<IP1>" from search list
   	When I Choose to create Case of Event Type "Proactive Monitoring" and Event Sub Type "Proactive Monitoring" on Installed Product
   	And I Verify TW record is "Not Created"
   	
   	When I Choose "<IP1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
   	And I Verify TW record is "Created"
   	
   
    
    When I Choose "<IP2>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Technical Support for Trade Partner" on Installed Product
   	When I Choose to Open Case and create safety questionnaire "No"
    And I Verify TW record is "Created"
    Then I Choose to log out of the application
    
    When I Choose to enter credentials for "CustomAgent"
    And I Choose to navigate to home page
    
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Customer Feedback"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    
     And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Corrective Maintenance"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Corrective Maintenance"
    And I choose to click on option "Safety Questions"
    And I choose enter questionery Answers
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    
    
    #different user
    #And I choose to search the "<Asset>"
    #And I choose to open the asset "<Asset>"
    #And I choose to click on New Case
    #And I choose select Case record type "<Record Type2>"
    #And I choose to enter case Details "Case - Escalated"
    #And I Verify TW record is "Not Created"
    
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type3>"
    And I choose to enter case Details "Case - SubCase"
    And I Verify TW record is "Not Created"
    
    	And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Application Support"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    	
    	And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Customer Feedback"
   And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
 
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Customer Relations"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Customer Relations"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    	
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Customer Information"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
    	
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Lifecycle Solution"
    And I Verify TW record is "Created"
    And I verify TW record values
    |Pending|Checked|Trackwise - PIL|
   	
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Void/Error"
    And I Verify TW record is "Not Created"
    
   	And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Direct Sales"
    And I Verify TW record is "Not Created"
   	
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Contractual Upgrade"
    And I Verify TW record is "Not Created"
    
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Internal Support"
    And I Verify TW record is "Not Created"
    	
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<Record Type>"
    And I choose to enter case Details "Clinical Education"
    And I Verify TW record is "Not Created"
    
    When I Choose to enter credentials for "<UserRole3>"
    When I Choose "<IP3>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create "Distributor WO" Work Order SFM
    Then I Choose to verify Potential Safety Fields and WO Fix
    
    	
    Examples:
    |UserRole| IP1 | IP2 | IP3 | UserRole2 | Asset | Record Type | Record Type2 | Record Type3 | UserRole3 |
    |ServiceAgent| 67914456 | 56905012 | 83275202 |ServiceTechnician | 43835372 | Case - New | Case - Escalated | Case - SubCase | Distributor user |
