Feature: This Feauture is for clcok


  Scenario: This scenario to set a alarm in a clock
    Given the clock is on
    When I set an alarm for "8"hr "30"min
    Then the alarm should be set for "8:30 pm"