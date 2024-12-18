Feature: Pipeline4 Phase1

 ##Provide new RML for every run
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
      | UserRole           | Workorder1  | TCode | RML        |
      | ServiceTechnician | WO-04663920 | mb03  | R000000136 |
      
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
   Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
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
      | UserRole        | Contract   | Installed Product | ServiceAgent | ServiceTechnician | L1TechnicianUser  | MasterAdmin     | Technician  | EventType | SubEventType | TCode | TCode2 |
      | MasterDataAdmin | CON0070254 |          33483466 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /nva43 |
@438549
  Scenario Outline: 438549: F16949 - DX Cross Border – To verify flow cross border contract postings from SMax-MP1 for a non-legacy contract

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
   Then I Choose to Dispatch WO Using Service Board "Automation Technician User"
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
      | UserRole        | Contract   | Installed Product | ServiceAgent | ServiceTechnician | L1TechnicianUser  | MasterAdmin     | Technician  | EventType | SubEventType | TCode | TCode2 |
      | MasterDataAdmin | CON0351018 |          58438644 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /nva43 |
      
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
   # When I Choose to open the Quote created from Case
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
   
    Then I Choose to log out of the application

    Examples: 
      | AgentUser | IP       | SFM             | type | clickSFM            | quoteStatus               | dmrStatus                   |
      | AgentUser | 77003537 | Request a Quote | Case | Send to Back Office | Pending Discount Approval | Debit memo creation success |
    