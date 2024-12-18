Feature: ServiceMax Test scripts

  # Provide unique FCO Header Number in FCO Header file and execute Part1
  @440278
  Scenario Outline: 440278:FCO -UAL, CAL & DAL Case & Q&R Work Orders Creation & Header Updates (1-2-1 & Location Based) using Platform events
    Given I launch ServiceMax application successfully
    And I Choose to enter credentials for "<BGFCO>"
    And I Choose to Load Data "<SheetName>"
    # Part1
    Then I Choose to open Data Import Wizard "<BGFCO>"
    When I Choose to Import FCO data to ServiceMax
    When I Choose to Verify FCO data import to ServiceMax
    When I Choose to Save and Update FCO Header Details
    When I Choose to Update FCO Record Details to FCO Header "UAL" File
    Then I Choose to open Data Import Wizard "<BGFCO>"
    When I Choose to Import UAL data to ServiceMax
    When I Choose to Create "UAL" Case and verify case type
    When I Choose to Create "UAL" WO and verify WO type
    #Part2 - Modify the Cases and WOs created manually as per TC and update TC sheet in Data.xlxs
    #Case1 and WO1 - New status
    #Case2 and WO2 - InProgress
    #Case3 and WO3 - Cancelled
    Then I choose to verify fields on FCO Headers
    And I choose to cascade change on FCO Header
    Then I verify changes in "Case1" and "WO1"
    Then I verify changes in "Case2" and "WO2"
    Then I verify changes in "Case3" and "WO3"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "Work Order1" from search list
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    When I Choose "Work Order2" from search list
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician>"
    #Then I verify changes in "Case1" and "WO1"
    Then I verify changes in "Case2" and "WO2"
    Then I Choose to log out of the application
    And I Choose to enter credentials for "<BGFCO>"
    #Then I Choose to open Data Import Wizard "<BGFCO>"
    #When I Choose to Import FCO data to ServiceMax
    #When I Choose to Verify FCO data import to ServiceMax
    #When I Choose to Save and Update FCO Header Details
    #Then I Choose to open Data Import Wizard "<BGFCO>"
    #When I Choose to Import UAL data to ServiceMax
    #When I Choose to Create "UAL" Case and verify case type
    When I Choose to create CALorDAL from UAL
    When I Choose to Create "CAL" Case and verify case type
    When I Choose to Create "CAL" WO and verify WO type
    When I Choose to Create "DAL" Case and verify case type
    When I Choose to Create "DAL" WO and verify WO type
    When I Choose to verify CAL/DAL WOs
    Then I Choose to log out of the application

    Examples: 
      | BGFCO | SheetName | UserRole     | ServiceTechnician |
      | BGFCO |    440278 | ServiceAgent | ServiceTechnician |

  #FCO number should be unique, before importing the file, check for existing FCO and change FCO number accordingly.
  @436585_1
  Scenario Outline: 436585:Test to verify the FCO Due diligence attempts records are created successfully
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to verify profile for Logged on user "<UserRole>"
    Then I Choose to open Data Import Wizard "<UserRole>"
    When I Choose to Import FCO data to ServiceMax
    When I Choose to Verify FCO data import to ServiceMax
    When I Choose to Save and Update FCO Header Details
    When I Choose to Update FCO Record Details to FCO Header "CAL" File
    Then I Choose to open Data Import Wizard "<UserRole>"
    When I Choose to Import FCO CAL data to ServiceMax
    When I Choose to Verify FCO CAL data import to ServiceMax
    When I Choose to Create FCO Case
    When I Choose to Create FCO Work Orders
    When I Choose to Open Case And Verify FCO Work Orders
    When I Choose to Initiate FCO Work Order And Create Due Diligence
    When I Choose to Add Multiple Due Diligence And Verify Status

    Examples: 
      | UserRole |
      | BGFCO    |

  #Inprogress
   @711331
  Scenario Outline: 711331 :Unknown Installed Product case creation & correction initiated from WO
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #When I Choose to Load Data "<TestData>"
    #When I Choose to Create Contact using Record Type "Contact" And Account "North Shore Health Systems"
    #When I Choose to create Case on Active Contact With "<Product Type>" And "<Event Type>" And "<Priority>" And "<Case Origin>" And "<Case Source>" And "<Sales Org>"
    #When I Choose to Open Case and create safety questionnaire "No"
    #When I Choose to update site on the case with "<IP>"
    #When I Choose to Create Onsite Work Order SFM
    #When I Choose to Initiate SWO
    
    #SAP step to verify SWO
    
    Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "AutomationTechnicianUser"
    When I Choose to Search Work Order using global search box
    
   # When I Choose to Initiate Onsite SFM
    
    When I Choose to Change Installed Product "<IP>"
    When I Choose to add Labor and Parts
    When I Choose to Create IP Relocation Change "<Location>" And "<IP>" And "<Sales Org>"
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order
    Then I Choose to log out of the application
    When I Choose to enter credentials for "MasterDataAdmin"
    When I Choose "Work Order" from search list
    When I choose to update WO as Fixed
    When I Choose "case" from search list
		When I Choose to perform case closure using Business Complete SFM
		Then I Choose to verify Reason for incompletion "<Expected Result>"
    When I Choose to Search IP Change Request using global search box And Approve
    When I Choose "case" from search list
		When I Choose to perform case closure using Business Complete SFM
    Then I Choose to log out of the application

    Examples: 
	    | UserRole     | Product Type                                    | Event Type | Priority      | Case Origin | Case Source | Sales Org | IP       | Location | TestData | Expected Result |
      | AutomationAgentUser | 989604296451-Unknown Patient monitoring product | Incident   | 2-System Down | Phone       | Customer    | US93      | 88968707 | North Shore Health Systems  | 738148 | The following Installed Product change request(s) is/are pending closure before the case can be closed |

  @652406
  Scenario Outline: 652406: RT for Supplementary Services Consultancy for Clinical On-Site
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Service Request" on Installed Product
    When I Choose to Request a Quote SFM "Draft"
    When I Choose to Release Quote SFM
    When I Choose to Approve Quote
    When I Choose to Accept Quote
    When I Choose "case" from search list
    When I Choose to Create Clinical Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician>"
    When I Choose "Work Order" from search list
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order

    Examples: 
      | UserRole     | IP       | ServiceTechnician |
      | ServiceAgent | 88259004 | ServiceTechnician |

  @1148712
  Scenario Outline: 1148712: Distributor Incident with Parts
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I choose to search for Account using Search Criteria
      | Account Name        | contains | S&T Slovakia s.r.o. |
      | Account Owner Alias | equals   | dmigr               |
    When I choose to Create Contact from Account
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "Yes"
    When I Choose to Create "Distributor WO" Work Order SFM
    And I choose to verify WO updates
    # And I verify trackwise record updated correctly
    #Scenario2
    When I Choose "<IP2>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "Yes"
    When I Choose to Create "Distributor WO" Work Order SFM
    When I choose to request part in Hybris
      | 453566186571 | 453564235171 |
    Then I choose to verify ASO number on WO Page

    Examples: 
      | UserRole         | IP       | IP2      |
      | Distributor user | 83275202 | 59029166 |

  #FCO number should be unique, before importing the file, check for existing FCO and change FCO number accordingly.
  Scenario Outline: 436585:Test to verify the FCO Due diligence attempts records are created successfully
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to open Data Import Wizard "<UserRole>"
    When I Choose to Import FCO data to ServiceMax
    When I Choose to Verify FCO data import to ServiceMax
    When I Choose to Save and Update FCO Header Details
    When I Choose to Update FCO Record Details to FCO Header "CAL" File
    Then I Choose to open Data Import Wizard "<UserRole>"
    When I Choose to Import FCO CAL data to ServiceMax
    When I Choose to Verify FCO CAL data import to ServiceMax
    When I Choose to Create FCO Case
    When I Choose to Create FCO Work Orders
    When I Choose to Open Case And Verify FCO Work Orders
    When I Choose to Initiate FCO Work Order And Create Due Diligence
    When I Choose to Add Multiple Due Diligence And Verify Status
    Then I Choose to log out of the application

    Examples: 
      | UserRole          | Contract   | ServiceAgent | ServiceTechnician |
      | ServiceTechnician | CON0100457 | ServiceAgent | ServiceTechnician |

  @739601
  Scenario Outline: 739601:LCS4AB Complete and Cancel Case and Work Order
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
   
    #scenario1 and 2
    When I Choose "<IP1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
     When I Choose to Cancel Case and Verify status "No Error"
     When I Choose "<IP1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
     When I Choose to Cancel Case and Verify status "Error"
    When I Choose to Complete Case and Verify status "Fixed"
   
    #scenario3
     When I Choose "<IP1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
     When I Choose to Open Case and create safety questionnaire "No"
      When I Choose to Request a Quote SFM "Draft"
     When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Cancel Case and Verify status "Error"
    When I Choose to Complete Case and Verify status "Not Fixed"
    
    #scenario4
     When I Choose "<IP1>" from search list
     When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Education" on Installed Product
      When I Choose to Request a Quote SFM "Draft"
     When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Cancel Case and Verify status "Error"
    
    #scenario5
     When I Choose "<IP1>" from search list
     When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Education" on Installed Product
      When I Choose to Request a Quote SFM "Draft"
      When I Choose to Release Quote SFM
    When I Choose to Generate Quote PDF SFM
    When I Choose to Change Status to Sent "Sent"
    When I Choose to Reject Quote SFM
     When I Choose to Open Case From Service Quote Detail Page
    And I Choose to verify quotes on case in "Rejected" status
   When I Choose to Complete Case and Verify status "Fixed"
   
   #scenario6
    When I Choose "<IP1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
     When I Choose to Open Case and create safety questionnaire "Yes"
      When I Choose to Cancel Case and Verify status "Error"
      
