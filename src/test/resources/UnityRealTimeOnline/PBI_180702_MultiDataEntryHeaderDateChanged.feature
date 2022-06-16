Feature: Multi Data Entry Header change to Date - SP58 180702
  Scenario: (1) Validate header for MTPDE date header should be Date
    Given user is logged in Data Entry
    When  User is in Multi Test Point Data Entry page
    Then  The header for date on the grid is Date

  Scenario: (2) Validate header for MTSDE date header should be Date
    Given user is logged in Data Entry
    When  User is in Multi Test Summary Data Entry page
    Then  The header for MTSDE date on the grid is Date

  Scenario: (3) Validate header for STPDE date header should be Date Entered
    Given user is logged in Data Entry
    When  User is in Single Test Point Data Entry page
    Then  The header for STPDE date on the grid is Date Entered

  Scenario: (4) Validate header for STSDE date header should be Date Entered
    Given user is logged in Data Entry
    When  User is in Single Test Summary Data Entry page
    Then  The header for STSDE date on the grid is Date Entered


