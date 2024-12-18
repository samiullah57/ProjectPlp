Feature: To Demonstrate serviceMax and SAP related Utilities using Selenium and LeanFT

  @438551
  Scenario Outline: 438551: Installed Product updated in ServiceMax and verify the change reflects in SAP within 15 Minutes
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to verify profile for Logged on user "<UserRole>"
    When I Choose to Search "<IP>" using global search box
    And I choose to select the IP
    Then I choose to update"<status>""<location>"and"<account>"
    And I choose to select view customer Information
    Then I choose to get Account Number
    Then I Choose to log out of the application
    Given I choose to login to SAP system
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
    Given I choose to login to SAP system
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
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode>"
    And I choose to Enter Equipment number"<IP>"
    And I choose to select tab"<structureTab>"and"<tableName>"
    Then I choose to verify Functional location
    When I choose to close SAP Application

    Examples: 
      | UserRole        | IP       | status           | location   | account    | Tcode | structureTab | tableName       | salesTab               |
      | MasterDataAdmin | 33271378 | AVLB - Available | 0009486701 | 0009486701 | IE03  | Structure    | CreateEquipment | Sales and Distribution |

  #   | MasterDataAdmin | 14189810 | AVLB - Available | 0009486701 | 0009486701 | IE03  | Structure    | CreateEquipment | Sales and Distribution |
  @438552
  Scenario Outline: 438552:Automation Initial Registration of 3rd party devices based on a load file.
    Given I choose to login to SAP system
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
    Given I choose to login to SAP system
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
    Given I choose to login to SAP system
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

  @454346
  Scenario Outline: 454346:Test to check ZSID part can be returned & consumed and Case activity creation.
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<agentRole>"
    Then I Choose to verify profile for Logged on user "<agentRole>"
    When I Choose to Search "<ip>" using global search box
    Then I choose to verify Product is ZSID
    And I choose to select the IP
    And I choose to create new case with"<EvenType>"and"<priorityType>"and contact"<contact>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM
    And I choose to get the WO1
    And I choose to get Case number
    When I Choose to Initiate SWO
    Then I choose to verify SAP SWO
    Then I choose to add Parts and verify
    And I choose to get ASO Number
    Then I Choose to log out of the application
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
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<agentRole>"
    Then I Choose to verify profile for Logged on user "<agentRole>"
    And I choose to navigate to WO1
    Then I choose to verify SAP document shipped to Work order
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<serviceUser>"
    Then I Choose to verify profile for Logged on user "<serviceUser>"
    And I choose to navigate to WO1
    When I choose to Initiate Travel SFM
    When I Choose to Initiate Onsite SFM
    And I choose to add Labour without Overlap
    Then I choose Labour parts to"<deliver>"
    And I choose to open parts for non returnable
    And I choose to open parts returnable"<consume>"and"<rml>"
    And I choose to select Record tool as not required
    And I choose to Debrief work oder and follow up
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<agentRole>"
    Then I Choose to verify profile for Logged on user "<agentRole>"
    And I choose to navigate to case Number
    And I choose select Create case activity
    Then I choose to verify Type values and Update
    Then I choose to verify the created Case Activites
    Then I choose to verify encripted PHI data
    And I choose to select case"<caseValue>"
    Then I choose to verify Create case acitvity is disabled
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<agentRole>"
    Then I Choose to verify profile for Logged on user "<agentRole>"
    And I choose to select case"<caseValue1>"
    Then I choose to verify Safety question
    And I choose to update CA to pickedUP
    And I choose to Escalate stakeholder Info
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
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

  @TestData_Workorder @meena
  Scenario Outline: 440742:Onsite work order with overlap time
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with"<EvenType>"and"<priorityType>"and"<ip>" with contact "Ester"
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
    Then I choose to get the work line details"<workData>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<UserRole>"
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    And I choose to get the created Non work order link"<nontestData>""<subject>""<Technicianuser>"
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | EvenType | priorityType  | Technician  | country     | event     | subject  | Technicianuser      | testdata          | workData  | nontestData     | ip       |
      | ServiceAgent | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | Netherlands | Confirmed | Training | Meena service user2 | createdWorkorders | worklines | NonWorkOrderUrl | 62784521 |

  @TestData_WorkorderNonOverlap @test
  Scenario Outline: 440742:Onsite work order with out overlap  date and time
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with"<EvenType>"and"<priorityType>"and"<ip>" with contact "Aldo D'Alessandro"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM
    Then I choose to get created Work order Number"<testdata>""<Technicianuser>"
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to get the above created Work order
    #Then I choose to get the work line details"<workData>"
    When I choose to Initiate Travel SFM
    When I Choose to Initiate Onsite SFM
    And I choose to add Labour without Overlap
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | EvenType | priorityType  | Technician  | country     | event     | subject  | Technicianuser      | testdata            | workData  | ip       |
      | ServiceAgent | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | Netherlands | Confirmed | Training | Meena service user2 | nonOverlapWorkOrder | worklines | 62784521 |

  #  | ServiceAgent | Meenaserviceuser  | Incident | Critical Need | Meena Tech1 | Other   | Confirmed | Training | Meena Service USer MQ3 | nonOverlapWorkOrder | worklines | 62784521 |
  @Nonworkorder @test
  Scenario Outline: 440742:Non work order creation
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    And I choose to get the created Non work order link"<nontestData>""<subject>""<Technicianuser>"
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | country     | event     | subject  | Technicianuser        | testdata     |
      | ServiceAgent | Netherlands | Confirmed | Training | Automation Technician | Nonworkorder |

  @Timesheet
  Scenario Outline: 440742:Remote work order creation
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceManager1>"
    And I choose to get the created Non work order Number"<testdata>""<row>"
    Then I choose to verify the details displayed in Non work order page
    And I choose to get the created Non work order Number"<testdata>""<row>"
    Then I choose to verify the details displayed in Non work order page
    And I choose to navigate for Timesheet Object
    And I choose get the Timesheet Number
    Then I choose to verify technican name in Timesheet"<Technician>"
    Then I choose to verify Sataus and Delegate manager feild and update the Timesheet
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceManager1>"
    And I choose to navigate for Timesheet Object
    Then I choose to verify technican name in Timesheet"<Technician>"
    Then I choose to verify the Timesheet of serviceManager is not available
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceManager>"
    And I choose to navigate for Advanced user details
    Then I choose to verify Delegate manager field before changing value
    Then I choose set the Delegate Manager Name as"<TechnicianUser>"
    Then I Choose to log out of the application

    Examples: 
      | ServiceManager | ServiceManager1 | ServiceTechnician1 | TechnicianUser      | subject  | Technician  | testdata        | serviceManager      | row | row1 |
      | ServiceManager | SM1 User        | Meenaserviceuser   | Meena service user2 | Training | Meena Tech2 | NonWorkOrderUrl | ServiceManager User |   1 |    2 |

  @AfterdelegateManagerJobrun
  Scenario Outline: 440742:Remote work order creation
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceManager>"
    And I choose to navigate for Timesheet Object
    And I choose get the Timesheet Number
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceManager1>"
    And I choose to navigate for Timesheet Object
    Then I choose to verify the timesheets available
    Then I Choose to log out of the application

    Examples: 
      | ServiceManager | ServiceManager1 | ServiceTechnician1 | TechnicianUser      | subject  | Technician  | testdata        | serviceManager      | row | row1 |
      | ServiceManager | SM1 User        | Meenaserviceuser   | Meena service user2 | Training | Meena Tech2 | NonWorkOrderUrl | ServiceManager User |   1 |    2 |

  @profile
  Scenario Outline: 440742:NonWork order
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to navigate for Advanced user details
    Then I choose to verify permission set and profile
    And I choose to navigate back to Home page
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status>"
    Then I choose to verify Overlap checkbox
    Then I choose to verify work details are present with non overlap
    And I choose to select Timesheet
    And I choose to select Manage Daily hours
    And I choose to Enter the time and save"<activity>""<duration>"
    Then I choose to verify error message
    And I choose to Enter the time and save"<activity>""<duration1>"
    And I choose to select Non Work order link
    Then I choose to verify the Subject dropdown values
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician1>"
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    When I Choose to enter credentials for "<UserRole>"
    And I choose to get the created Non work order Number"<testdata>""<row>"
    Then I choose change the event to"<newevent>"
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | Technicianuser      | Technician  | country     | event     | subject       | Technicianuser        | testdata        | serviceManager      | duration | duration1 | activity | activity1 | duration2 | row | row1 | status | newevent  |
      | ServiceAgent | Meena1serviceuser | Meena service user2 | Meena Tech2 | Netherlands | Tentative | Internal Work | Automation technician | NonWorkOrderUrl | ServiceManager User |       12 |       0.5 | Training | Leave     |         4 |   3 |    4 | Open   | Confirmed |

  @AfterBatchrun
  Scenario Outline: 440742:After NonWork order confirmation batch run
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status>"
    And I choose to select Timesheet
    And I choose to select Manage Daily hours
    And I choose to select icon Under SFM
    And I choose to Enter the time and save"<activity1>""<duration2>"
    Then I choose to submit the Time sheet
    Then I choose to verify Eligible for CATS checkbox
    Then I Choose to log out of the application

    # waitfor bhoomi response
    Examples: 
      | UserRole     | ServiceTechnician | Technicianuser      | Technician  | country     | event     | subject       | Technicianuser        | testdata        | serviceManager      | duration | duration1 | activity | activity1 | duration2 | row | row1 | status |
      | ServiceAgent | Meena1serviceuser | Meena service user2 | Meena Tech2 | Netherlands | Tentative | Internal Work | Automation technician | NonWorkOrderUrl | ServiceManager User |       11 |       0.5 | Training | Leave     |         4 |   3 |    4 | Open   |

  @AfterBoomiResponse
  Scenario Outline: 440742:After NonWork order confirmation batch run
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status>"
    Then I choose to verify SAP responses on Timesheet
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceTechnician1>"
    And I choose to navigate for Advanced user details
    Then I choose to verify permission set and profile
    And I choose to navigate back to Home page
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status1>"
    Then I choose to verify Overlap checkbox
    Then I choose to verify Conflict flag
    And I choose to select Timesheet
    And I choose to select Manage Daily hours
    And I choose to select icon Under SFM
    And I choose to Enter the time and save"<activity>""<duration1>"
    And I choose to select Non Work order link
    Then I choose to verify the Subject dropdown values
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    And I choose to select Non Work order link
    Then I choose to create Non work order"<country>""<event>""<subject>""<Technicianuser>"
    When I Choose to enter credentials for "<UserRole>"
    And I choose to get the created Non work order Number"<testdata>""<row>"
    Then I choose change the event to"<newevent>"
    And I choose to get the created Non work order Number"<testdata>""<row1>"
    Then I choose change the event to"<newevent>"
    Then I Choose to log out of the application

    #wait for time entries job run
    Examples: 
      | UserRole     | ServiceTechnician | ServiceTechnician1 | Technicianuser      | Technician  | country     | event     | subject       | Technicianuser        | testdata        | serviceManager      | duration | duration1 | activity          | activity1 | duration2 | row | row1 | newevent  | status   | status1 | newevent  |
      | ServiceAgent | Meena1serviceuser | Sweetyserviceuser  | Meena service user2 | Meena Tech2 | Netherlands | Tentative | Internal Work | Automation technician | NonWorkOrderUrl | ServiceManager User |       11 |       0.5 | Wait/Standby Time | Leave     |         4 |   3 |    4 | Confirmed | Approved | Open    | Confirmed |

  @MasterAdmin1
  Scenario Outline: 440742: After NonWork order confirmation batch run
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician1>"
    And I choose to navigate for Advanced user details
    Then I choose to verify permission set and profile
    And I choose to navigate back to Home page
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status>"
    Then I choose to verify Overlap checkbox
    Then I choose to verify Conflict flag
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<ServiceManager>"
    And I choose to get the created Non work order Number"<testdata1>""<row1>"
    Then I choose to verify the details displayed in Non work order page
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<MasterDataAdmin>"
    And I choose to get the created Work order"<testdata>""<WOrow>"
    And I choose to select the WorkLine created in above work order
    Then I choose to cancel work line and Save
    Then I choose to verify the status
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | ServiceTechnician1 | ServiceManager      | MasterDataAdmin      | country     | event     | subject       | testdata1       | testdata          | serviceManager      | duration | duration1 | activity          | activity1 | duration2 | row | row1 | newevent  | WOrow | status |
      | ServiceAgent | Meena1serviceuser | Meenaserviceuser   | ServiceManager User | MasterDataAdmin User | Netherlands | Tentative | Internal Work | NonWorkOrderUrl | createdWorkorders | ServiceManager User |       11 |       0.5 | Wait/Standby Time | Leave     |         4 |   3 |    4 | Confirmed |     6 | Open   |

  @MasterAdmin
  Scenario Outline: 440742:After NonWork order confirmation batch run
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status>"
    And I choose to select Timesheet
    And I choose to select Manage Daily hours
    And I choose to select icon Under SFM
    And I choose to Enter the time and save"<activity>""<duration1>"
    Then I choose to submit the Time sheet
    Then I choose to verify Eligible for CATS checkbox
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | ServiceTechnician1 | ServiceManager      | MasterDataAdmin      | country     | event     | subject       | testdata1       | testdata          | serviceManager      | duration | duration1 | activity          | activity1 | duration2 | row | row1 | newevent  | WOrow | status |
      | ServiceAgent | Meena1serviceuser | Sweetyserviceuser  | ServiceManager User | MasterDataAdmin User | Netherlands | Tentative | Internal Work | NonWorkOrderUrl | createdWorkorders | ServiceManager User |       11 |         1 | Wait/Standby Time | Leave     |         4 |   3 |    4 | Confirmed |     1 | Open   |

  @AfterBoomiResponsesucess
  Scenario Outline: 440742:After NonWork order confirmation batch run
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<status>"
    Then I choose to verify SAP responses on Timesheet
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | ServiceTechnician1 | Technicianuser      | Technician  | country     | event     | subject       | Technicianuser        | testdata        | serviceManager      | duration | duration1 | activity          | activity1 | duration2 | row | row1 | newevent  | status   | status1 |
      | ServiceAgent | Meena1serviceuser | Sweetyserviceuser  | Sweety Service user | Meena Tech2 | Netherlands | Tentative | Internal Work | Automation technician | NonWorkOrderUrl | ServiceManager User |       11 |       0.5 | Wait/Standby Time | Leave     |         4 |   3 |    4 | Confirmed | Approved | Open    |

  @CancelWL
  Scenario Outline: 440742:After NonWork order confirmation batch run
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<MasterDataAdmin>"
    And I choose to get the created Work order"<testdata>""<WOrow>"
    And I choose to select the WorkLine created in above work order
    Then I choose to cancel work line and Save
    Then I choose to verify the status
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to navigate to Time sheet page
    And I choose to select required time sheet"<UserRole>"
    And I choose to select Timesheet
    Then I choose to verify above deleted work line

    Examples: 
      | UserRole     | ServiceTechnician | ServiceTechnician1 | ServiceManager      | MasterDataAdmin      | country     | event     | subject       | testdata1       | testdata          | serviceManager      | duration | duration1 | activity          | activity1 | duration2 | row | row1 | newevent  | WOrow | status   |
      | ServiceAgent | Meena1serviceuser | Sweetyserviceuser  | ServiceManager User | MasterDataAdmin User | Netherlands | Tentative | Internal Work | NonWorkOrderUrl | createdWorkorders | ServiceManager User |       11 |         1 | Wait/Standby Time | Leave     |         4 |   3 |    4 | Confirmed |    24 | Approved |

  @remotework
  Scenario Outline: 440742:Remote work order creation
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with"<EvenType>"and"<priorityType>"and"<ip>" with contact "Ester"
    When I Choose to Open Case and create safety questionnaire "No"
    And I choose to Create Remote work order
    Then I choose to get created Work order Number"<remotedata>""<Technicianuser>"
    When I Choose to enter credentials for "<ServiceTechnician>"
    And I choose to get the above created Work order
    And I choose to Initiate Remote Service
    When I Choose to add Labor and Parts
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | ServiceTechnician | EvenType | priorityType  | Technician  | country     | event     | subject  | Technicianuser         | remotedata      |
      | ServiceAgent | Meenaserviceuser  | Incident | Critical Need | Meena Tech2 | Netherlands | Confirmed | Training | Meena Service USer MQ3 | RemoteworkOrder |
