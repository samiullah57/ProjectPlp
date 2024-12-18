Feature: SAP Integrated Test scripts

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
    And I choose too verify profile Permission Sets
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
    And I choose too verify profile Permission Sets
    And I click on Accounts Tab
    And I choose to create new Account
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<EIMVendor>"
    Then I Choose to verify profile for Logged on user "<EIMVendor>"
    And I choose too verify profile Permission Sets
    And I choose to click on All Tabs
    And I choose to create "Vendor" record
    Then I Choose to log out of the application
    And I Choose to enter credentials for "<ServiceAgent>"
    Then I Choose to verify profile for Logged on user "<ServiceAgent>"
    And I choose too verify profile Permission Sets
    When I choose to search for Account using Search Criteria
      | Account Name | contains | CELTA |
    When I choose to Create Contact from Account
    Then I choose to verify the Integration status "<Integration Status>" and SAP external ID
    Then I Choose to log out of the application

    #Given I choose to login to SAP system
    #When User enters T Code in SAP application as"<Tcode>"
    #Then I choose to verify contact details created in SMAX
    Examples: 
      | EIMUser | Create New Account | Object Name | Object Name2 | EIMCustomer | Create New Account2 | EIMHR | EIMVendor | ServiceAgent | Integration Status  |
      | EIMUser | No                 | Technician  | Vendors      | EIMCustomer | Yes                 | EIMHR | EIMVendor | ServiceAgent | Sent to SAP Success |

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
    #When I Choose to Generate Quote PDF SFM
    When I Choose to Accept Quote
    Then I verify Debit Memo Integration Status "<dmrStatus>"
    When I choose to verify Partners
    When I Choose to Amend Quote
    When I Choose to Release Quote SFM
    Then I choose to verify Quote status as "<quoteStatus>"
    #When I choose to approve quote line items
    # When I Choose to Approve Quote
    #When I Choose to Generate Quote PDF SFM
    When I Choose to Accept Quote
    Then I verify Debit Memo Integration Status "<dmrStatus>"
    When I choose to verify Partners
    Then I Choose to log out of the application

    #Then I verify that Prepayment Document Reference Number is received in SMAX from SAP
    Examples: 
      | AgentUser | IP       | SFM             | type | clickSFM            | quoteStatus               | dmrStatus                   |
      | AgentUser | 88259004 | Request a Quote | Case | Send to Back Office | Pending Discount Approval | Debit memo creation success |

  @438548
  Scenario Outline: 438548 :F16949 - DX Cross Border – To verify flow cross border contract postings from SMax-MP1 for a non-legacy contract
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
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<TCode>"
    When User enters SAPSWO nubmer gererated in servicemax
    When User access Operations Tab
    Then User Verifies the values present in Operations Tab
    When User Clicks on Enhancement Button
    #Then User Verifies Enhanceent Details
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
      | MasterDataAdmin | CON0070254 |          34155319 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /ova43 |

  @574840
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
    When I CHoose to Capture Work Order Number "WO2"
    #When I Choose to Search WorkOrder "WorkOrder1" using global search box
    #When I Choose to Open WorkOrder "WorkOrder1" from the search result
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
    Given I choose to login to SAP system
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
    Given I choose to login to SAP system
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
    Then I choose to verify SAP document shipped to Work order
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    And I choose to click on logout
    When I Choose to enter credentials for "<serviceUser>"
    And I choose to navigate to WO1
    When I Choose to Initiate Onsite SFM
    And I choose to add Labour without Overlap
    Then I choose Labour parts to"Delivered"
    When I Choose to confirm open labors Returnable "<PartsOrdering>"
    And I choose to verify Is billable is blank for "Labour"
    And I choose to navigate to WO1
    And I choose to verify Is billable is blank for "Parts"
    Then I Choose to log out of the application
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"/niw33"
    When I choose to enter SWO Number
    And I choose to verify Account Indicator
    And I choose to verify account Indicator on Planner Actual comparision page
    When I choose to close SAP Application

    Examples: 
      | UserRole     | deliver   | AccountName             | serviceUser       | EvenType | priorityType  | Technician  | ip       | PartsOrdering | Tcode | tabName3     | partnerTab | packing | identification | Tcode1 |
      | ServiceAgent | Delivered | PHILIPS IBERICA, S.A.U. | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | 88752203 |  453561529871 | VA03  | itemOverview | Picking    |      34 | ups            | VL02n  |
