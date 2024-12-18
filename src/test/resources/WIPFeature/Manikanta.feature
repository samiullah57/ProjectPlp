Feature: One Ems

  #Need one Custom Agent user
  #Need one Custom RSE user added to the queue
  # Asset with covered by Contract with RMSE characteristic
  # SAP Part pending after closing the Case
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
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "implementor"
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
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to create Response on  Action Plan
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on option "Edit"
    And I choose to enter BU Status
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to change the status to "Monitoring"
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL3"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to enter release Date
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on option "Edit"
    And I choose to enter Expected fix date
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL2"
    And I Choose to open the Escalation Created
    And I choose to click on option "Edit"
    And I choose to change the status to "Workaround"
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomRSEL1"
    And I Choose to open the Escalation Created
    And I choose to click on option "Close Case"
    And I Choose to enter EscalationClose Details
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"
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
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "L3"
    And I choose to verify email "implementor"

    Examples: 
      | Asset    | RecordType |
      | 73426045 | Case - New |

  #Create Custom HISS User with SAp employee ID, Custom HISS L1,Custom HISS L2,Custom HISS L3 Users and add them to HongKong territory,and add them to respective queues
  #Get the Asset with Hong kong shipping  address
  #Create contact with Test in contact name
  Scenario Outline: 439779 : OneEMS Regression – Test to verify OneEMS case closure of service type ‘Remote Service
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "CustomHISSGen"
    And I choose to search the "<Asset>"
    And I choose to open the asset "<Asset>"
    And I choose to click on New Case
    And I choose select Case record type "<RecordType>"
    And I choose to enter case Details
    And I Choose to click on NewRemoteLabour
    And I choose to click on New Escalation
    And I choose to enter escalation details
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L1"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomHISSL1"
    And I choose to search open the escalation Created case
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    And I choose to search open the escalation Created case
    And I choose to click on option "Edit"
    And I choose to change customer temperature to "Yellow"
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L2"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomHISSL2"
    And I choose to search open the escalation Created case
    And I choose to click on option "Accept Escalation"
    And I choose to verify the Alert "Accept"
    And I choose to search open the escalation Created case
    And I choose to click on option "Edit"
    And I choose to change customer temperature to "Red"
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to click on option "Edit"
    And I choose to enter Implementor
    And I choose to click on option "Route Escalation"
    And I choose to route Escalation to "L3"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomHISSL3"
    And I choose to search open the escalation Created case
    And I choose to click on option "Edit"
    And I choose to enter rejection situation
    And I choose to click on option "Reject Escalation"
    And I choose to verify the Alert "Reject"
    And I choose to verify email "L1"
    And I choose to verify email "L2"
    And I choose to verify email "implementor"
    And I choose to click on logout
    When I Choose to enter credentials for "CustomHISSL1"
    And I choose to search open the escalation Created case
    And I choose to click on option "Close Case"
    And I Choose to enter EscalationClose Details
    And I choose to open primary case
    And I choose to verify case status "New"
    And I choose to change case owner to "manikantahissl1"
    And I choose to click on option "Safety Questions"
    And I choose enter questionery Answers for closing the case
    And I choose to click on option "Close Case"
    And I Choose to enter Close Details
    And I choose to verify case status "Fixed"

    Examples: 
      | Asset    | RecordType |
      | 73426045 | Case - New |

  @Safety
  Scenario Outline: Onsite work order with overlap time
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with"<EvenType>"and"<priorityType>"and"<ip>" with contact "Ester"
    When I Choose to Open Case and create safety questionnaire "No"
    #And I Chosse to verify SFMs are Enabled
    #And I choose to verify OverRide Cost Center is autopopulated
    When I Choose to Create Onsite Work Order SFM
    And I choose to get the WO1
    When I Choose to Initiate SWO
    And I choose to get SAP SWO Number
    And I choose to complete Parts Ordering with "<PartsOrdering>"
    And I choose to navigate to WO1
    And I choose to get ASO Number

    # Given I choose to login to SAP system
    #    When User enters T Code in SAP application as"<Tcode>"
    #    When I choose to enter ASO Number "<sheetname>"
    #    And I choose to deliver the order
    #    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    #    And I choose to do single part delivery
    #    And I choose to pack the order
    #    And I choose to Process Outbound Delivery
    #    And I choose to add Serial Number
    #    And I choose to click on Post Good Issue
    #    And I choose to verify whether the delivery has saved
    #    When I choose to close SAP Application
    # And I choose to verify Entitlement is true and Billing Type is blank
    #And I choose to click on "View Entitlement"
    #And I choose to verify warranty and Service/Maintenance as blank
    Examples: 
      | UserRole     | ServiceTechnician | EvenType | priorityType  | Technician  | country     | event     | subject  | Technicianuser      | testdata          | workData  | nontestData     | ip       | PartsOrdering | tabName3   | partnerTab | Tcode | sheetname   |
      | ServiceAgent | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | Netherlands | Confirmed | Training | Meena service user2 | createdWorkorders | worklines | NonWorkOrderUrl | 88752203 |  453561287451 | Packingtab | Picking    | VA03  | ASO Numbers |

  #  User should have an Active Account where ‘SMax Account Group’ is ZNCA type and the Override Cost Center is updated on the Custom Settings.
  # User should have one Operational Installed Product with Type System associated with the Account mentioned in test setup 3.
  # User should have a valid ‘Normal Spare Part’ present in ServiceMax and SAP.
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

    #Given I choose to login to SAP system
    #When User enters T Code in SAP application as"<Tcode>"
    #When I choose to enter ASO Number
    #And I choose to deliver the order
    #And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    #And I choose to do single part delivery
    #And I choose to pack the order
    #And I choose to update"<packing>"and"<identification>"values
    #And I choose to add Serial Number
    #	Then I choose to save the Delivery
    #	 And I choose switch back to login
    #When User enters T Code in SAP application as"<Tcode1>"
    #And I choose to select PGI for above created document
    #When I choose to close SAP Application
    #Then I choose to verify SAP document shipped to Work order
    #Then I Choose to Dispatch WO Using Service Board "<Technician>"
    #	And I choose to click on logout
    #When I Choose to enter credentials for "<serviceUser>"
    #Then I Choose to verify profile for Logged on user "<serviceUser>"
    #And I choose to navigate to WO1
    #When I choose to Initiate Travel SFM
    #When I Choose to Initiate Onsite SFM
    #And I choose to add Labour without Overlap
    #Then I choose Labour parts to"Delivered"
    #When I Choose to confirm open labors Returnable "<PartsOrdering>"
    #And I choose to verify Is billable is blank for "Labour"
    #And I choose to navigate to WO1
    #And I choose to verify Is billable is blank for "Parts"
    #Given I choose to login to SAP system
    #When User enters T Code in SAP application as"iw33"
    #When I choose to enter SWO Number
    #And I choose to verify Account Indicator
    #And I choose to verify account Indicator on Planner Actual comparision page
    Examples: 
      | UserRole     |deliver |AccountName             | serviceUser       | EvenType | priorityType  | Technician    | ip       |PartsOrdering|Tcode |tabName3     |partnerTab|packing|identification|Tcode1|
      | ServiceAgent |Delivered|PHILIPS IBERICA, S.A.U.|Meena1serviceuser  | Incident | Critical Need | Meena Tech2   | 88752203 |453561529871 |VA03  |itemOverview |Picking   |34     |ups           |VL02n|
  
