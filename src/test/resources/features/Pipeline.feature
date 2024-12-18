Feature: Regression Test Case for SMax and SAP

  @439692
  Scenario Outline: 
    439692: OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "CustomAgent"
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details
    And I choose to click on option "Safety Questions"
    And I choose enter questionery Answers
    And I Verify TW record is Created
    And I choose to verify Corrective Maint- Remote is green
    And I choose to click on option "Route Case"
    And I choose to select Queue and Dispatch
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
    And I choose to click on option "Close Case"
    And I Choose to enter Close Details
    Then I Choose to log out of the application

    Examples: 
      | Asset    | RecordType |
      | 35921693 | Case - New |

  #1. User1 (For account creation): With profile “Custom – ESMX EIM” and with the permission set “ESMX EIM Data specialist-Customer" - Updated to Permission set group - 'Customer Data Specialist'.
  #2. User2 (For Technician creation): With profile “Custom – ESMX EIM” and with the permission set “ESMX EIM Data specialist-HR - Updated to Permission set group - 'HR Data Specialist'.
  #3. User3 (For vendor creation): With profile “Custom – ESMX EIM” and with the permission set “ESMX EIM Data specialist-Vendor" - Updated to Permission set group - 'Vendor Data Specialist'.
  #5. User5 (No permissions to create Account/Technician/Vendor): With profile “Custom – ESMX EIM” without any permission set assigned
  #6. User with profile ‘Custom - ESMX Custom Agent'
  #7. Access to SAP MP1 system.
  @441842
  Scenario Outline: 
    441842:Create Account, Technician, Vendor (EIM Management) and Contact

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
      | EIMUser | Object Name | Object Name2 | EIMCustomer | EIMHR | EIMVendor | ServiceAgent | Integration Status  | Tcode |
      | EIMUser | Technician  | Vendors      | EIMCustomer | EIMHR | EIMVendor | ServiceAgent | Sent to SAP Success | /nvap3 |

  
  @739601
  Scenario Outline: 739601:LCS4AB Complete and Cancel Case and Work Order
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<UserRole>"
    When I Choose to Verify whether a record with Installed Product is displayed
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Cancel Case and Verify status "Error"
    When I Choose to Complete Case and Verify status "Fixed"
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<UserRole>"
    When I Choose to Verify whether a record with Installed Product is displayed
    When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Education" on Installed Product
    When I Choose to Request a Quote SFM "Draft"
     #When I Choose to open the Quote created from Case
    When I Choose to Release Quote SFM
    When I Choose to Generate Quote PDF SFM
    When I Choose to Change Status to Sent "Sent"
    When I Choose to Reject Quote SFM
    When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Cancel Case and Verify status "Error"
    When I Choose to Complete Case and Verify status "Fixed"
    When I Choose to Search "<Contract>" using global search box
    When I Choose to Open "<Contract>" Service Maintenance Contract Detail page and verify SAP External ID for "<ServiceAgent>"
    When I Choose to Verify whether a record with Installed Product is displayed
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<ServiceTechnician>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<Technician>"
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to open Work Order Line items and save record
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician | Technician            |
      | ServiceAgent | CON0100457 | ServiceAgent | Automation Technician User | AutomationTechnicianUser |

  @438545 @Srini
  Scenario Outline: 
    438545: Determination of Sales Org and Service Plant for distributor type 37 sales Order

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

  @438547 @Srini
  Scenario Outline: 
    438547 : Determination of Sales Org and Service Plant for an MP1 country

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

  @438546 @Srini
  Scenario Outline: 
    438546 : Determination of Sales Org and Service Plant for DX indent order other than 37 customer Group

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
    When I Choose to Search "<ip>" using global search box
    And I choose to select the IP
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
    And I choose to create new case with"<EvenType1>"and"<priorityType>"and"<ip1>" with contact "Sangeetha B P"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order with Indent and"<salesDoc>"
    Then I choose to verify the Error
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | case       | salesOrder | salesDoc         | Tcode | tableName | operationTab | priorityType  | ip       | agentRole    | EventType    | SubEventType | EvenType1 | ip1      |
      | MasterDataAdmin | 0116621507 | 6600508719 | 6600508719010010 | iw33  | operation | Operations   | Critical Need | 88783524 | ServiceAgent | Installation | Installation | Incident  | 36587375 |

  @438551
  Scenario Outline: 
    438551: Installed Product updated in ServiceMax and verify the change reflects in SAP within 15 Minutes

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to verify profile for Logged on user "<UserRole>"
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
    Then I Choose to verify profile for Logged on user "<UserRole>"
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
    Then I Choose to verify profile for Logged on user "<UserRole>"
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

  #   | MasterDataAdmin | 14189810 | AVLB - Available | 0009486701 | 0009486701 | IE03  | Structure    | CreateEquipment | Sales and Distribution |
  @440742
  Scenario Outline: 440742:Onsite work order with overlap time
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with"<EvenType>"and"<priorityType>"and"<ip>" with contact "Aldo D'Alessandro"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to get the above created Work order
    When I choose to Initiate Travel SFM
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    #Then I choose to get the work line details"<workData>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole>"
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    #And I choose to get the created Non work order link"<nontestData>""<subject>""<Technicianuser>"
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | EvenType | priorityType  | Technician  | country     | event     | subject  | Technicianuser      | testdata          | workData  | nontestData     | ip       |
      | ServiceAgent | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | Netherlands | Confirmed | Training | Meena service user2 | createdWorkorders | worklines | NonWorkOrderUrl | 62784521 |

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
    Then I Choose to verify profile for Logged on user "<UserRole>"
    Then I choose to verify the equipment created in SAP
    And I choose to select the IP
    Then I choose to verify Ip child records
    Then I choose to update Vendor details and Save
    Then I Choose to log out of the application

    Examples: 
      | Tcode | function        | workcenter | UserRole        | Tcode1 | structureTab | tableName       | status |
      | ZEQUP | PL002856-005-01 | PL_GEN     | MasterDataAdmin | IE03   | Structure    | CreateEquipment | OPER   |

  @454346
  Scenario Outline: 
    454346:Test to check ZSID part can be returned & consumed and Case activity creation.

    Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<agentRole>"
    #Then I Choose to verify profile for Logged on user "<agentRole>"
    #When I Choose to Search "<ip>" using global search box
    ##Then I choose to verify Product is ZSID
    #And I choose to select the IP
    #And I choose to create new case with"<EvenType>"and"<priorityType>"and contact"<contact>"
    #When I Choose to Open Case and create safety questionnaire "No"
    #When I Choose to Create Onsite Work Order SFM
    #And I choose to get the WO1
    #And I choose to get Case number
    #When I Choose to Initiate SWO
    #Then I choose to verify SAP SWO
    #Then I choose to add Parts and verify
    #And I choose to get ASO Number
    #Then I Choose to log out of the application
    #Given I Choose to Start LeanFT Run time engine
    #		Given I Choose to launche to SAP application
    #When User enters T Code in SAP application as"<Tcode>"
    #When I choose to enter ASO Number
    #And I choose to deliver the order
    #And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    #And I choose to do single part delivery
    #And I choose to pack the order
    #And I choose to update"<packing>"and"<identification>"values
    #And I choose to add Serial Number
    #Then I choose to save the Delivery
    #And I choose switch back to login
    #When User enters T Code in SAP application as"<Tcode1>"
    #And I choose to select PGI for above created document
    #When I choose to close SAP Application
    #Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<agentRole>"
    #Then I Choose to verify profile for Logged on user "<agentRole>"
    #And I choose to navigate to WO1
    #Then I choose to verify SAP document shipped to Work order
    #Then I Choose to Dispatch WO Using Service Board "<Technician>"
    #Then I Choose to log out of the application
    #Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<serviceUser>"
    #Then I Choose to verify profile for Logged on user "<serviceUser>"
    #And I choose to navigate to WO1
    #When I choose to Initiate Travel SFM
    #When I Choose to Initiate Onsite SFM
    #And I choose to add Labour without Overlap
    #Then I choose Labour parts to"<deliver>"
    #And I choose to open parts for non returnable
    #And I choose to open parts returnable"<consume>"and"<rml>"
    #And I choose to select Record tool as not required
    #And I choose to Debrief work oder and follow up
    #Then I Choose to log out of the application
    #Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<agentRole>"
    #Then I Choose to verify profile for Logged on user "<agentRole>"
    #And I choose to navigate to case Number
    #And I choose select Create case activity
    #Then I choose to verify Type values and Update
    #Then I choose to verify the created Case Activites
    #Then I choose to verify encripted PHI data
    #And I choose to select case"<caseValue>"
    #Then I choose to verify Create case acitvity is disabled
    #Then I Choose to log out of the application
    #Given I launch ServiceMax application successfully
    #When I Choose to enter credentials for "<agentRole>"
    #Then I Choose to verify profile for Logged on user "<agentRole>"
    #And I choose to select case"<caseValue1>"
    #Then I choose to verify Safety question
    #And I choose to update CA to pickedUP
    #And I choose to Escalate stakeholder Info
    #Then I Choose to log out of the application
    #Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<serviceUser>"
    Then I Choose to verify profile for Logged on user "<serviceUser>"
    And I choose to navigate to WO1
    And I choose to complete the Work order
    Then I choose to veify WO is in Ready to Fix state
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to verify profile for Logged on user "<UserRole>"
    And I choose to navigate to WO1
    Then I choose to update WO as Fixed
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | contact | tabName3     | partnerTab | Tcode | tableName | operationTab | priorityType  | ip       | agentRole    | EvenType | ip1      | Tcode1 | Technician  | packing | identification | serviceUser       | consume  | rml        | deliver   | caseValue  | caseValue1 |
      | MasterDataAdmin | meena n | itemOverview | Picking    | VA03  | operation | Operations   | Critical Need | 75945374 | ServiceAgent | Incident | 36587375 | VL02n  | Meena Tech2 |      34 | ups            | Meena1serviceuser | Consumed | R000000003 | Delivered | 0116320081 | 0116544032 |

  @711568
  Scenario: 
    711568: - 1.1.1 Test Script OQ – QRXXXXXX : Verify LCS4I: Service Requests with no Installed Product for Sales Support

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
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "ServiceAgent"
    When I choose to search for Account using Search Criteria
      | Country       | contains | US               |
      | Account Group | equals   |             0001 |
      | Account Name  | contains | Northwell Health |
    When I choose to Create Contact from Account
    When I Choose to create Case on Unknown Product
      | Internal Support | CS Internal | 5-Scheduled Activity | Test LCS4I | Pre-sales | Patient name is John Doe with MRN 12345. |
    Then I choose to verify details in Case Details page for TC "711568"
    Then I choose to create New Commitment from Case
      | ServiceAgent | Call back customer for progress update in 1 hour | 1 |
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
| UserRoleAgent | IP1 |
| ServiceAgent | 62794133 |

  @1539885
  Scenario Outline: 1539885:  TC_Hybris_IP Lookup and Contract Lookup from Smax to Hybris
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRoleAgent>"
    When I Choose to Search "<InstallProduct>" using global search box
    When I Choose to Launch Hybris Application successfully
    Then I choose to enter  credentials for Hybris application for "<User">
    When I Choose to Search   Serial number for the account in Hybris order page
                   |83246166|81176|
    When I choose to Search with the Serial Number and Product Description for the  Account in Hybris Order Page
                   |USO18B0266|14574883|Pagewriter|
    When I Choose to Search serial number and Product Code for the  Account in Hybris Order Page
                   |US00607739|15221110|860259|
    When I choose to Search Serial number that is not unique which fetch more than 1 IP  in Hybris Order page
                   |68138|83704916|
    When I choose to Search  IP that is other than Type as system and note down the same serial number  from Hybris Order Page
                   |83092|
    When I choose to search with full serial number + substring of product number in Hybris Order Page
                   |DE94546461|multi|
    When I choose to search  full Serial number and incorrect  product number in Hybris Order page
                   |DE94546461|860259|989803106641|
    When I choose to search  Contract number for the account
                   |CON0127879|
    When I choose to search for another Contract_number for the account
                   |CON0127493|
    Then I Choose to log out of the application

    Examples: 
      | UserRoleAgent | InstallProduct | User        |
      | ServiceAgent  |        83246166 | Hybris User |

 
 
  ##Provide new RML for every run
  @442011
  Scenario Outline: 
    442011:Scenario14 - Verify whether the defective material data sent from ServiceMax is recorded accurately in SAP

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<Workorder1>" using global search box
    When I Choose to Open "<Workorder1>" the above record
    When I Choose to click on Add labour and parts
    When I Choose to click on Open parts
    When I Choose to click on Open parts Non returnable "<RML>"
    When I Send the WO "<Workorder1>" to SAP
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
    When I Choose to enter Material Document Number "5100099018" And Material Document Year "Year"
    When I Choose to Verify Material Document Details
    When I Choose to Click on Accounting Document And Verify details
    Then I choose to close SAP Application

    Examples: 
      | UserRole           | Workorder1  | TCode | RML        |
      | ServiceTechnician | WO-04653585 | mb03  | R000000136 |

  #part1
  @438540
  Scenario Outline: 438540: Contract Management Contract creation, Activation, price condition verification, PM plan creation, PM cases and work order creation, expiring the contract and verifying it is not considered in entitlement
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    Then I choose to click on Account
    Then I choose to Create New Contract Header
    Then I choose to Create Contract with "<Billingplantype>"
    Then I choose to enter Total and SAP Contract price "<TCP>" "<SCP>"
    Then I choose to Edit Coverage with "<Installed Product>"
    Then I choose to verify Billing Plan Type and Inadvance
    Then I choose to verify the date rule error when Billing plan type is Periodic and date rules are empty
    Then I choose to change the Billing Plan Type to Milestone and verify the Error of date rule
    Then I choose to click on Send To SAP
    Then I choose to verify SAP Integration status
    Then I choose to create New Billing plan Line
    Then I choose to click on Active contract
    Then I choose to change the Contract by updating SAP Condition Price
    Then I choose to verify SAP Integration status
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode1>"
    When I choose Search contract
    Then I choose to verify the Netvalue with Total Contract Price
    When I choose to close SAP Application
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | Installed Product | Tcode1 | Billingplantype | Billingplantype1 | TCP | SCP |
      | MasterDataAdmin | 48451766 | VA43   | Periodic  | Milestone | 100 | 100 |

  @571972
  Scenario: 
    571972:- Schedule and Report Non-Customer Interaction Time

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

  #Create Custom RSE L1,Custom RSE L2,Custom RSE L3 Users and add them to HongKong territory,and add them to respective queues
  #Get the Asset with Hong kong shipping  address
  #Create contact with Test in contact name
  @439779
  Scenario Outline: 
    439779 : OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "CustomRSEL1"
    When I Choose to close all tasks
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details
    And I choose to click on New Escalation
    And I choose to enter escalation details
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L1"
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L2"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I Choose to open the Escalation Created
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "implementor"
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L3"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I Choose to open the Escalation Created
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    And I choose to click on option "Edit"
    And I choose to enter Implementor
    And I choose to click on New Action Plan
    And I choose to create New Action Plan
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to create Response on  Action Plan
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on option "Edit"
    And I choose to enter BU Status
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to change the status to "Monitoring"
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to enter release Date
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on option "Edit"
    And I choose to enter Expected fix date
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to change the status to "Workaround"
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I Choose to open the Escalation Created
    And I choose to click on option "Close Case"
    And I Choose to enter EscalationClose Details
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details
    And I choose to click on New Escalation
    And I choose to enter escalation details
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L1"
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L2"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    And I choose to click on option "Edit"
    And I choose to enter Implementor
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L3"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to enter rejection situation
    And I choose to click on option "Reject Escalation"
    And I choose to verify the Alert "Reject"
    #And I choose to verify email "L1"
    #And I choose to verify email "L2"
    #And I choose to verify email "L3"
    #And I choose to verify email "implementor"
    And I choose to click on logout

    Examples: 
      | Asset    | RecordType |
      | 73426045 | Case - New |

  @438550
  Scenario Outline: 
    438550:Scenario 15 : Clubbed 19/20: F12298: Service Parts Material Only Scenarios for both (Incident/Material Only WO) and (Parts Supply Only/Material Only WO)

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<Account>" using global search box
    When I Choose to Open "<Account>" Service Maintenance Contract
    Then I Choose to Note Account related data
    When I Choose to create Case of Event Type "Parts Supply Only" and Event Sub Type "Parts Supply Only"
    When I Choose to Request a Quote SFM "Draft"
    # When I Choose to Add Parts "81581335"
    When I Choose to Release Quote SFM
    When I Choose to Approve Quote
    When I Choose to Accept Quote
    When I Choose to Generate Quote PDF SFM
    When I Choose to Open Case From Service Quote Detail Page
    When I create Parts Only work order
    When I intiate service
    When I Choose to 'Parts Ordering' SFM "453563478461"
    When I Choose to capture 'ASO number'
    #SAP VERIFICATION STEP && SAP PGI
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
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
    When I choose to close SAP Application
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "iw33" in search menu bar
    When I Choose to enter SAP SWO Number
    When I Choose to Verify Material Only WorkOrder in SAP
    When I Choose to Verify Status bar
    When I Choose to Verify SAP Document
    When I choose to close SAP Application
    Then I Choose to Confirm Delivery
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Case       | submitPSE | Account                        |
      | ServiceAgent | 0116747413 | No        | CENTRO DE PATOLOGIA DE LA MAMA |

  @440364
  Scenario Outline: 
    440364: Test to verify that bench repair status is tracked from work order creation to work order closure when the work order is entitled

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
    When I Choose to Navigate to Bench Status Tracker Page from Work Order Page
    When I Choose to verify Bench Repair Status from Bench Status Tracker Page "Ready For Diagnosis"
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
      | ServiceAgent |         94853810 | Dr Daniel Saura | ServiceTechnician |

  @437325
  Scenario Outline: 437325: Scenario32 - Test to verify SLA metrics with respect to case and WO and automatic generation of CSR on case closure.
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    #When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    When I Choose to 'Parts Ordering' SFM "453561440013"
    When I Choose to capture 'ASO number'
    ##SAP VERIFICATION STEP && SAP PGI
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
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
    #Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "iw33" in search menu bar
    When I Choose to enter SAP SWO Number
    When I Choose to Verify Material Only WorkOrder in SAP
    When I Choose to Verify Status bar
    When I Choose to Verify SAP Document
    Then I Choose to Confirm Delivery
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Account                           | submitPSE | IP       | TCode |
      # | ServiceAgent | FUNDACIÓN DE LA GESTIÓN SANITARIA | No        | 74624450 |va03|
      # | ServiceAgent | FUNDACIÓN DE LA GESTIÓN SANITARIA | No        | 88309498 |va03 |
      | ServiceAgent | Sahrudaya HealthCare Private | No        | 77003537 | va03  |


  
  @437279
  Scenario Outline: 437279:Verify that, an authorized user to create Onsite Work Order including Parts Ordering without having any entitlement in the Incident Case for the Account Type ZNCA, and make sure the costs are booked to the internal CS cost center automatically
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with Account "<AccountName>"and"<EvenType>"and"<priorityType>"and"<ip>"
    When I Choose to Open Case and create safety questionnaire "No"
    And I Chosse to verify SFMs are Enabled
    And I choose to verify OverRide Cost Center is autopopulated
    And I chosse to verify Entitlement is true and bill type blank
    And I choose to verify warranty and maintenance contract is blank
    When I Choose to Create Onsite Work Order SFM
    And I choose to get the WO1
    And I choose to get Case number
    And I Choose to View System Information
    When I Choose to Initiate SWO
    And I choose to get SAP SWO Number
    And I choose to complete Parts Ordering with "<PartsOrdering>"
    And I choose to navigate to WO1
    And I choose to get ASO Number
    
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "VA03" T Code in the I2M SAP application
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
    When I choose to close SAP Application
    #
    ##Then I choose to verify SAP document shipped to Work order
    #Then I Choose to Dispatch WO Using Service Board "<Technician>"
    #Then I Choose to log out of the application
    #When I Choose to enter credentials for "<serviceUser>"
    #And I choose to navigate to WO1
    #When I Choose to Initiate Onsite SFM
    #And I choose to add Labour without Overlap
    #Then I choose Labour parts to"Delivered"
    #When I Choose to confirm open labors Returnable "<PartsOrdering>"
    #And I choose to verify Is billable is blank for "Labour"
    #And I choose to navigate to WO1
    #And I choose to verify Is billable is blank for "Parts"
    #Given I Choose to Start LeanFT Run time engine
    #Given I Choose to launche to SAP application
    #When User enters T Code in SAP application as"/niw33"
    #When I choose to enter SWO Number
    #And I choose to verify Account Indicator
    #And I choose to verify account Indicator on Planner Actual comparision page
    #Then I Choose to log out of the application
    #When I choose to close SAP Application

    Examples: 
      | UserRole     | deliver   | AccountName                   | serviceUser       | EvenType | priorityType  | Technician  | ip       | PartsOrdering | Tcode | tabName3     | partnerTab | packing | identification | Tcode1 |
    #  | ServiceAgent | Delivered | PHILIPS IBERICA, S.A.U. | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | 88752203 |  453561440013 | VA03  | itemOverview | Picking    |      34 | ups            | VL02n  |
		  | ServiceAgent | Delivered | SUNWAY MEDICAL CENTRE SDN BHD | AutomationTechnicianUser | Incident | Critical Need | Automation Technician User | 70828479 |  453561440013 | VA03  | itemOverview | Picking    |      34 | ups            | VL02n  |
		
  @574840
  Scenario Outline: 
    574840:US216150 & US217315 - Test to verify that Authorized user is able to create Follow up OOC Bench work order on Incident case, covered by Service Contract & complete the repair of the installed product for countries maintained in OOC Bench Matrix

    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRoleAgent>"
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
    When I Choose to Create 'Remote Service Workorder'
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to 'Initiate Remote Service' SFM
    When I CHoose to Debrief and Follow up and "Create Follow up Activity"
    When I CHoose to Capture Work Order Number "WO2"
    When I Choose to verify Work Order Bench status as "Follow up work Identified"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRoleAgent>"
    When I Choose to Search WorkOrder "WorkOrder2" using global search box
    When I Choose to Open WorkOrder "WorkOrder2" from the search result
    When I Choose to 'Initiate SWO' SFM and capture SWO Number
    When I Choose to 'Parts Ordering' SFM "453561440013"
    When I Choose to capture 'ASO number'
    Then I Choose to log out of the application
    # Step SAP PGI
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enter ASO Number
    And I choose to deliver the order
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to do single part delivery
    And I choose to pack the order
    And I choose to update"<packing>"and"<identification>"values
    And I choose to add Serial Number
    Then I choose to save the Delivery
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to select PGI for above created document
    When I choose to close SAP Application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder2" using global search box
    When I Choose to Open WorkOrder "WorkOrder2" from the search result
    When I Choose to Initiate Bench Repair
    When I CHoose to Debrief and Follow up and "Create Follow up Activity"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "MasterDataAdmin"
    When I Choose to Search WorkOrder "WorkOrder2" using global search box
    When I Choose to Open WorkOrder "WorkOrder2" from the search result
    When I Choose to Approve IP Change Request and update Location
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to add Labor and Parts
    When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    When I Choose to Complete the WorkOrder SFM
    When I Choose to Update the Bench Repair Status
    Then I Choose to log out of the application
    When I Choose to enter credentials for "MasterDataAdmin"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to Approve IP Change Request and update Location
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole2>"
    When I Choose to Search WorkOrder "WorkOrder3" using global search box
    When I Choose to Open WorkOrder "WorkOrder3" from the search result
    When I Choose to capture Work Order Number "WO3"
    When I Choose to Initiate Bench Repair
    When I CHoose to Debrief and Follow up and "Create Follow up Activity"
    When I Choose to add Labor and Parts
    When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    When I Choose to Complete the WorkOrder SFM
    When I Choose to Update the Bench Repair Status
    Then I Choose to log out of the application

    Examples: 
      | UserRole          | UserRoleAgent | InstalledProduct | TCode | TCode2 | ContactId      | UserRole2         |
      | ServiceTechnician | ServiceAgent  |         74624450 | iw33  | /nva43 | Andrew Horsman | ServiceTechnician |

 
     