Feature: Phase1 Pipeline2

  @439779
  Scenario Outline: 439779: OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "CustomRSEL1"
    When I Choose to close all tasks
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details "Corrective Maintenance"
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
    And I choose to click on New Action Plan
    And I choose to create New Action Plan
    And I choose to create Response on  Action Plan
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on option "Edit"
    And I choose to enter BU Status
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to change the status to "Monitoring"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to enter release Date
    And I choose to click on option "Edit"
    And I choose to enter Expected fix date
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to change the status to "Workaround"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I Choose to open the Escalation Created
    And I choose to click on option "Close Case"
    And I Choose to enter EscalationClose Details
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details "Corrective Maintenance"
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
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L3"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to enter rejection situation
    And I choose to click on option "Reject Escalation"
    And I choose to verify the Alert "Reject"
    And I choose to click on logout

    Examples: 
      | Asset    | RecordType |
      | 73426045 | Case - New |

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

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician          | Technician        | IP1      |
      | ServiceAgent | CON0100457 | ServiceAgent | Automation Technician User | ServiceTechnician | 62794133 |

  @711331
  Scenario Outline: 711331 :Unknown Installed Product case creation & correction initiated from WO
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    # When I Choose to Load Data "<TestData>"
    When I Choose to Create Contact using Record Type "Contact" And Account "Freeman Hospital West"
    When I Choose to create Case on Active Contact With "<Product Type>" And "<Event Type>" And "<Priority>" And "<Case Origin>" And "<Case Source>" And "<Sales Org>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to update site on the case with "<IP>"
    When I Choose to Change Installed Product "<IP>"
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "ServiceTechnician"
    #When I add WO
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I Choose to Change Installed Product "<IP>"
    When I Choose to add Labor and Parts
    When I Choose to Create IP Relocation Change "<Location>" And "<IP>" And "<Sales Org>"
    When I Choose to Search Work Order using global search box
    And I choose to Debrief work oder and follow up
    When I Choose to opt for Tools not Required Checkbox in Record Tools SFM
    And I choose to complete the Work order
    Then I Choose to log out of the application

    #If there is ask for case closure manually otherwise wait for batch job to complete
    #When I Choose to enter credentials for "MasterDataAdmin"
    #When I Choose "Work Order" from search list
    #When I choose to update WO as Fixed
    #When I Choose "case" from search list
    #When I Choose to perform case closure using Business Complete SFM
    #Then I Choose to verify Reason for incompletion "<Expected Result>"
    #When I Choose to Search IP Change Request using global search box And Approve
    #When I Choose "case" from search list
    #When I Choose to perform case closure using Business Complete SFM
    Examples: 
      | UserRole     | Product Type                                    | Event Type | Priority      | Case Origin | Case Source | Sales Org | IP       | Location | TestData | Expected Result                                                                                        |
      | ServiceAgent | 989604296451-Unknown Patient monitoring product | Incident   | 2-System Down | Phone       | Customer    | US93      | 63221008 |          |   738148 | The following Installed Product change request(s) is/are pending closure before the case can be closed |

  @442011
  Scenario Outline: 442011:Scenario14 - Verify whether the defective material data sent from ServiceMax is recorded accurately in SAP
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
      | UserRole          | Workorder1  | TCode | RML        |
      | ServiceTechnician | WO-02698345 | mb03  | R000000136 |

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
      | MasterDataAdmin | /nie01  | SerData | CreateEquipment | /nse38 | ZR_CS_EQUIP_EXTRACT | ES100026-001-032    |

  @438549
  Scenario Outline: 
    438549 :F16949 - DX Cross Border – To verify flow cross border contract postings from SMax-MP1 for a non-legacy contract

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
      | UserRole        | Contract   | Installed Product | ServiceAgent | ServiceTechnician | L1TechnicianUser  | MasterAdmin     | Technician  | EventType | SubEventType | TCode | TCode2 |
      | MasterDataAdmin | CON0351018 |          69338662 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /nva43 |

  @442159
  Scenario Outline: 442159:Quotation administrator is able to create, amend quote in ServiceMax and DMR is updated in SAP
    Given I launch ServiceMax application successfully
    And I Choose to enter credentials for "<AgentUser>"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    Then I verify "<SFM>" on "<type>" Page
    When I Choose to click on SFM "<clickSFM>" on "<type>" Page
    Then I verify that case owner is changed to "ESMX Back Office - Case"
    When I Choose to Request a Quote SFM "Quote Request"
    #  When I Choose to open the Quote created from Case
    Then I verify the line and quote prices
    When I Choose "quote" from search list
    When I Choose to verify quote update as "AgentUser"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "Quote Admin"
    When I Choose "quote" from search list
    When I Choose to verify quote update as "Quote Admin"
    Then I verify the line and quote prices
    When I Choose to Release Quote SFM
    Then I choose to verify Quote status as "<quoteStatus>"
    When I choose to approve quote line items
    When I Choose to Approve Quote
    When I Choose to Accept Quote
    Then I verify Debit Memo Integration Status "<dmrStatus>"
    When I choose to verify Partners

    #When I Choose to Amend Quote
    #When I Choose to Release Quote SFM
    #Then I choose to verify Quote status as "<quoteStatus>"
    #When I Choose to Accept Quote
    #Then I verify Debit Memo Integration Status "<dmrStatus>"
    #When I choose to verify Partners
    #Then I Choose to log out of the application
    Examples: 
      | AgentUser | IP       | SFM             | type | clickSFM            | quoteStatus               | dmrStatus                   |
      | AgentUser | 77003537 | Request a Quote | Case | Send to Back Office | Pending Discount Approval | Debit memo creation success |

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
      | UserRole        | Contract   | Installed Product | ServiceAgent | ServiceTechnician | L1TechnicianUser  | MasterAdmin     | Technician  | EventType | SubEventType | TCode | TCode2 |
      | MasterDataAdmin | CON0070254 |          34155319 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /nva43 |

  @437852
  Scenario Outline: 437852: Scenario19 & 20 - Automated IB Update-Material Only and Blueroom FSE- Serial Number Correction
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRoleAgent>"
    #When I Choose to Search "<InstallProduct>" using global search box
    #When I Choose to Open "<InstallProduct>" Installed Product Detail page and verify Account
    #When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    #When I Choose to Open Case and create safety questionnaire "No"
    #When I create Material Only work order
    #When I intiate service
    #When I Choose to add Parts Ordering SFM "453561440013"
    When I Choose to Search "<InstallProduct>" using global search box
    When I Choose to Open "<InstallProduct>" Installed Product Detail page and verify Account
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite WorkOrder SFM
    When I Choose to Initiate SWO
    When I Choose to add Parts Ordering SFM "453561440013"
    Then I Choose to Dispatch WO Using Service Board "Automation Technician"
    When I Choose to Search "<Workorder>" using global search box
    When I click the "<Workorder>"
    When Search WorkorderOne mentioned in test setupNine and verify that work detail line of type Part is created in Shipped status
    Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
    When I Choose to Search "ASO-Item" in Order Field
    When I Choose to Open "Item-Material" From "Sales" Tab of "ASO-Item" Window
    When I Choose to Click "Partners" Tab of "Item-Data" Window
    When I Choose to Verify Delivery Location
    When I Choose to enter "/nie03" Delivery in the SAP application
    When I Choose to enter IP4 in Equipment Search Box
    When I Choose to Click "Structure" Tab of "Equipment" Window
    When I Choose to Verify Function Equipment and Superrod Equipment
    When I Choose to enter "/nil03" Delivery in the SAP application
    When I Choose to Enter Functional Location
    When I Choose to Verify Functional Location
    When I choose to close SAP Application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "va02" T Code in the I2M SAP application
    When I Choose to Search "ASO-Sales-Order" in Order Field
    When I Choose to Click Display document flow icon
    When I Choose to Single Part Delivery and Click Display Document
    When I Choose to Select Line Item
    When I Choose to Select "Extras Delivery Output Item" Menu Item
    When I Choose to Click on Processing Log And Note Delivery Number
    When I Choose to enter "/nzvblueroom" Delivery in the SAP application
    When I Choose to Search Delivery Number
    When I Choose to enter "/nVL02n" Outbound Delivery in the SAP application
    When I Choose to Enter Delivery Number in OutBound Delivery Field
    When I Choose to Select the line item and Enter the serial number
    When I Choose to enter "/nzvblueroom" and Verify Part information screen
    When I Choose to Search Delivery Number
    When I choose to close SAP Application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "va02" T Code in the I2M SAP application
    When I Choose to Search "ZR_CS_BLUEROOM_CORRECTIONS" And execute Program correction
    When I choose to close SAP Application

    Examples: 
      | UserRole          | Workorder   | UserRoleAgent | InstallProduct | Case       | TCode2 | UserItops | Quote       | UserRoleMDA     | InstalledProductSecond | TCode |
      | ServiceTechnician | WO-04664928 | ServiceAgent  |       77003537 | 0116422501 | /ova43 | ITOpAdmin | WO-02284181 | MasterDataAdmin |               88282444 | va03  |

  @716151
  Scenario Outline: 716151:CSP_Account Assignment and Authorization driven CS Portal functionalities covering Cases, Account, Locations, Installed Product, Contracts, Warranties, Reports, Calendar modules.
    #Given I launch Salesforce application successfully
    #When I Choose to enter credentials for "<UserRole>"
    #Then I choose to click on All Tabs
    #Then I choose to click on Account Assignment
    #Then I choose to create a Assignment with a "<Recordtype>"
    #Then I choose to create a Group with "<grouptype1>" and "<country>"
    #Then I choose to click on All Tabs
    #Then I choose to click on Account Assignment
    #Then I choose to create a Assignment with a "<Recordtype>"
    #Then I choose to create a Group with "<grouptype2>" and "<country>"
    #Then I choose to click on Add Child
    #Then I choose to add New Account Assignment with "<AccountName1>"
    #Then I choose to click on Add Child
    #Then I choose to add New Account Assignment with "<AccountName2>"
    #Then I choose to click on All Tabs
    #Then I choose to click on CS Portal User Assignment
    #Then I choose to search portal with "<PortalName>"
    #Then I choose to Add Super Group
    #Execute when test data set up is ready
    Given I launch ServicePortal application successfully
    When I Choose to enter credentials in servicemax Application for "<Portal user>"
    Then I choose to verify the Tabs present on Portal
    Then I choose to verify Calendar on Homepage
    Then I choose to verify Request Support button
    Then I choose to verify Number of Systems
    Then I choose to verify the Service cases updates
    Then I choose to click on "<IPTab>"
    Then I choose to verify columns and buttons on InstalledProduct Page
    Then I choose to click on Update Ip Info button
    Then I choose to verify the buttons after navigate UpdateIpinfo Page
    Then I choose to mass update
    Then I choose to click on "<IPTab>"
    Then I choose to search for IP with "<IPID>"
    #Then I choose to click on Generate EOL Mail
    Then I choose to verify Product Details
    Then I choose to Add or change IP Details
    Then I choose to click on "<IPTab>"
    Then I choose to click on Export button
    Then I choose to select the columns and submit
    Then I choose to verify whether file is downloaded successfully
    ## === 25 26 steps
    Then I choose to click on "<IPTab>"
    Then I choose to search for IP with "<IPForPlannedvisit>"
    Then I choose to click on Planned Visit Tab and verify fields
    Then I choose to click on "<IPTab>"
    Then I choose to search for IP with "<IPForSLCPVerification>"
    Then I choose to click on "<HomeTab>"
    Then I choose to click on Request Support Btn with value "<dropdownvalue>"
    Then I choose to click on Select an IP to create case button
    Then I choose to verify auto Populated fields
    Then I choose to click on any IP
    Then I choose to select no for given question
    Then I choose to click on priority dropdown and validate values
    Then I choose to select Type of Service "<type>"
    Then I choose to verify fields in Contact Information section
    Then I choose to verify Manage Additional Contact button
    Then I choose to select mandatory fields to create a case
    Then I choose to verify fields under Case Details Section
    Then I choose to verify fields under Installed Product Section
    Then I choose to click on Add Case Activity button
    Then I choose to enter mandatory fields to create activity
    Then I choose verify PHI Checkbox is selected or not
    Given I launch Salesforce application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I choose to search casenumber in globalsearch
    ##  			===== add case lines=====
    Then I launch ServicePortal application successfully
    Then I choose to click on "<AccountTab>"
    Then I choose to verify Fields under Account List View
    Then I choose to select an Account
    Then I choose to validate Related Items
    Then I choose to validate Related Tabs For Account
    Then I choose to click on "<HomeTab>"
    Then I choose to click on Request Support Btn with value "<dropdownvalue2>"
    Then I choose to select create a case
    Then I choose to click on Select an IP to create case button
    Then I choose to click on any IP
    Then I choose to select no for given question
    Then I choose to click on priority dropdown and validate values
    Then I choose to verify fields in Contact Information section
    Then I choose to verify Manage Additional Contact button
    Then I choose to select mandatory fields to create a case
    Then I choose to click on "<LocationTab>"
    Then I choose to validate fields Under LocationTab
    Then I choose to select an Location "<LocationName>"
    Then I choose to validate fields under Location Details Page
    Then I choose to validate Related Items
    Then I choose to validate Related Tabs
    Then I choose to click on "<ContractTab>"
    Then I choose to verify Fields under Contract Page
    Then I choose to select a Contract
    Then I choose to validate labels on ContractPage
    Then I choose to validate Related Tabs
    Then I choose to select "<ContactUs>" from More dropdown
    Then I choose to click on contact customer service button
    Then I choose to click on Next button
    Then I choose to click on submit button
    Then I choose click on Profile "<ProfileName>" and select "<My Profile>"
    Then I choose to validate fields present on My profile details Page
    Then I choose to verify Change Password Fields
    Then I choose to search in Global search of Portal with "<AccountName2>"
    Then I choose to click on "<CasesTab>"
    Then I choose to verify filter under case tab
    Then I choose to verify fields Under case tab
    Then I choose to click on "<DocumentsTab>"
    Then I choose to validate the fields under DocumentsTab
    Then I choose to fill the Mandatory fields under DocumentTab with "<AccountName2>"
    Then I choose to select checkboxes and download a file

    #Then I choose to select a "<casenumber>" have a file more than 10MB and download
    #Then I choose to verify the error of download
    #Then I choose to select the "<value>" from Reports dropdown
    #Then I choose to select All Folders
    #Then I choose to select a Record
    #Then I choose to verify the columns of the record
    Examples: 
      | UserRole     | Recordtype          | grouptype1 | grouptype2 | country | AccountName1                        | AccountName2             | PortalName         | Portal user | IPTab              | IPID     | HomeTab | dropdownvalue                         | CasesTab | type      | AccountTab | IPForPlannedvisit | IPForSLCPVerification | dropdownvalue2         | Prioritytype | type2     | LocationTab | LocationName             | ContractTab           | ContactUs  | My Profile | CasesTab | DocumentsTab | ReportsTab | value            | accName                         | casenumber | ProfileName        |
      | ServiceAgent | Master Group Header | Super      | Group      | ES      | C.S.I. UNIVERSITARIA DE BELLVITGEAB | A.O. PAPA GIOVANNI XXIII | Demo Portal User 1 | PortalUser  | Installed Products | 50987090 | Home    | Request Technical or Clinical Support | Cases    | Technical | Account    |          50987090 |              50987090 | Parts Order for Repair | Medium       | Education | Locations   | A.O. PAPA GIOVANNI XXIII | Contract And Warranty | Contact us | My Profile | Cases    | Documents    | Reports    | Standard Reports | Gadsden Regional Medical Center | 0116441834 | Tanveer Automation |

  @436906
  Scenario Outline: 436906:New System DEFOA Posting with Installation case type
    ##get ASONumber SWONumber ------ Testdata1
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    Then I choose to click on Product on IP page
    Then I choose to verify values of BG and BU on Product Page
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    When I choose to check the Sales order Type or WBS
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    When I Choose to Create Onsite Work Order SFM for "2" hours
    And I choose to get the WO1
    When I Choose to Initiate SWO
    And I choose to get SAP SWO Number
    And I choose to complete Parts Ordering with "<PartsOrdering>"
    And I choose to navigate to WO1
    And I choose to get ASO Number
    #PGI Process ------- Testdata2
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enter ASO Number
    And I choose to deliver the order
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to do single part delivery
    And I choose to pack the order
    And I choose to Process Outbound Delivery
    And I choose to add Serial Number
    And I choose to click on Post Good Issue
    And I choose to verify whether the delivery has saved
    When I choose to close SAP Application
    #Testcase steps
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to navigate to WO1
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole1>"
    And I choose to navigate to WO1
   # And I choose to receive the Parts
    #When I Choose to Initiate Onsite SFM
    #When I Choose to add Labor and Parts
    #When I Choose to confirm open labors Returnable "<PartsOrdering>"
    #And I choose to navigate to WO1
    #And I choose to verify the Valuation from Confirmed and Returned Parts
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"<Tcode1>"
    When I choose to enter SWO Number
    And I choose to navigate to Goods Movements
    And I choose to validate MovementType and Batch
    When I choose to close SAP Application

    Examples: 
      | UserRole     | UserRole1         | Contract   | Tcode1 | tabName3   | partnerTab | Tcode | sheetname   | Installed Product | PartsOrdering | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser  | MasterAdmin     | Technician                 | EventType    | SubEventType |
      | ResourcePlanner | ServiceTechnician | CON0100457 | IW33   | Packingtab | Picking    | VA03  | ASO Numbers |          92815403 |  453561440013 | ServiceAgent | ServiceTechnician | Quote Admin      | ServiceTechnician | MasterDataAdmin | Automation Technician User | Installation | Installation |
