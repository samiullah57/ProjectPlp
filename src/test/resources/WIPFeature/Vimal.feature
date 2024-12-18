Feature: To Demonstrate serviceMax and SAP related Utilities using Selenium and LeanFT

  #CON0070254/69338662  --0116621553/WO-02547384/
  @438548 @438549
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
      | MasterDataAdmin | CON0070254 |          69338662 | ServiceAgent | ServiceTechnician | Meena1serviceuser | MasterDataAdmin | Meena Tech2 | Incident  | Incident     | iw33  | /ova43 |

  #      | MasterDataAdmin|CON03521018|69338662         | ServiceAgent | ServiceTechnician |Meena1serviceuser| MasterDataAdmin | Meena Tech2    | Incident  | Incident     | iw33  | /ova43 |

  Scenario Outline: 438541: PM Plans creation using warranty
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    Then I choose to get the warranty and the template
    And I choose get the url details and save
    Then I choose to verify the task template and execution value
    Then I choose to navigate back to ip
    Then I choose to verify the ip status date installed
    Then I choose to select the product from ip
    Then I choose to create new applicable product

    Examples: 
      | UserRole        | Installed Product | ServiceAgent |
      | MasterDataAdmin |          88812565 | ServiceAgent |

  #      AFter Batch job “Create PM Plan from Offering”
  @438541-1
  Scenario Outline: 438541: PM Plans creation using warranty
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceAgent>"
    Then I Choose to verify profile for Logged on user "<ServiceAgent>"
    Then I choose to navigate to productwarranty form ip "<savedDetailsSheet>"
    Then I Choose to open PM plan in preventive maintenance list
    Then I Choose to verify PM plan start date and the fields
    Then I choose to navigate to account from PM plan
    Then I choose to create contact and save from account
    Then I choose to navigate back to PM plan
    Then I choose to select the created contacted in above step
    Then I choose to verify schedule and maintenance coverages
    Then I choose to verify PM Schedule is created
    When I Choose to enter credentials for "<BGPersonneluser>"
    Then I choose to open the template from global search
    Then I choose to select Manage Preventive Maintainance PM Template
    #Then I choose to verify PM frequency and grace field editable
    Then I choose to verify PM Frequency corresponding grace period
    When I Choose to enter credentials for "<MasterDataAdmin>"
    Then I choose to navigate to productwarranty
    Then I choose to select the first record from PM Schedule
    Then I choose to verify the values displaying correctly
    Then I choose to update due date with past and save
    Then I choose to verify the updated values displaying
    Then I choose to slect the record from PM schedule definition
    Then I choose to verify values updated from PM schedule
    Then I choose to select the first record from PM Schedule
    Then I choose to update due date with future and save
    Then I choose to verify the validation error message
    Then I choose to verify the PM plan status is blank
    Then I choose to navigate back to PM plan
    Then I choose to click PM proposal in PM plan
    Then I choose to enter mandatory details and submit
    Then I choose to navigate back to PM plan
    #Then I choose to verify CFD generated in notes section
    Then I choose to Activate PM plan on PM plan page
    Then I choose to verify the status is changed to active

    Examples: 
      | Installed Product | MasterDataAdmin | savedDetailsSheet | BGPersonneluser |
      |          69338662 | MasterDataAdmin |            438541 | BGPersonneluser |

  #      AFter Batch job “Create Case and Work orders”
  @438541-2
  Scenario Outline: 438541: PM Plans creation using warranty
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceAgent>"
    Then I choose to fetch the url from sheet "<savedDetailsSheet>"
    Then I Choose to open PM plan in preventive maintenance list
    Then I choose to select the first record from WO Schedule
    Then I choose to verify the values displaying correctly

    Examples: 
      | Installed Product | ServiceAgent | savedDetailsSheet |
      |          69338662 | ServiceAgent |            438541 |
