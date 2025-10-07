Feature: This feature is to test the urbuddi app

  Scenario: Login to the urbuddi app
    Given the urbuddi app name "urbuddi"
    And enter the username "twl4admin@gmail.com" and pasword "twl4test"
    And click on the login
    Then user logged in sucessfully
    When user click on the Leave
    And enter leave details "November" "15" to "November" "17"
    Then leave should be submit sucessfully