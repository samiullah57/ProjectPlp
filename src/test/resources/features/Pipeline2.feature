Feature: Phase2 Automation R2R

@437325
  Scenario Outline: 437325: Scenario32 - Test to verify SLA metrics with respect to case and WO and automatic generation of CSR on case closure.
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole1>"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    #When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    When I Choose to 'Parts Ordering' SFM "453561440013"
    When I Choose to capture 'ASO number'
    ##SAP VERIFICATION STEP && SAP PGI
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
    #Then I Choose to log out of the application
    Given I Choose to Start LeanFT Run time engine
    Given I Choose to launche to SAP application
    When I Choose to enter "iw33" in search menu bar
    When I Choose to enter SAP SWO Number
    When I Choose to Verify Material Only WorkOrder in SAP
    When I Choose to Verify Status bar
    When I Choose to Verify SAP Document
    Then I Choose to Confirm Delivery
    Then I Choose to log out of the application

    Examples: 
      | UserRole     | Account                           | submitPSE | IP       | TCode |
      # | ServiceAgent | FUNDACIÓN DE LA GESTIÓN SANITARIA | No        | 74624450 |va03|
      # | ServiceAgent | FUNDACIÓN DE LA GESTIÓN SANITARIA | No        | 88309498 |va03 |
      | ServiceAgent | Sahrudaya HealthCare Private | No        | 77003537 | va03  |
      
  @1497151
  Scenario Outline: 1497151:Test to verify that agent is able to order parts from different watchlist categories which are requested from service user during follow-up WO
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    Then I Choose to verify profile for Logged on user "Service Agent"
    When I Choose "<IP>" from search list
    When I Choose to create Case of Event Type "Incident" and Event Sub Type "Incident" on Installed Product
    When I Choose to Open Case and create safety questionnaire "No"
    When I Choose to Open Case From Service Quote Detail Page
    When I Choose to Create Onsite Work Order SFM
    When I Choose to Initiate SWO
    Then I Choose to Dispatch WO Using Service Board "<Technician>"
    Then I Choose to log out of the application
    When I Choose to enter credentials for "<R2Rautomationtech>"
    When I Choose to Search Work Order using global search box
    When I Choose to Initiate Onsite SFM
    When I CHoose to Debrief and Follow up and "Create Follow up Activity"

    Examples: 
      | UserRole     | IP       | R2Rautomationtech | Technician            |
      | ServiceAgent | 98070141 | R2Rautomationtech | Automation Technician |

 
