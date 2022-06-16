Feature: Instrument Setup - SP58 117416
#  Scenario: (1) 117416 Default test none selected
#    Given user is logged in
#    And  User is in Instrument Setup page
#    When user select instrument
#    Then Select None button is disabled
#    And Select All button is enabled

  @smoke
  Scenario: (2) 117416 Select test will enable 'Select None' button
    Given user is logged in
    And User is in Instrument Setup page
    When user select instrument
    Then Select None button is disabled

  @smoke
  Scenario: (3) 117416 Test with Slide Gen the SG column displays when test is selected
     Given user is logged in
     And User is in Instrument Setup page
     When user selects instrument with slide gen
     Then the SG column value exist

    @smoke
  Scenario: (4) 117416 Create Creatinine test from Instrument Setup
     Given user is logged in
     And User is in Instrument Setup page
     When user select instrument
     And user selects a test from the grid
     And user clicks the OK button
     Then test is added to Open Test


