Feature: ServiceMAx

  @Onsite(incidentcase)
  Scenario Outline: 880000:Scenario 25a- F12427 - Tier to Tier Service Escalation for Supplementary Cases
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    ###  			quote admin- L1Technician
    When I Choose to Search "<ip>" using global search box
    And I choose to select the IP
    Then I choose to verify values of BG and BU on Product Page
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM for "2" hours
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    And I choose to get the WO1
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    And I choose to navigate to WO1
    And I choose to verify the Escalation Originated Work order should be unchecked
    # And I choose to Initiate Remote Service
    When I Choose to Initiate Onsite SFM
    Then I choose to click on Case created
    Then I choose to create a Escalation case
    Then I choose to verify Escalate case created
    Then I choose to verify Business group and Business unit
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    When I choose to navigate to Escalate case created
    Then I choose to Accept Escalate case
    Then I choose to verify Business group and Business unit
    Then I choose to create a New Action Request for L2-L3
    Then I choose to Accept Action Request
    Then I choose to verify the Action Request buttons are enabled
    Then I choose to close Action Request
    And I choose to navigate to WO1
    When I Choose to add Labor and Parts
    Then I choose to create Debrief and follow up
    Then I choose to complete work order
    Then I Choose to log out of the application
    #  			master admin
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<MasterAdmin>"
    And I choose to navigate to WO1
    Then I choose to change the status order to Fixed
    Then I Choose to log out of the application
    #  			  L2 52404222
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    And I choose to navigate to WO1
    Then I choose to click on Case created
    Then I choose to submit PSF Safety form
    Then I choose to update Escalation Details
    Then I choose to Cancel Escalation
    Then I choose to verify fields after Escalation Cancel
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser | MasterAdmin     | Technician     | EventType | SubEventType | ip       |
      | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician | L1 Technician    | L2 Technician    | MasterDataAdmin | L1 Techinician | Incident  | Incident     | 62784521 |

  @Remote(incidentcase)
  Scenario Outline: 880000:Scenario 25a- F12427 - Tier to Tier Service Escalation for Supplementary Cases
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    ###  			quote admin- L1Technician
    When I Choose to Search "<ip>" using global search box
    And I choose to select the IP
    Then I choose to verify values of BG and BU on Product Page
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Remote Work Order SFM
    And I choose to get the WO1
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    And I choose to navigate to WO1
    And I choose to verify the Escalation Originated Work order should be unchecked
    And I choose to Initiate Remote Service
    ##            When I Choose to Initiate Onsite SFM
    Then I choose to click on Case created
    Then I choose to create a Escalation case
    Then I choose to verify Escalate case created
    Then I choose to verify Business group and Business unit
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    When I choose to navigate to Escalate case created
    Then I choose to Accept Escalate case
    Then I choose to verify Business group and Business unit
    Then I choose to create a New Action Request for L2-L3
    Then I choose to Accept Action Request
    Then I choose to verify the Action Request buttons are enabled
    Then I choose to close Action Request
    And I choose to navigate to WO1
    When I Choose to add Labor and Parts
    Then I choose to create Debrief and follow up
    Then I choose to complete work order
    Then I Choose to log out of the application
    #  			master admin
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<MasterAdmin>"
    And I choose to navigate to WO1
    Then I choose to change the status order to Fixed
    Then I Choose to log out of the application
    #  			  L2 52404222
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    And I choose to navigate to WO1
    Then I choose to click on Case created
    Then I choose to submit PSF Safety form
    Then I choose to update Escalation Details
    Then I choose to Cancel Escalation
    Then I choose to verify fields after Escalation Cancel
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser | MasterAdmin     | Technician     | EventType | SubEventType | ip       |
      | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician | L1 Technician    | L2 Technician    | MasterDataAdmin | L1 Techinician | Incident  | Incident     | 62784521 |

  @remote(installationcase)
  Scenario Outline: 880000:Scenario 25a- F12427 - Tier to Tier Service Escalation for Supplementary Cases
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #####  			quote admin- L1Technician
    When I Choose to Search "<ip>" using global search box
    And I choose to select the IP
    Then I choose to verify values of BG and BU on Product Page
    When I choose to Perform Salesorder Check
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    ###  		    When I Choose to Open Case and create safety questionnaire
    When I Choose to Create Remote Work Order SFM
    And I choose to get the WO1
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    And I choose to navigate to WO1
    And I choose to verify the Escalation Originated Work order should be unchecked
    And I choose to Initiate Remote Service
    Then I choose to click on Case created
    Then I choose to create a Escalation case
    Then I choose to verify Escalate case created
    Then I choose to verify Business group and Business unit
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    When I choose to navigate to Escalate case created
    Then I choose to Accept Escalate case
    Then I choose to verify Business group and Business unit
    Then I choose to create a New Action Request for L2-L3
    Then I choose to Accept Action Request
    Then I choose to verify the Action Request buttons are enabled
    Then I choose to close Action Request
    And I choose to navigate to WO1
    When I Choose to add Labor and Parts
    Then I choose to create Debrief and follow up
    Then I choose to complete work order
    Then I Choose to log out of the application
    #  			master admin
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<MasterAdmin>"
    And I choose to navigate to WO1
    Then I choose to change the status order to Fixed
    Then I Choose to log out of the application
    #  			  L2 52404222
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    And I choose to navigate to WO1
    Then I choose to click on Case created
    #            Then I choose to submit PSF Safety form
    Then I choose to update Escalation Details
    Then I choose to Cancel Escalation
    Then I choose to verify fields after Escalation Cancel
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser | MasterAdmin     | EventType    | SubEventType | ip       |
      | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician | Quote Admin      | L2 Technician    | MasterDataAdmin | Installation | Installation | 62784521 |

  @Onsite(installationcase)
  Scenario Outline: 880000:Scenario 25a- F12427 - Tier to Tier Service Escalation for Supplementary Cases
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    ####  			quote admin- L1Technician
    When I Choose to Search "<ip>" using global search box
    And I choose to select the IP
    Then I choose to verify values of BG and BU on Product Page
    When I choose to Perform Salesorder Check
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    #           When I Choose to Open Case and create safety questionnaire
    When I Choose to Create Onsite Work Order SFM for "2" hours
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    And I choose to get the WO1
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    And I choose to navigate to WO1
    And I choose to verify the Escalation Originated Work order should be unchecked
    ##  	    And I choose to Initiate Remote Service
    When I Choose to Initiate Onsite SFM
    Then I choose to click on Case created
    Then I choose to create a Escalation case
    Then I choose to verify Escalate case created
    Then I choose to verify Business group and Business unit
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    When I choose to navigate to Escalate case created
    Then I choose to Accept Escalate case
    Then I choose to verify Business group and Business unit
    Then I choose to create a New Action Request for L2-L3
    Then I choose to Accept Action Request
    Then I choose to verify the Action Request buttons are enabled
    Then I choose to close Action Request
    And I choose to navigate to WO1
    When I Choose to add Labor and Parts
    Then I choose to create Debrief and follow up
    Then I choose to complete work order
    Then I Choose to log out of the application
    #  			master admin
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<MasterAdmin>"
    And I choose to navigate to WO1
    Then I choose to change the status order to Fixed
    Then I Choose to log out of the application
    #  			  L2 52404222
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    And I choose to navigate to WO1
    Then I choose to click on Case created
    #            Then I choose to submit PSF Safety form
    Then I choose to update Escalation Details
    Then I choose to Cancel Escalation
    Then I choose to verify fields after Escalation Cancel
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser | MasterAdmin     | Technician     | EventType    | SubEventType | ip       |
      | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician | L1 Techinician   | L2 Techinician   | MasterDataAdmin | L1 Techinician | Installation | Installation | 62784521 |

  @supplementaryremoteWo
  Scenario Outline: 880000:Scenario 25a- F12427 - Tier to Tier Service Escalation for Supplementary Cases
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    #  			quote admin- L1Technician
    When I Choose to Search "<ip>" using global search box
    And I choose to select the IP
    Then I choose to verify values of BG and BU on Product Page
    When I choose to Perform Salesorder Check
    When I choose to create a case of eventType is "<EventType>" and sub eventType is "<SubEventType>"
    #  		    When I Choose to Open Case and create safety questionnaire
    When I Choose to Create Remote Work Order SFM
    And I choose to get the WO1
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    And I choose to navigate to WO1
    And I choose to verify the Escalation Originated Work order should be unchecked
    And I choose to Initiate Remote Service
    Then I choose to click on Case created
    Then I choose to create a Escalation case
    Then I choose to verify Escalate case created
    Then I choose to verify Business group and Business unit
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to navigate to WO1
    Then I choose to click on Case created
    When I Choose to Create Remote Work Order SFM
    And I choose to get the WO2
    Then I Choose to log out of the application
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L1TechnicianUser>"
    And I choose to navigate to WO2
    And I choose to verify the Escalation Originated Work order should be unchecked
    Then I Choose to log out of the application
    #  			L2 user login
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    When I choose to navigate to Escalate case created
    Then I choose to Accept Escalate case
    Then I choose to create a New Action Request for L2-L3
    Then I choose to Accept Action Request
    Then I choose to verify the Action Request buttons are enabled
    Then I choose to close Action Request
    And I choose to navigate to WO1
    When I Choose to add Labor and Parts
    And I choose to navigate to WO1
    Then I choose to create Debrief and follow up
    Then I choose to complete work order
    Then I Choose to log out of the application
    #  			master admin
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<MasterAdmin>"
    And I choose to navigate to WO1
    Then I choose to change the status order to Fixed
    Then I Choose to log out of the application
    #  			  L2 52404222
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<L2TechnicianUser>"
    And I choose to navigate to WO1
    Then I choose to click on Case created
    #            Then I choose to submit PSF Safety form
    Then I choose to update Escalation Details
    Then I choose to Cancel Escalation
    Then I choose to verify fields after Escalation Cancel
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Contract   | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser | MasterAdmin     | Technician     | EventType    | SubEventType | ip       |
      # | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician | Quote Admin      | ServiceTechnician | MasterDataAdmin | L1 Techinician | Supplementary Services | Service Request |62784521|
      | ServiceAgent | CON0100457 | ServiceAgent | ServiceTechnician | L1 Techinician   | L2 Techinician   | MasterDataAdmin | L1 Techinician | Installation | Installation | 62784521 |

 @716151PreRequisite
  Scenario Outline: 716151:CSP_Account Assignment and Authorization driven CS Portal functionalities covering Cases, Account, Locations, Installed Product, Contracts, Warranties, Reports, Calendar modules.
    Given I launch Salesforce application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I choose to click on All Tabs
    Then I choose to click on CS Portal User Assignment
    Then I choose to search portal with "<PortalName>"
    Then I choose to select Exclude/Include IP button and Include "<IP>"

    Examples: 
      | UserRole     | PortalName         | IP       |
      | ServiceAgent | Demo Portal User 1 | 50987090 |

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
      | UserRole     | Recordtype          | grouptype1 | grouptype2 | country | AccountName1                        | AccountName2                       | PortalName         | Portal user | IPTab              | IPID     | HomeTab | dropdownvalue     						         | CasesTab | type      | AccountTab | IPForPlannedvisit | IPForSLCPVerification | dropdownvalue2         | Prioritytype | type2     | LocationTab | LocationName        		 | ContractTab           | ContactUs  | My Profile | CasesTab | DocumentsTab | ReportsTab | value            | accName | casenumber | ProfileName |
      | ServiceAgent | Master Group Header | Super      | Group      | ES      | C.S.I. UNIVERSITARIA DE BELLVITGEAB | A.O. PAPA GIOVANNI XXIII | Demo Portal User 1 | PortalUser  | Installed Products | 50987090 | Home    | Request Technical or Clinical Support | Cases    | Technical | Account    |          50987090 |              50987090 | Parts Order for Repair | Medium       | Education | Locations   | A.O. PAPA GIOVANNI XXIII | Contract And Warranty | Contact us | My Profile | Cases    | Documents    | Reports    | Standard Reports | Gadsden Regional Medical Center | 0116441834 | Tanveer Automation |

  @Salesordercreation
  Scenario Outline: salesordercreation testdata
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode>"
    And I choose to select sales Orgainsation"<Ordertype>""<organisation>""<channel>""<division>"
    And I choose to Enter Billing and shipping as"<billing>""<shipping>"
    And I choose to enter "<Soldto>" and "<shipTo>"
    And I choose to enter Material value"<material>"
    Then I choose to save the Sales order

    Examples: 
      | system | SOtabName     | Tcode | Ordertype | organisation | channel | division | billing | shipping | Soldto   | shipTo   | material     | code   |
      | MQ3    | Item overview | Va01  | ZSO       | US90         | US      |       30 | OR      | DIR      | 94068894 | 94068894 | 989803104161 | /nva03 |

  @438546 @Srini
  Scenario Outline: 438546 : Determination of Sales Org and Service Plant for DX indent order other than 37 customer Group
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enters SAP Order nubmer "<salesorder>"
    And I choose to click on Header details icon
    And I choose to Verify the field sales area data with values "<SA1>", "<SA2>" and "<SA3>"
    And I choose to verify the field customer group "<Customer Group>" and SalesOffice under Sales tab are populated
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to verify that Business Area is populated
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode2>"
    And I choose to enter the Table name"<TableName>"
    And I choose to enter the salesorg "<SA1>" , DistrChannel "<SA2>" and Customergrp "<CG>"
    And I choose to click on execute icon
    And I choose to Verify there is a column Business Area and Customer Group
    And I choose to select the row and click on choose icon "<Tablerow>"
    And I choose to Verify the value of Plant Service and Service Org
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode3>"
    And I choose to enter tablename "<Tablename2>" in general table display page
    And I choose to enter Document Number "<salesorder>"
    And I choose to click on execute icon
    And I choose to verify Plantservice and serviceorg in this general Table with "<SA1>"
    When I choose to close SAP Application

    Examples: 
      | system | Tcode | salesorder | SA1  | SA2 | SA3 | Customer Group | Tcode2 | TableName | Tablename2 | CG | partnerTab         | tabName3       | BA | Tcode3  | Tablerow  |
      | MQ3    | VA03  | 6600503139 | DX96 | DX  | MS  | 37 Distributor | /nse16 | ZUSERVICE | ZUENRICH   | 04 | Account assignment | partnerTabVA43 | AE | /nse16n | ZUService |

  @438545 @Srini
  Scenario Outline: 438545: Determination of Sales Org and Service Plant for distributor type 37 sales Order
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enters SAP Order nubmer "<salesorder>"
    And I choose to click on Header details icon
    And I choose to Verify the field sales area data with values "<SA1>", "<SA2>" and "<SA3>"
    And I choose to verify the field customer group "<Customer Group>" and SalesOffice under Sales tab are populated
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to verify that Business Area is populated
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode2>"
    And I choose to enter the Table name"<TableName>"
    And I choose to enter the salesorg "<SA1>" , DistrChannel "<SA2>" and Customergrp "<CG>"
    And I choose to click on execute icon
    And I choose to Verify there is a column Business Area and Customer Group
    And I choose to select the row and click on choose icon "<Tablerow>"
    And I choose to Verify the value of Plant Service and Service Org
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode3>"
    And I choose to enter tablename "<Tablename2>" in general table display page
    And I choose to enter Document Number "<salesorder>"
    And I choose to click on execute icon
    And I choose to verify Plantservice and serviceorg in this general Table with "<SA2>"
    When I choose to close SAP Application

    Examples: 
      | system | Tcode | salesorder | SA1  | SA2 | SA3 | Customer Group | Tcode2 | TableName | Tablename2 | CG | partnerTab         | tabName3       | BA | Tcode3  | Tablerow    |
      | MQ3    | VA03  | 6600502471 | DX96 | DX  | MS  | 37 Distributor | /nse16 | ZUSERVICE | ZUENRICH   | 37 | Account assignment | partnerTabVA43 | RO | /nse16n | ZUService_1 |

  @438547 @Srini
  Scenario Outline: 438547 : Determination of Sales Org and Service Plant for an MP1 country
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode>"
    When I choose to enters SAP Order nubmer "<salesorder>"
    And I choose to click on Header details icon
    And I choose to Verify the field sales area data with values "<SA1>", "<SA2>" and "<SA3>"
    And I choose to verify the field customer group
    And I choose to select AccAssignemnt tab"<partnerTab>"and"<tabName3>"
    And I choose to verify that Business Area should be null
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode2>"
    And I choose to enter the Table name"<TableName>"
    And I choose to enter the salesorg "<SA1>" , DistrChannel "<SA2>" and Customergrp "<CG>"
    And I choose to click on execute icon
    And I choose to Verify there is a column Business Area and Customer Group
    And I choose to select the row and click on choose icon "<Tablerow>"
    And I choose to Verify the value of Plant Service and Service Org
    And I choose switch back to login
    When User enters T Code in SAP application as"<Tcode3>"
    And I choose to enter tablename "<Tablename2>" in general table display page
    And I choose to enter Document Number "<salesorder>"
    And I choose to click on execute icon
    And I choose to verify Plantservice and serviceorg in this general Table with "<SA2>"
    When I choose to close SAP Application

    Examples: 
      | system | Tcode | salesorder | SA1  | SA2 | SA3 | Tcode2 | TableName | Tablename2 | CG | partnerTab         | tabName3       | BA | Tcode3  | Tablerow    |
      | MQ3    | VA03  | 6600398554 | CN90 | CN  | MS  | /nse16 | ZUSERVICE | ZUENRICH   |    | Account assignment | partnerTabVA43 | RO | /nse16n | ZUService_1 |