#scenario7
 #		When I Choose "<IP1>" from search list
    #When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
     #When I Choose to Open Case and create safety questionnaire "No"
     #When I Choose to Create Onsite Work Order SFM
    #When I Choose to Initiate SWO
     #Then I Choose to Dispatch WO Using Service Board "Automation Service Technician"
     #Then I Choose to log out of the application
    #When I Choose to enter credentials for "<ServiceTechnician>"
    #When I Choose "Work Order" from search list
    #When I Choose to Initiate Onsite SFM
    #When I Choose to add Labor and Parts
    #When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    #And I choose to Debrief work oder and follow up
    #And I choose to complete the Work order
    #Then I Choose to log out of the application
     #When I Choose to enter credentials for "<MasterDataAdmin>"
    #When I Choose "Work Order" from search list
    #When I choose to update WO as Fixed
    #When I Choose "case" from search list
#		When I Choose to perform case closure using Business Complete SFM

    Examples: 
      | UserRole     | ServiceTechnician | IP1 |
      | ServiceAgent | ServiceTechnician | 62794133 |

  @711568
  Scenario: 711568: - 1.1.1 Test Script OQ – QRXXXXXX : Verify LCS4I: Service Requests with no Installed Product for Sales Support
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "ServiceAgent"
    When I choose to search for Account using Search Criteria
      | Country       | contains | CA                     |
      | Account Group | equals   |                   0001 |
      | Account Name  | contains | MACKENZIE HEALTH - MES |
    When I choose to Create Contact from Account
    When I Choose to create Case on Unknown Product
      | Internal Support | CS Internal | 5-Scheduled Activity | Test LCS4I | Pre-sales | Patient name is John Doe with MRN 12345. |
    Then I choose to verify details in Case Details page for TC "711568"
    Then I choose to create New Commitment from Case
      | ServiceAgent | Call back customer for progress update in 1 hour | 1 |
    Then I choose to edit Case Details
    When I Choose to Create Onsite Work Order SFM for "1" hours
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceTechnician"
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    And I choose to Debrief work oder and follow up
    And I choose to complete the Work order
    Then I Choose to log out of the application

  @571972
  Scenario: 571972:- Schedule and Report Non-Customer Interaction Time
    Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "ITOpAdmin"
    #When I Choose to Search "ServiceAgent" using global search box
    #Then I choose to click on User profile
    #Then I choose to assign OneEMS Role of "Tier 1"
    #Then I choose to assign Permission Set to user
    #| First Name | contains | Automation Service | ESMX Non Customer Event |
    #Then I Choose to log out of the application
    #	Testing on ServiceMax web-application:
    When I Choose to enter credentials for "AgentUser"
    Then I choose to create Non WO Events
      | ServiceTechnician | Administration | Confirmed | No  |
      | ServiceTechnician | Administration | Tentative | No  |
      | ServiceTechnician | Administration | Confirmed | Yes |
    Then I choose to verify the creation of the Non WO Events from Calendar
      | Subject     | contains | Administration     |
      | Assigned To | contains | Automation Service |
      | Start       | equals   | SYSDATE            |
    Then I Choose to log out of the application

  @645138
  Scenario Outline: 645138:LCS4R: T&M Quotation - Covered by contract and Price agreements
    #Precondition - Case1
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search "<ActiveContract>" using global search box
    When I Choose to Open "<ActiveContract>" Service Maintenance Contract
    When I choose to 'Update Part Discount' to "10" percent
    When I choose to 'Labor Discount' to "10" percent
    Then I Choose to log out of the application
    When I Choose to enter credentials for "Quote Admin"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Request a Quote SFM "Draft"
    #When I Choose to verify the value of "Total Covered by Contract" in Service Quotes Page
    #When I Choose to verify the value of "Total price before Discount and VAT" in Service Quotes Page
    #When I Choose to verify the value of "Total VAT 1 and VAT 2 and VAT 1 rate and VAT 2 rate" in Service Quotes Page
    #When I Choose to verify the value of "Total Discount percentage and Total discount" in Service Quotes Page
    #When I Choose to verify the value of "Total Net Price" in Service Quotes Page
    #When I Choose to verify the value of "Total Gross Price" in Service Quotes Page
    When I Choose to Release Quote SFM
    When I Choose to Approve Quote
    When I Choose to Accept Quote
    When I Choose to Generate Quote PDF SFM
    When I Choose "case" from search list
    When I Choose to Verify Quote PDF is created or not
    Then I Choose to log out of the application
    #SAP steps for DMR verification - TBD
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole2>"
    Then I Choose to verify profile for Logged on user "<UserRole2>"
    And I choose too verify profile Permission Sets
    When I Choose to Search "<ActiveContract>" using global search box
    When I Choose to Open "<ActiveContract>" Service Maintenance Contract
    When I choose to 'Update Part Discount' to "20" percent
    When I choose to 'Labor Discount' to "20" percent
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole1>"
    When I Choose "quote" from search list
    #When I Choose to Release Quote SFM
    #When I Choose to Approve Quote
    #When I Choose to Accept Quote
    When I Choose to Amend Quote
    When I Choose to 'Reset Contract Discount'
    When I Choose to check 'Get Price and Vat'
    When I Choose to 'Pull Discounts From Contract'
    # When I Choose to select the updated 'Part & Labor' & 'Merge into a Service'	and verify Error message
    When I Choose to Uncheck All the line items and validate 'Negative Manual Discount'
    When I Choose to 'Reduce the Discount' and vaidate 'Quote save' message

    #Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<UserRole1>"
    #When I Choose to Launch new Window and login as "<UserRole2>"
    #When I Choose to enter credentials for "<UserRole2>"
    #When I Choose to Search "<ActiveContract>" using global search box
    #When I Choose to Open "<ActiveContract>" Service Maintenance Contract
    #When I choose to 'Update Part Discount' to "10" percent
    Examples: 
      | UserRole1    | UserRole2       | IP       | submitPSE | ActiveContract | InActiveContract |
      | ServiceAgent | MasterDataAdmin | 81333451 | No        | CON0378169     | CON0378170       |

  @RegressionTest_3_TC440108
  Scenario: 440108 - Scenario28 - Parts and Labor processing with billable flag ON/OFF - RSM with mixed entitlement.
    #	Pre-conditions:
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "MasterDataAdmin"
    When I choose to work with "INSTALLED_PRODUCT" "88307741"
    When I choose to work with "NORMAL_SPAREPART" "452230032863"
    When I choose to work with "NON_NORMAL_SPAREPART" "989000001616"
    ##	Include the below step if Case and Quote have already been created
    #And I choose to work with "CASE_NUMBER" "0116436177"
    ##	Include the below steps to create Contract Header, Service Contract, Parts Discount and RSM.
    #	Then I choose to edit Product Warranty details
    #	Then I choose to Create New Contract Header
    #	Then I choose to Create New Service Contract from Contract Header
    #	Then I choose to Edit Coverage of Service Contract
    #	Then I choose to add Parts Discount for Product Line of "010 - Normal spareparts"
    #	Then I choose to Create Risk Sharing Model
    #	Then I choose to Manage Risk Sharing Models
    ##	Include the below steps if Service Contract, Contract Header and RSM have already been created but details were not captured.
    When I Choose to Search "<InstalledProduct>" using global search box
    #Then I choose to open and verify details on Installed Product page
    Then I choose to get the following numbers from IP page
      | Service Contract   |
      | Risk Sharing Model |
    ##	Include the following steps if case and quote need to be created.
    When I Choose to Search "<InstalledProduct>" using global search box
    #Then I choose to open and verify details on Installed Product page
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Request a Quote SFM "Draft"
    When I Choose to Release Quote SFM
    When I Choose to Accept Quote
    Then I Choose to log out of the application
    #	Test-steps:
    When I Choose to enter credentials for "ServiceAgent"
    #Then I choose to verify user profile and permission set
    When I Choose to Search "<Case>" using global search box
    #Then I choose to verify that the following SFMs are enabled in Case Details screen
    #| Request a Quote                      |
    #| Create Remote Service Work Order     |
    #| Create Onsite Work Order             |
    #| Create Subcontractor Work Order      |
    #| Create Material Only Work Order      |
    #| Create Work Order(Remote Clinical)   |
    #| Create Work Order(Onsite Clinical)   |
    #| Create Local Bench Work Order        |
    #| Create Cross Border Bench Work Order |
    When I choose to select Create Local Bench WorkOrder
    #Then I choose to verify Work Order Details
    When I Choose to Search "<Case>" using global search box
    Then I choose to verify details in Case Details page for TC "440108"
    Then I choose to Create Work Order of type "RemoteClinical"
    #Then I choose to verify Work Order Details
    When I Choose to Search "<Case>" using global search box
    Then I choose to verify details in Case Details page for TC "440108"
    When I Choose to Create Onsite Work Order SFM for "2" hours
    #Then I choose to verify Work Order Details
    When I Choose to Search "<RiskSharingModel>" using global search box
    #Then I choose to verify details in Risk Sharing Model screen
    When I Choose to Search "OnsiteService" Work Order using global search box
    When I Choose to Initiate SWO
    Then I Choose to click on Parts Ordering SFM for product number "NORMAL_SPAREPART"
    Then I Choose to log out of the application
    #	<Enter SAP steps here>
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
      | TCode |
      | va03  |
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
    When I Choose to close SAP Application
    #	Post-SAP Steps:
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "ServiceAgent"
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify that Line Status is "Shipped" for "NORMAL_SPAREPART"
    When I Choose to click on Parts Ordering SFM for product number "NON_NORMAL_SPAREPART"
    Then I Choose to log out of the application
    #	<Enter SAP steps here>
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
      | TCode |
      | va03  |
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
    When I Choose to close SAP Application
    #	Post-SAP Steps:
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "ServiceAgent"
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify that Line Status is "Shipped" for "NON_NORMAL_SPAREPART"
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceUser"
    #Then I choose to verify user profile and permission set
    When I Choose to Search "OnsiteService" Work Order using global search box
    When I click the Intiate Travel
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to Receive Parts
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to click on Open Parts Returnable
    When I Choose to Search "<RiskSharingModel>" using global search box
    Then I choose to verify details in RSM page
    When I Choose to Search "OnsiteService" Work Order using global search box
    When I CHoose to Debrief and Follow up and "Create Follow up Activity"
    When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    When I Choose to Complete the WorkOrder SFM
    When I Choose to Search "<RiskSharingModel>" using global search box
    Then I choose to verify details in RSM page
    #	Post-Batch Job Steps:
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify status of Work Order is "Fixed"
    Then I choose to verify details in RSM page
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify details on the Labor Work Detail Line
      | Is Billable                     | Checked                                                               |
      | Billable Work Order Reason      | Confirmed hours are exceeding the balance on <RiskSharingModelNumber> |
      | RSM Decision Integration Status | Sent to Decisions Error                                               |
      | RSM Decision Error Message      | Confirmed hours are exceeding the balance on <RiskSharingModelNumber> |
      | Associate Coverage ID           | <RiskSharingModelNumber>                                              |
      | Associate Coverage Type         | Risk Sharing Model                                                    |
      | SAP Accounting Indicator        |                                                                    53 |
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify details in the Parts Order Line screen for "NORMAL_SPAREPART"
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify details in the Parts Order Line screen for "NON_NORMAL_SPAREPART"
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify details on the Labor Work Detail Line
      | Associate Coverage ID    | <RiskSharingModelNumber> |
      | Associate Coverage Type  | Risk Sharing Model       |
      | SAP Accounting Indicator |                       53 |
    Then I Choose to log out of the application
    When I Choose to enter credentials for "MasterDataAdmin"
    #Then I choose to verify user profile and permission set
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to click on Change Order Status to In Process SFM
    Then I choose to verify details on the Labor Work Detail Line
      | Is Billable                | Checked                                                               |
      | Billable Work Order Reason | Confirmed hours are exceeding the balance on <RiskSharingModelNumber> |
    When I Choose to Search "<RiskSharingModel>" using global search box
    Then I choose to verify details in RSM page
    Then I choose to Manage Risk Sharing Model
    When I Choose to Search "OnsiteService" Work Order using global search box
    When I Choose to Complete the WorkOrder SFM
    #	Post-Batch Job Steps:
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify status of Work Order is "Fixed"
    When I Choose to Search "<RiskSharingModel>" using global search box
    Then I choose to verify details in RSM page
    When I Choose to Search "OnsiteService" Work Order using global search box
    Then I choose to verify details on the Labor Work Detail Line
      | Is Billable                     | Not Checked                |
      | Billable Work Order Reason      |                            |
      | Decision Integration Status     | Sent to Decisions Success  |
      | RSM Decision Integration Status | Final Confirmation Success |
      | RSM Decision Error Message      |                            |
      | Associate Coverage ID           | <RiskSharingModelNumber>   |
      | Associate Coverage Type         | Risk Sharing Model         |
      | SAP Accounting Indicator        |                         53 |
    When I Choose to Search "<Case>" using global search box
    Then I Choose to log out of the application

  @440364
  Scenario Outline: 440364: Test to verify that bench repair status is tracked from work order creation to work order closure when the work order is entitled
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole1>"
    Then I Choose to verify profile for Logged on user "<UserRole1>"
    And I choose too verify profile Permission Sets
    Then I Choose to Create Bench Receipt
    When I Choose to verify Bench Repair Status "Equipment Received"
    When I Choose to capture Bench Status Tracker Number
    When I Choose to Update Tracking/Courier number SFM
    When I Choose to capture Case Number
    When I Choose to Navigate to Bench Status Tracker Page from Case Details Page
    When I Choose to verify Bench Repair Status from Bench Status Tracker Page "Awaiting Decontamination"
    When I Choose to verify Tracking and Courier Number from Case Details Page
    When I Choose to Verify the Equipment Received Status Time
    When I Choose to complete Decontamination
    When I choose to verify Decontamination Complete Status Time
    When I choose to Update Bench Repair Case "<InstalledProduct>" and "<ContactId>"
    When I choose to answer the Safety Questions "1"
    When I choose to Enable Request Bench Assessment
    When I choose to select Create Local Bench WorkOrder
    When I Choose to capture Work Order Number "WO1"
    When I Choose to verify Work Order Bench status as "Ready For Diagnosis"
    #When I Choose to verify Bench Status Tracker No in Work Order Page
    When I Choose to Navigate to Bench Status Tracker Page from Work Order Page
    When I Choose to verify Bench Repair Status from Bench Status Tracker Page "Ready For Diagnosis"
    #When I Choose to verify Ready for Diagnosis Status Time with  Last Modified Status Time
    #When I Choose to verify Decontamination Complete Age Population
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to Initiate Bench Repair
    When I Choose to verify Work Order Bench status as "Engineer Diagnosing/Repairing"
    When I Choose to Navigate to Bench Status Tracker Page from Work Order Page
    When I Choose to verify Bench Repair Status from Bench Status Tracker Page "Engineer Diagnosing/Repairing"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to add Labor and Parts
    When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    When I CHoose to Debrief and Follow up and "Create Follow up Activity"
    When I Choose to capture Work Order Number "WO2"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    # Step17
    When I Choose to verify Work Order Bench status as "Follow up work Identified"
    When I Choose to Navigate to Bench Status Tracker Page from Work Order Page
    When I Choose to verify Bench Repair Status from Bench Status Tracker Page "Follow up work Identified"
    When I Choose to verify the 'Follow up work Identified Status Time' is populated as to "Last Modified Status Time"
    When I Choose to verify the 'Ready for Diagnosis Status Time' is updated to 'System Time'.
    When I Choose to verify 'Engineer Diagnosing/Repairing Age'
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    And I choose to complete the Work order
    When I Choose to verify Work Order Bench status as "Follow up work Identified"
    Then I Choose to log out of the application

    Examples: 
      | UserRole1    | InstalledProduct | ContactId       | UserRole2         |
      | ServiceAgent |         74211520 | Dr Daniel Saura | ServiceTechnician |

