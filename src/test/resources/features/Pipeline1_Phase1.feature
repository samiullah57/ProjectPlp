Feature: Phase1 Pipeline1

  @439692
  Scenario Outline: 439692: OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "CustomAgent"
    And I Choose to navigate to home page
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details "Corrective Maintenance"
    And I choose to click on option "Safety Questions"
    And I choose enter questionery Answers
    And I Verify TW record is "Created"
    And I choose to verify Corrective Maint- Remote is green
    And I choose to click on option "Route Case"
    ## And I choose to select Queue and Dispatch
    And I choose to click on logout	
    When I Choose to enter credentials for "CustomRSE"
    And I choose to search the "<Asset>"
    And I Choose to open the case Created
    And I choose to click on option "Accept"
    And I choose to enter T2Activites
    And I Choose to open the case Created
    And I Choose to Choose to verify Case Activity Picklist
    And I Choose to open the case Created
    And I Choose to click on NewRemoteLabour
    ##And I choose to click on option "Close Case"
    And I Choose to enter Close Details
    And I choose to click on logout
    Examples: 
      | Asset| RecordType |
      | 68031601 | Case - New |
      
 @Test
Scenario: 439692: Test Regression – Test to verify list of links in webpage
	Given I launch demo crm application successfully
#	Given I Choose to launche to SAP application
#	When User enters T Code in SAP application as"<Tcode>"
#	When I choose to enter SWO Number
#	When I choose to close SAP Application	
	
