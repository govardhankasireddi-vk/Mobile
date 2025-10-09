Feature: This feature is to test the urbuddi app

  Background:
    Given the urbuddi app name "urbuddi"
    And enter the username "twl4admin@gmail.com" and pasword "twl4test"
    And click on the login
    Then user logged in sucessfully

  Scenario: This scenario is to apply the Leave request in the urbuddi app
    When user click on the Leave
    And enter leave details "November" "15" to "November" "17"
    Then leave should be submit sucessfully

    Scenario: This scenario is to approve the leave request in the urbuddi app
      When user click on the Leave
      And user click on the Leave Requests
      And Approve the Leave
      Then leave should be approve

  Scenario: This scenario is to reject the leave request in the urbuddi app
    When user click on the Leave
    And user click on the Leave Requests
    And reject the Leave
    Then leave should be rejected

  Scenario: This scenario is to reject the leave request in the urbuddi app
    When user click on the work
    And user click on the apply work
    And enter the work details
    Then work should be added
