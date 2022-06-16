Feature: 115244 AuditTrail should add a record showing an event for which a lab is deleted by a user
  Scenario:  Add Lab should be recorded in AuditTrail report
     Scenario:  (1-115244) Delete Lab should be recorded in AuditTrail report
      Given user is logged in
      And  User is on the lab page
      When user deletes '341136' Lab
      Then the deleted lab is recorded in AuditTrail

  Scenario: (2-115244) Event filter in Audit Trail has Delete Lab
    Given user is logged in
    And User is on AuditTrail page
    When User expands the Event dropdown list
    Then Delete Lab event is listed

  Scenario: (3-115244) LabNumber filter in AuditTrail has 341136
    Given user is logged in
    And User is on AuditTrail page
    When User expands the Lab Number dropdown list
    Then Lab number 341134 is selected

  Scenario: (4-115244) Filter Lab Number 341136 and Event Delete Lab displays Delete Lab Info in the grid
    Given user is logged in
    And User is on AuditTrail page
    When Filters Lab Number and Event dropdown list
    Then the grid displays lab number and event Delete Lab



