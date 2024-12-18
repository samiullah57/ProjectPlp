Feature: IP Staging

  @437535
  Scenario Outline: 437535: Verify IP Staging Improvements
    Given I launch ServiceMax application successfully
    When I Choose to enter credentials for "<UserRole>"
    And I choose to update "<Functional_Location>" Name for Staging
    Given I choose to login to SAP system
    When I choose to read all the SAP data required for Tc "437535"
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment1"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment1"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment2"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment2"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment3"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment3"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment4"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment4"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment5"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment5"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment6"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment6"
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<TcreEqp>"
    When I choose to enter reference equipment Number "Equipment7"
    And I choose to select tab"<tabName>"and"<tableName>"
    And I choose to enter Serial Number
    And I choose to save the updated the record
    And I choose navigate back to previousPage
    When User enters T Code in SAP application as"<Tcode1>"
    And I choose to enter the program name"<programName>"
    And I choose to sync equipment to smax
    And I choose to Execute the selected Variant
    And I choose to verify Created IP stage is "Error" in SMAX for "Equipment7"
    And I choose to Rewoke "<Functional_Location>" Name for Processing
    And I choose to access "IP Staging" tab
    And I choose to update the "Auto IP1" Filter details
    And I choose to perform force update for "Equipment1"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment1" Details after IP Processing
    And I choose to update the "IP2 and IP3" Filter details
    And I choose to perform force update for "Equipment2"
    And I choose to perform force update for "Equipment3"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment2" Details after IP Processing
    And I choose to verify "Equipment3" Details after IP Processing
    And I choose to update the "Auto IP4 and IP5" Filter details
    And I choose to perform force update for "Equipment4"
    And I choose to perform force update for "Equipment5"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment4" Details after IP Processing
    And I choose to verify "Equipment5" Details after IP Processing
    And I choose to update the "Auto IP6 and IP7" Filter details
    And I choose to perform force update for "Equipment6"
    And I choose to perform force update for "Equipment7"
    And I choose to select all IPs and click process IP
    And I choose to verify "Equipment6" Details after IP Processing
    And I choose to verify "Equipment7" Details after IP Processing
    When I choose to close SAP Application
    Then I Choose to log out of the application

    Examples: 
      | UserRole        | TcreEqp | tabName | tableName       | Tcode1 | programName         | Functional_Location |
      | MasterDataAdmin | /nie01  | SerData | CreateEquipment | /nse38 | ZR_CS_EQUIP_EXTRACT | ES100026-001-03--7  |
