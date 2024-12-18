Feature: Phase1 Pipeline3

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
    When I Choose to capture 'ASO number'
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "VA03" T Code in the I2M SAP application
    When I Choose to Search "ASO-Item" in Order Field
    When I Choose to Click "Item-Overview" Tab of "ASO-Item" Window
    When I Choose to Select ASO Item
    When I Choose to Select "Sales Document and Deliver" Menu Item
    When I Choose to Click "Picking" Tab of "ASO-Delivery" Window
    When I Choose to Update Picking Quantity
    When I Choose to Select "Extras Serialize Number" Menu Item
    When I Choose to Pack ASO Delivery Items
    When I Choose to Update Packing Materials
    When I Choose to update Identification in ASO Delivery Handling
    When I Choose to Click on Back Menu Bar
    When I Choose to Pack each ASO Delivery Items
    When I Choose to enter "/nvl02n" Delivery in the SAP application
    When I Choose to Search "ASO-Delivery" in Order Field
    When I Choose to Post ASO Goods Issues
    When I choose to close SAP Application
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<serviceUser>"
    And I choose to navigate to WO1
    When I Choose to Initiate Onsite SFM
    And I choose to add Labour without Overlap
    Then I choose Labour parts to"Delivered"
    When I Choose to confirm open labors Returnable "<PartsOrdering>"
    And I choose to verify Is billable is blank for "Labour"
    And I choose to navigate to WO1
    And I choose to verify Is billable is blank for "Parts"
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When User enters T Code in SAP application as"/niw33"
    When I choose to enter SWO Number
    And I choose to verify Account Indicator
    And I choose to verify account Indicator on Planner Actual comparision page
    Then I Choose to log out of the application
    When I choose to close SAP Application

    Examples: 
      | UserRole     | deliver   | AccountName                   | serviceUser              | EvenType | priorityType  | Technician                 | ip       | PartsOrdering | Tcode | tabName3     | partnerTab | packing | identification | Tcode1 |
      #  | ServiceAgent | Delivered | PHILIPS IBERICA, S.A.U. | Meena1serviceuser | Incident | Critical Need | Meena Tech2 | 88752203 |  453561440013 | VA03  | itemOverview | Picking    |      34 | ups            | VL02n  |
      | ServiceAgent | Delivered | SUNWAY MEDICAL CENTRE SDN BHD | AutomationTechnicianUser | Incident | Critical Need | Automation Technician User | 70828479 |  453561440013 | VA03  | itemOverview | Picking    |      34 | ups            | VL02n  |

  @437325
  Scenario Outline: 437325: Scenario32 - Test to verify SLA metrics with respect to case and WO and automatic generation of CSR on case closure.
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    When I Choose to 'Parts Ordering' SFM "453561440013"
    When I Choose to capture 'ASO number'
    #    ##SAP VERIFICATION STEP && SAP PGI
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "<TCode>" T Code in the I2M SAP application
    When I Choose to Search "ASO-Item" in Order Field
    When I Choose to Click "Item-Overview" Tab of "ASO-Item" Window
    When I Choose to Select ASO Item
    When I Choose to Select "Sales Document and Deliver" Menu Item
    When I Choose to Click "Picking" Tab of "ASO-Delivery" Window
    When I Choose to Update Picking Quantity
    When I Choose to Select "Extras Serialize Number" Menu Item
    When I Choose to Pack ASO Delivery Items
    When I Choose to Update Packing Materials
    When I Choose to update Identification in ASO Delivery Handling
    When I Choose to Click on Back Menu Bar
    When I Choose to Pack each ASO Delivery Items
    When I Choose to enter "/nvl02n" Delivery in the SAP application
    When I Choose to Search "ASO-Delivery" in Order Field
    When I Choose to Post ASO Goods Issues
     Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "/niw33" in search menu bar
    When I Choose to enter SAP SWO Number
    When I Choose to Verify Material Only WorkOrder in SAP
    When I Choose to Verify Status bar
    When I Choose to Verify SAP Document

    Examples: 
      | UserRole     | Account                      | submitPSE | IP       | TCode |
      # | ServiceAgent | FUNDACIÓN DE LA GESTIÓN SANITARIA | No        | 74624450 |va03|
      # | ServiceAgent | FUNDACIÓN DE LA GESTIÓN SANITARIA | No        | 88309498 |va03 |
      | ServiceAgent | Sahrudaya HealthCare Private | No        | 77003537 | va03  |
