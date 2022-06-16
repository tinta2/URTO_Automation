Feature: Allow zero and negative entries in Data Entry - SP58 235724
  //Run GenericTest 0, 0.1, 0.2 as PRECONDITION
  Scenario: (1) Allow zero in STPDE in levels 1
    Given user is logged in STPDE
    When  User enters zero in level1
    Then  User is able to save the zero value

  Scenario: (2) Allow zero in STPDE in levels 3
    Given user is logged in STPDE
    When User enters zero in level_2 and level_3
    Then  User is able to save the zero values in level3 and level9


