Feature: Allow zero and negative entries in Data Entry - SP58 235724
  Scenario: (0) Precondition Add NBR Lot with 9 levels
    Given User is login in Lot Page
    When  User creates Non-Bio-rad Lot
    Then Lot is added to Open lots list

  Scenario: (0.1) Precondition Add test to NBR Lot
    Given User is login in Test
    When  User clicks the Inst Setup button
    And   User selects Roche Cobas 6000 instrument
    And   User selects Uric Acid test
    Then  test is created successfully

  Scenario: (0.2) Precondition Configure Rule Settings 1-2s[W] and 1-3s Rules
    Given User is login in RuleSettings
    When  User configures Rules Settings lab lot test
    And   user applies rules
    Then  Rules are applied to the test

#  Scenario: (0.3) Precondition Configure Fixed Mean/SD and Settings
#    Given User is login in RuleSettings
#    When  User configures Settings


  Scenario: (0.4) Precondition Configure Fixed Mean/SD
    Given User is login in RuleSettings
    When User clicks Fixed Mean and SD tab
    And   user applied fixed SD to all levels in use
    And   user applied fixed mean to all levels in use

#  Scenario: (0.5) Precondition Configure Imprecision BV
#    Given User is login in AG Imprecision BV
#    When  User selects Use this application to evaluate preformance
#    And   User selects Manually enter target value
#    And   user applied target values to all levels in use and save

  Scenario: 1 - User creates a secondary lab
    Given  User is login Lab Page
    When User enters lab information
    Then lab is created