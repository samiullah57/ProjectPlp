Feature: Regression Test Case for SMax and SAP

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

  
  