@Test2
Scenario: 439692: Test Regression – Test to verify list of links in webpage
	Given I launch demo asx application successfully for to test webtable
	
  @438545
  Scenario Outline: 438545: Determination of Sales Org and Service Plant for distributor type 37 sales Order
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enters SAP Order nubmer "<salesorder>"
    And I choose to click on Header details icon
    And I choose to Verify the field sales area data with values "<SA1>", "<SA2>" and "<SA3>"
    And I choose to verify the field customer group "<Customer Group>" and SalesOffice under Sales tab are populated
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to verify that Business Area is populated
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode2>"
    And I choose to enter the Table name"<TableName>"
    And I choose to enter the salesorg "<SA1>" , DistrChannel "<SA2>" and Customergrp "<CG>"
    And I choose to click on execute icon
    And I choose to Verify there is a column Business Area and Customer Group
    And I choose to select the row and click on choose icon "<Tablerow>"
    And I choose to Verify the value of Plant Service and Service Org
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode3>"
    And I choose to enter tablename "<Tablename2>" in general table display page
    And I choose to enter Document Number "<salesorder>"
    And I choose to click on execute icon
    And I choose to verify Plantservice and serviceorg in this general Table with "<SA2>"
    When I choose to close SAP Application

    Examples: 
      | system | Tcode | salesorder | SA1  | SA2 | SA3 | Customer Group | Tcode2 | TableName | Tablename2 | CG | partnerTab         | tabName3       | BA | Tcode3  | Tablerow    |
      | MQ3    | VA03  | 6600502471 | DX96 | DX  | MS  | 37 Distributor | /nse16 | ZUSERVICE | ZUENRICH   | 37 | Account assignment | partnerTabVA43 | RO | /nse16n | ZUService_1 |

  #1. User1 (For account creation): With profile “Custom – ESMX EIM” and with the permission set “ESMX EIM Data specialist-Customer" - Updated to Permission set group - 'Customer Data Specialist'.
  #2. User2 (For Technician creation): With profile “Custom – ESMX EIM” and with the permission set “ESMX EIM Data specialist-HR - Updated to Permission set group - 'HR Data Specialist'.
  #3. User3 (For vendor creation): With profile “Custom – ESMX EIM” and with the permission set “ESMX EIM Data specialist-Vendor" - Updated to Permission set group - 'Vendor Data Specialist'.
  #5. User5 (No permissions to create Account/Technician/Vendor): With profile “Custom – ESMX EIM” without any permission set assigned
  #6. User with profile ‘Custom - ESMX Custom Agent'
  #7. Access to SAP MP1 system.
  @441842
  Scenario Outline: 441842:Create Account, Technician, Vendor (EIM Management) and Contact
    Given I launch ServiceMax application successfully
    And I Choose to enter credentials for "<EIMUser>"
    Then I Choose to verify profile for Logged on user "<EIMUser>"
    And I click on Accounts Tab
    Then I Choose to verify that New Button is not displayed
    And I choose to click on All Tabs
    And I click on object "<Object Name>"
    Then I Choose to verify that New Button is not displayed
    And I choose to click on All Tabs
    And I click on object "<Object Name2>"
    Then I Choose to verify that New Button is not displayed
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<EIMCustomer>"
    Then I Choose to verify profile for Logged on user "<EIMCustomer>"
    And I click on Accounts Tab
    And I choose to create new Account
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<EIMVendor>"
    # Then I Choose to verify profile for Logged on user "<EIMVendor>"
    And I choose to click on All Tabs
    And I choose to create "Vendor" record
    Then I Choose to log out of the application
    And I Choose to enter credentials for "<ServiceAgent>"
    #Then I Choose to verify profile for Logged on user "<ServiceAgent>"
    When I choose to search for Account using Search Criteria
      | Account Name | contains | CELTA |
    When I choose to Create Contact from Account
    Then I choose to verify the Integration status "<Integration Status>" and SAP external ID
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    Then I choose to verify contact details created in SMAX
    When I choose to close SAP Application

    Examples: 
      | EIMUser | Object Name | Object Name2 | EIMCustomer | EIMHR | EIMVendor | ServiceAgent | Integration Status  | Tcode  |
      | EIMUser | Technician  | Vendors      | EIMCustomer | EIMHR | EIMVendor | ServiceAgent | Sent to SAP Success | /nvap3 |

  @438546 @Srini
  Scenario Outline: 438546 : Determination of Sales Org and Service Plant for DX indent order other than 37 customer Group
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enters SAP Order nubmer "<salesorder>"
    And I choose to click on Header details icon
    And I choose to Verify the field sales area data with values "<SA1>", "<SA2>" and "<SA3>"
    And I choose to verify the field customer group "<Customer Group>" and SalesOffice under Sales tab are populated
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to verify that Business Area is populated
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode2>"
    And I choose to enter the Table name"<TableName>"
    And I choose to enter the salesorg "<SA1>" , DistrChannel "<SA2>" and Customergrp "<CG>"
    And I choose to click on execute icon
    And I choose to Verify there is a column Business Area and Customer Group
    And I choose to select the row and click on choose icon "<Tablerow>"
    And I choose to Verify the value of Plant Service and Service Org
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode3>"
    And I choose to enter tablename "<Tablename2>" in general table display page
    And I choose to enter Document Number "<salesorder>"
    And I choose to click on execute icon
    And I choose to verify Plantservice and serviceorg in this general Table with "<SA1>"
    When I choose to close SAP Application

    Examples: 
      | system | Tcode | salesorder | SA1  | SA2 | SA3 | Customer Group | Tcode2 | TableName | Tablename2 | CG | partnerTab         | tabName3       | BA | Tcode3  | Tablerow  |
      | MQ3    | VA03  | 6600503139 | DX96 | DX  | MS  | 37 Distributor | /nse16 | ZUSERVICE | ZUENRICH   | 04 | Account assignment | partnerTabVA43 | AE | /nse16n | ZUService |

  @453845
  Scenario Outline: 453845: Mass data upload using ‘Informatica’
    Given I launch Informatica application successfully
    When I Choose to execute accounts workflow
    When I Choose to execute contact workflow
    When I Choose to execute Account Partner workflow
    Given I Choose to enter credentials for "<UserRole>"
    When I Choose to access accounts report
    Then I Choose to validate accounts report

    #When I Choose to access contact report
    #Then I Choose to validate contact report
    #When I Choose to access account partner report
    #    Then I Choose to validate account partner report
    #	When I Choose to Search "<case>" using global search box
    Examples: 
      | UserRole        | case       | Request a Quote |
      | MasterDataAdmin | 0118593251 | Request a Quote |

  @438547 @Srini
  Scenario Outline: 438547 : Determination of Sales Org and Service Plant for an MP1 country
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enters SAP Order nubmer "<salesorder>"
    And I choose to click on Header details icon
    And I choose to Verify the field sales area data with values "<SA1>", "<SA2>" and "<SA3>"
    And I choose to verify the field customer group
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to verify that Business Area should be null
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode2>"
    And I choose to enter the Table name"<TableName>"
    And I choose to enter the salesorg "<SA1>" , DistrChannel "<SA2>" and Customergrp "<CG>"
    And I choose to click on execute icon
    And I choose to Verify there is a column Business Area and Customer Group
    And I choose to select the row and click on choose icon "<Tablerow>"
    And I choose to Verify the value of Plant Service and Service Org
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode3>"
    And I choose to enter tablename "<Tablename2>" in general table display page
    And I choose to enter Document Number "<salesorder>"
    And I choose to click on execute icon
    And I choose to verify Plantservice and serviceorg in this general Table with "<SA2>"
    When I choose to close SAP Application

    Examples: 
      | system | Tcode | salesorder | SA1  | SA2 | SA3 | Tcode2 | TableName | Tablename2 | CG | partnerTab         | tabName3       | BA | Tcode3  | Tablerow    |
      | MQ3    | VA03  | 6600398554 | CN90 | CN  | MS  | /nse16 | ZUSERVICE | ZUENRICH   |    | Account assignment | partnerTabVA43 | RO | /nse16n | ZUService_1 |

  @436654
  Scenario Outline: 436654: Test Script SIT – QRXXXXXX : US259108_Quote Approval Process verification
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "Quote Admin"
    When I Choose "<IP1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Request a Quote SFM "Draft"
    #When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Release Quote SFM
    When I Choose to Approve Quote
    When I Choose to Accept Quote
    Then I Choose to log out of the application

    Examples: 
      | UserRoleAgent | IP1      |
      | ServiceAgent  | 62794133 |

  @438544
  Scenario Outline: 438544:Indent Local Sales Order
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<case>" using global search box
    And I choose to select the IP
    And I choose to select Installation product
    And I choose to select view customer Information
    Then I choose to verify Sales order Number"<salesOrder>"
    And I choose to select System Information
    Then I choose to verify Salesdocument ID"<salesDoc>"
    When I Choose to Search "<case>" using global search box
    And I choose to select the IP
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I choose to verify the swo and Order status
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    And I choose Enter SWO created in above step
    And I choose to select tab"<operationTab>"and"<tableName>"
    Then I choose to verify sales document"<salesDoc>"
    When I choose to close SAP Application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<agentRole>"
    When I Choose "<ip>" from search list
    And I choose to select check sales types
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    And I choose to get the URL
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to access above URL
    When I Choose to Create Onsite Work Order with Indenet Installation
    Then I choose to verify the Error
    Then I choose to enter"<salesDoc>"and save
    When I Choose to Initiate SWO
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    And I choose Enter SWO created in above step
    And I choose to select tab"<operationTab>"and"<tableName>"
    Then I choose to verify sales document"<salesDoc>"
    When I choose to close SAP Application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "<ip1>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order with Indent and"<salesDoc>"
    Then I choose to verify the Error
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | case       | salesOrder | salesDoc         | Tcode | tableName | operationTab | priorityType  | ip       | agentRole    | EventType    | SubEventType | EvenType1 | ip1      |
      | MasterDataAdmin | 0118606320 | 6600554599 | 6600554599010010 | iw33  | operation | Operations   | Critical Need | 96008937 | ServiceAgent | Installation | Installation | Incident  | 96008937 |

  @571972
  Scenario Outline: 571972: Schedule and Report Non-Customer Interaction Time
    Given I launch ServiceMax application successfully
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

    Examples: 
      |  |
      |  |

  @438552
  Scenario Outline: 438552:Automation Initial Registration of 3rd party devices based on a load file.
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    And I choose to Enter Functioanl Location"<function>"
    Then I choose to upload the PC"<workcenter>"
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to select above created IP
    And I choose to select tab"<structureTab>"and"<tableName>"
    Then I choose to verify status value as"<status>"
    Then I choose to verify child record
    When I choose to close SAP Application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #Then I Choose to verify profile for Logged on user "<UserRole>"
    Then I choose to verify the equipment created in SAP
    And I choose to select the IP
    Then I choose to verify Ip child records
    Then I choose to update Vendor details and Save
    Then I Choose to log out of the application

    Examples: 
      | Tcode | function        | workcenter | UserRole        | Tcode1 | structureTab | tableName       | status |
      | ZEQUP | PL002856-005-01 | PL_GEN     | MasterDataAdmin | IE03   | Structure    | CreateEquipment | OPER   |

  @438551
  Scenario Outline: 438551: Installed Product updated in ServiceMax and verify the change reflects in SAP within 15 Minutes
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<IP>" using global search box
    And I choose to select the IP
    Then I choose to update"<status>""<location>"and"<account>"
    And I choose to select view customer Information
    Then I choose to get Account Number
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    And I choose to Enter Equipment number"<IP>"
    Then I choose to verify status value as"<status>"
    And I choose to select tab"<structureTab>"and"<tableName>"
    Then I choose to verify Functional location
    And I choose to select tab"<salesTab>"and"<tableName>"
    Then I choose to verify Sold TO and Ship To values
    When I choose to close SAP Application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    # Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<IP>" using global search box
    And I choose to select the IP
    Then I choose to delete Functional location and Save
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    And I choose to Enter Equipment number"<IP>"
    And I choose to select tab"<structureTab>"and"<tableName>"
    Then I choose to verify Functional as null
    When I choose to close SAP Application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<IP>" using global search box
    And I choose to select the IP
    Then I choose to add Functional location and Save
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    And I choose to Enter Equipment number"<IP>"
    And I choose to select tab"<structureTab>"and"<tableName>"
    Then I choose to verify Functional location
    When I choose to close SAP Application

    Examples: 
      | UserRole        | IP       | status           | location   | account    | Tcode | structureTab | tableName       | salesTab               |
      | MasterDataAdmin | 33271378 | AVLB - Available | 0009486701 | 0009486701 | IE03  | Structure    | CreateEquipment | Sales and Distribution |
