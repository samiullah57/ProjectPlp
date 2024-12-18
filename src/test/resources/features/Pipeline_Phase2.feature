Feature: Phase2 Automation R2R

  @652406
  Scenario Outline: 652406: RT for Supplementary Services Consultancy for Clinical On-Site
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "Quote Admin"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Supplementary Services" and Event Sub Type "Service Request" on Installed Product
    When I Choose to Request a Quote SFM "Draft"
    When I Choose to Release Quote SFM
    When I Choose to Generate Quote PDF SFM
    When I Choose to Approve Quote
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
      | UserRole            | IP       | ServiceTechnician        | MasterDataAdmin |
      | AutomationAgentUser | 88259004 | AutomationTechnicianUser | MasterDataAdmin |

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
      
      
