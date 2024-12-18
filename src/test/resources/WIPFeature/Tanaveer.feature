Feature: To Demonstrate serviceMax and SAP related Utilities using Selenium and LeanFT

  @442011
  Scenario Outline: 442011:Scenario14 - Verify whether the defective material data sent from ServiceMax is recorded accurately in SAP
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #When I Choose to Search "<Workorder1>" using global search box
    #When I Choose to Open "<Workorder1>" the above record
    #When I Choose to click on Add labour and parts
    #When I Choose to click on Open parts
    #When I Choose to click on Open parts Non returnable
    #When I Send the WO "<Workorder1>" to SAP
    #Then I Choose to log out of the application
    #Given I Choose to Start LeanFT Run time engine
    #Given I Choose to launche to SAP application
    #When I Choose to enter "<TCode>" T Code in the I2M SAP application
    #When I Choose to enter Material Document Number "5100099018" And Material Document Year "Year"
    #When I Choose to Verify Material Document Details
    #When I Choose to Click on Accounting Document And Verify details
    #When I Choose to close SAP Application

    Examples: 
      | UserRole           | Workorder1  | TCode |
      | ServiceTechnician2 | WO-02273989 | mb03  |

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
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician>"
    Then I Choose to verify profile for Logged on user "<ServiceTechnician>"
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to open Work Order Line items and save record
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician |
      | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician |

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

  @711331
  Scenario Outline: 711331 :Unknown Installed Product case creation & correction initiated from WO
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #When I choose to create contact and save from account
    When I Choose to Create Contact using Record Type "Contact" And Account "CLINICA DIAGNOSTICO SAN MIGUEL S.L."
    When I Choose to create Case on Active Contact With "<Product Type>" And "<Event Type>" And "<Priority>" And "<Case Origin>" And "<Case Source>" And "<Sales Org>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    When I Choose to Change Installed Product "<IP>"
    When I Choose to Create IP Relocation Change "<Location>" And "<IP>" And "<Sales Org>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "MasterDataAdmin"
    When I Choose to Search IP Change Request using global search box And Approve
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceTechnician"
    When I Choose to Search WorkOrder "Workorder" using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to open Work Order Line items and save record
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Product Type                                    | Event Type | Priority      | Case Origin | Case Source | Sales Org | IP       | Location |
      | ServiceAgent | 989604296451-Unknown Patient monitoring product | Incident   | 2-System Down | Phone       | Customer    | ES93      | 62784521 | Spain    |

  Scenario Outline: 574840:US216150 & US217315 - Test to verify that Authorized user is able to create Follow up OOC Bench work order on Incident case, covered by Service Contract & complete the repair of the installed product for countries maintained in OOC Bench Matrix
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
    When I Choose to capture Work Order Number "WO2"
    When I Choose to Search WorkOrder "WorkOrder1" using global search box
    When I Choose to Open WorkOrder "WorkOrder1" from the search result
    When I Choose to verify Work Order Bench status as "Follow up work Identified"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRoleAgent>"
    When I Choose to Search WorkOrder "WorkOrder2" using global search box
    When I Choose to Open WorkOrder "WorkOrder2" from the search result
    When I Choose to 'Initiate SWO' SFM and capture SWO Number
    When I Choose to 'Parts Ordering' SFM "453564040241"
    When I Choose to capture 'ASO number'
    Then I Choose to log out of the application
    # Step SAP PGI
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
      | UserRole          | Workorder   | UserRoleAgent | InstalledProduct | Case       | TCode | TCode2 | UserItops | Quote      | ContactId       | UserRole2         |
      | ServiceTechnician | WO-02270347 | ServiceAgent  |         88753683 | 0116422501 | iw33  | /ova43 | ITOpAdmin | Q-00280260 | Dr Daniel Saura | ServiceTechnician |

  @439794
  Scenario Outline: 439794:Scenario 23- Test to validate completion of FCO KIT for 1 to 1 - Field Change Order
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to open Data Import Wizard "<UserRole>"
    When I Choose to Import "one to one" FCO data to ServiceMax
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceFCOAdmin"
    When I Choose to Verify "one to one" FCO data import to ServiceMax
    When I Choose to Save and Update FCO Header Details
    When I Choose to Update "one to one" FCO Record Details to FCO Header UAL File
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to open Data Import Wizard "<UserRole>"
    When I Choose to Import "one to one" FCO UAL data to ServiceMax
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceFCOAdmin2"
    When I Choose to Verify one to one FCO UAL data import to ServiceMax
    When I Choose to Create FCO UAL Case
    When I Choose to Create FCO UAL Work Orders
    When I Choose to Open Case And Verify FCO UAL Work Orders
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceAgent"
    When I Choose to Initiate SWO FCO UAL Work Orders
    When I Choose to 'Parts Ordering' SFM and Order FCO Kit
    When I Choose to capture 'ASO number'
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
    Then I Choose to Dispatch WO Using Service Board "Meena Tech2"
    Then I Choose to log out of the application
    When I choose to open the "<Device>" device
    When I Choose to enter credentials for "<UserRoleMobile>" in mobile device
    When I Choose to Config Sync Data
    And I Choose to Sync Data
    And I choose to Click Explore and verify properties
    And I Choose to Open FCO WorkOrder
    And I Choose to Perform Initiate Travel Action
    And I choose to Click Explore and open WorkOrder
    And I Choose to Perform Initiate Onsite Action
    And I choose to Click Explore and open WorkOrder
    And I Choose to Mark FCO Kit Delivered
    And I choose to Click Explore and open WorkOrder
    When I Choose to Mark FCO Kit Line staus and Part Status
    And I choose to Click Explore and open WorkOrder
    When I Choose to Mark FCO Kit Complete and verify error
    And I choose to Click Explore and open WorkOrder
    When I Choose to Mark All FCO Kit Line staus and Part Status
    And I choose to Click Explore and open WorkOrder
    When I Choose to Mark FCO Kit Complete
    When I Choose to Config Sync Data
    And I Choose to Sync Data
    Then I Choose to Close App
    When I Choose to enter credentials for "ServiceTechnician"
    Then I Choose to Verify FCO Kit Header work detail
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | TestData | ServiceAgent | ServiceTechnician | ServiceFCOAdmin | UserRoleMobile    | ServiceFCOAdmin2 | TCode | Device |
      | MasterDataAdmin |   439794 | ServiceAgent | Meena1serviceuser | ServiceFCOAdmin | Meena1serviceuser | ServiceFCOAdmin2 | va03  | iPhone |

  @738148
  Scenario Outline: 738148:Test to verify ASP Technician is able to complete the Work Order as per the dispatch schedule
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Load Data "<TestData>"
    When I Choose to Search "Installed Product" using global search box
    When I Choose to Open "Installed Product" Installed Product Detail page and verify Account
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite WorkOrder SFM
    When I Choose to Initiate SWO
    When I Choose to add Parts Ordering SFM "453561440013"
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode1>" T Code in the I2M SAP application
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
    When I Choose to enter "<TCode2>" Delivery in the SAP application
    When I Choose to Search "ASO-Delivery" in Order Field
    When I Choose to Post ASO Goods Issues
    When I choose to close SAP Application
    When I Choose to Dispatch WO Using Service Board "Auto ASP Technician"
    Then I Choose to log out of the application
    When I choose to open the "<Device>" device
    When I Choose to enter credentials for "<UserRoleMobile>" in mobile device
    And I Choose to Sync Data
    And I choose to Click Explore and verify properties
    And I Choose to Open WorkOrder
    And I Choose to Perform Initiate Travel Action
    And I choose to Click Explore and open WorkOrder
    And I Choose to Perform Receive Parts Action and update Line Status
    And I choose to Click Explore and open WorkOrder
    And I Choose to Perform Initiate Onsite Action
    And I choose to Click Explore and open WorkOrder
    And I Choose to Add Labor
    And I Choose to Update labor Activity Type
    And I choose to Click Explore and open WorkOrder
    And I Choose to Consume Parts
    And I choose to Click Explore and open WorkOrder
    And I Choose to Add Record Tools
    And I choose to Click Explore and open WorkOrder
    And I Choose to Debrief and Follow up
    And I Choose to Update Work Activity
    And I Choose to Sync Data
    And I choose to Click Explore and open WorkOrder
    And I Choose to Perform Unsigned Customer Report
    And I choose to Click Explore and open WorkOrder
    When I Choose To Complete Work Order
    And I Choose to Sync Data
    ##When I Choose to Verify that the CSR email is received
    Then I Choose to Close App

    Examples: 
      | UserRole     | TestData | Device | UserRoleMobile | TCode2  | TCode1 |
      | ServiceAgent |   738148 | iPhone | ASPTechnician  | /nvl02n | va03   |

  Scenario Outline: 436396:Scenario 40 - OneEMS Porta_Case creation, Reports generation, Service performance and quality report in One Ems Portal.
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Load Data "<TestData>"

    Examples: 
      | UserRole     | TestData |
      | ServiceAgent |   436396 |

  @SAP
  Scenario Outline: 437852: SAP PGI
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
    When I Choose to close SAP Application

    Examples: 
      | TCode |
      | va03  |