#@TestdatacreationIncluded
  @436906 
  Scenario Outline: 436906:New System DEFOA Posting with Installation case type
    get ASONumber SWONumber ------ Testdata1
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
    Given I choose to login to SAP system
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
    And I choose to receive the Parts
    When I Choose to Initiate Onsite SFM
    When I Choose to add Labor and Parts
    When I Choose to confirm open labors Returnable "<PartsOrdering>"
    And I choose to navigate to WO1
    And I choose to verify the Valuation from Confirmed and Returned Parts
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode1>"
    When I choose to enter SWO Number
    And I choose to navigate to Goods Movements
    And I choose to validate MovementType and Batch
    When I choose to close SAP Application

    Examples: 
      | UserRole     | UserRole1         | Contract   | Tcode1 | tabName3   | partnerTab | Tcode | sheetname   | Installed Product | PartsOrdering | ServiceAgent | ServiceTechnician | L1TechnicianUser | L2TechnicianUser  | MasterAdmin     | Technician  | EventType    | SubEventType |
      | ServiceAgent | Meena1serviceuser | CON0100457 | IW33   | Packingtab | Picking    | VA03  | ASO Numbers |          66335345 |  453561440013 | ServiceAgent | ServiceTechnician | Quote Admin      | ServiceTechnician | MasterDataAdmin | Meena Tech2 | Installation | Installation |

  @part1, @438540
  Scenario Outline: 438540: Contract Management: Contract creation, Activation, price condition verification, PM plan creation, PM cases and work order creation, expiring the contract and verifying it is not considered in entitlement
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose to Search "<Installed Product>" using global search box
    When I Choose to Open "<Installed Product>" Installed Product Detail page and verify Account
    Then I choose to click on Account
    Then I choose to Create New Contract Header
    Then I choose to Create Contract with "<Billingplantype>"
    Then I choose to enter Total and SAP Contract price "<TCP>" "<SCP>"
    Then I choose to Edit Coverage with "<Installed Product>"
    Then I choose to verify Billing Plan Type and Inadvance
    Then I choose to verify the date rule error when Billing plan type is Periodic and date rules are empty
    Then I choose to change the Billing Plan Type to Milestone and verify the Error of date rule
    Then I choose to click on Send To SAP
    Then I choose to verify SAP Integration status
    Then I choose to create New Billing plan Line
    Then I choose to click on Active contract
    Then I choose to change the Contract by updating SAP Condition Price
    Then I choose to verify SAP Integration status
    Given I choose to login to SAP system
    When User enters T Code in SAP application as"<Tcode1>"
    When I choose Search contract
    Then I choose to verify the Netvalue with Total Contract Price
    When I choose to close SAP Application

    Examples: 
      | UserRole        | Installed Product | Tcode1 | Billingplantype | Billingplantype1 | TCP | SCP |
      | MasterDataAdmin |          88812565 | VA43   | Periodic        | Milestone        | 100 | 100 |

  #    Wait for batch job to create PM Plans
  @part2 @438540
  Scenario Outline: 438540: Contract Management: Contract creation, Activation, price condition verification, PM plan creation, PM cases and work order creation, expiring the contract and verifying it is not considered in entitlement
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I choose to get contract Details Page the created "<urlsheetname>"
    Then I choose to Active the PM Plan

    Examples: 
      | UserRole        | urlsheetname |
      | MasterDataAdmin | CHURL        |

  #    Wait for the batch job to create PM case and work order. 88753684
  @part3 @438540
  Scenario Outline: 438540: Contract Management: Contract creation, Activation, price condition verification, PM plan creation, PM cases and work order creation, expiring the contract and verifying it is not considered in entitlement
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I choose to get contract Details Page the created "<urlsheetname>"
    Then I choose to verify whether Work order and cases got created under PMPlan

    Examples: 
      | UserRole        | urlsheetname |
      | MasterDataAdmin | CHURL        |

  @part4
  Scenario Outline: 438540: Contract Management: Contract creation, Activation, price condition verification, PM plan creation, PM cases and work order creation, expiring the contract and verifying it is not considered in entitlement
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole1>"
    Then I choose to get contract Details Page the created "<urlsheetname>"
    Then I choose to Create Contract with "<Billingplantype1>"
    Then I choose to enter Total and SAP Contract price "<TCP>" "<SCP>"
    Then I choose to click on Send To SAP
    Then I choose to verify SAP Integration status
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to create new case with"<EvenType>"and"<priorityType>"and"<Installed Product>" with contact "Ester"
    When I Choose to Open Case and create safety questionnaire "No"
    Then I choose to verify the PSE should unchecked on case detailpage
    Then I choose to Request Quote
    Then I choose to add Labors
    Then I choose to Edit the quote and make status to draft
    Then I choose to Release quote
    Then I choose to Accept quote
    When I Choose to Open Case Detail Page
    And I choose to Create Remote work order
    When I Choose to Open Case Detail Page
    Then I choose to verify the Service Maintenance Contarct Field should not get populated with value

    Examples: 
      | UserRole    | Installed Product | Tcode1 | Billingplantype1 | TCP | SCP  | serviceuser       | EvenType | priorityType  | urlsheetname | UserRole1       |
      | Quote Admin |          88812565 | VA43   | Milestone        | 200 | 1000 | ServiceAgent User | Incident | Critical Need | CHURL        | MasterDataAdmin |