@436579
  Scenario Outline: 436579:Scenario 38 - Test to verify that Contract Admin is able to view auto renewal of contracts automated without any manual intervention
    #Step1
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole1>"
    Then I Choose to verify profile for Logged on user "<UserRole1>"
    And I choose too verify profile Permission Sets
    When I Choose to Search "<OriginalContract1>" using global search box
    When I Choose to Open "<OriginalContract1>" Service Maintenance Contract
    When I Choose to verify "Customer Purchase Order Number" polulation
    When I Choose to verify "Account Promo Code" polulation
    When I Choose to verify "Freeze Auto PM creation" polulation
    When I Choose to verify "Customer Facing Notes" polulation
    When I Choose to verify "Customer Experience Note" polulation
    When I Choose to verify "Billing Plan Lines" polulation
    When I Choose to verify "Covered Products" polulation
    When I Choose to verify available options for Activation Type
    When I CHoose to verify "Renewal Type" is populated as "Manual Renewal"
    When I Choose to update "Activation Type" field as "Manual Activation"
    When I Choose to update "Renewal Term" field as "12"
    When I Choose to update "Renewal Date" field as "Today Date"
    When I Choose to Renew Service Contract
    When I CHoose to verify "Renewed from" is populated as "<OriginalContract1>"
    When I Choose to verify "Billing Plan Lines" polulation
    When I Choose to Open Biling Line and Update "Start and End Date"
    When I CHoose to verify "Activation Type" is populated as "Manual Activation"
    When I CHoose to verify "Renewal Term" is populated as "12"
    When I CHoose to verify "RenewalDate HelperText" is populated as "Date on which the contract will be renewed"
    When I Choose to Verify 'Auto Renewal Step' field present or not
    When I Choose to Verify only Covered Product "<IP1>" from "<OriginalContract1>" is Covered in Renewed Contract
    When I Choose 'Send to SAP' SFM
    When I CHoose to verify "SAP Integration Status" is populated as "Sent to SAP Success"
    When I Choose to 'Activate Contract'SFM
    When I CHoose to verify "Active Flag" is populated as "Checked"
    When I Choose to update "Contract Start Date and End Date" field as "Today plus 24 and minus 12 month"
    When I Choose to Search "<OriginalContract1>" using global search box
    When I Choose to Open "<OriginalContract1>" Service Maintenance Contract
    When I Choose to Open 'Renewal History' and verify Renewed Contract Number "ManualRenual_RenewedContract" is visible in the report
    When I Choose to Search "<OriginalContract2>" using global search box
    When I Choose to Open "<OriginalContract2>" Service Maintenance Contract
    When I Choose to verify "Customer Purchase Order Number" polulation
    When I Choose to verify "Account Promo Code" polulation
    When I Choose to verify "Freeze Auto PM creation" polulation
    When I Choose to verify "Customer Facing Notes" polulation
    When I Choose to verify "Customer Experience Note" polulation
    When I Choose to verify "Billing Plan Lines" polulation
    When I Choose to verify "Covered Products" polulation
    When I Choose to verify available options for Activation Type
    When I CHoose to verify "Renewal Type" is populated as "Auto Renewal"
    When I Choose to update "Activation Type" field as "Auto Activation"
    When I Choose to update "Renewal Term" field as "12"
    When I Choose to update "Renewal Date" field as "Today Date"
    #[Script Will be Pasued for 10 minutes]
    #When I Choose to wait for "Auto Renewal" batch to complete
    When I Choose to Open 'Renewal History' and verify and Capture the renewed number "AutoRenual_RenewedContract"
    When I Choose to Search "AutoRenual_RenewedContract" using global search box
    When I Choose to Open "AutoRenual_RenewedContract" Service Maintenance Contract
    When I CHoose to verify "Renewed from" is populated as "<OriginalContract2>"
    When I Choose to verify "Billing Plan Lines" polulation
    When I Choose to Open Biling Line and Update "Start and End Date"
    When I CHoose to verify "Activation Type" is populated as "Auto Activation"
    When I CHoose to verify "Renewal Term" is populated as "12"
    When I CHoose to verify "RenewalDate HelperText" is populated as "Date on which the contract will be renewed"
    When I Choose to Verify only Covered Product "<IP1>" from "<OriginalContract2>" is Covered in Renewed Contract
    #[Script Will Be paused for 10 Minutes]
    #When I Choose to wait for "Send to SAP" batch to complete
    #[Script Will Be paused for 10 Minutes]
    #When I Choose to wait for "Activation" batch to complete
    When I CHoose to verify "Active Flag" is populated as "Checked"
    Then I Choose to log out of the application

    Examples: 
      | UserRole1       | OriginalContract1 | IP1      | OriginalContract2 |
      | MasterDataAdmin | CON0026556        | 37107433 | CON0026554        |
