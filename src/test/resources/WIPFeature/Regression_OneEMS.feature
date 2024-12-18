Feature: OneEMS Regression

  #SAP Integrated TC - Execution in VAS - SAP Part pending after closing the Case
  #1. Tester must have access to “OneEMS” with profile ‘Custom - Agent'.
  #2. Tester must have access to “OneEMS” with ‘Custom – RSE’ with valid SAP Employee ID
  #3. Tester must have Asset covered by Contract with RMSE characteristic
  #4. Add ‘Custom – RSE’ user to a Queue as per test data
  @439692
  Scenario Outline: 439692: OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service
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
    #And I choose to select Queue and Dispatch
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSE"
    And I choose to search the "<Asset>"
    And I Choose to open the case Created
    And I choose to click on option "Accept"
    And I choose to enter T2Activites
    And I Choose to open the case Created
    And I Choose to Choose to verify Case Activity Picklist
    And I Choose to open the case Created
    #And I Choose to click on NewRemoteLabour
    #And I choose to click on option "Close Case"
    #And I Choose to enter Close Details
    #And I choose to click on logout

    Examples: 
      | Asset    | RecordType |
      | 35921693 | Case - New |

  #Create Custom RSE L1,Custom RSE L2,Custom RSE L3 Users and add them to HongKong territory,and add them to respective queues
  #Get the Asset with Hong kong shipping  address
  #Create contact with Test in contact name
  @439779
  Scenario Outline: 439779 : OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service
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
