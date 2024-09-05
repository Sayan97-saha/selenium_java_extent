Feature: Testing the Parabank website

  @test
  Scenario Outline: Testing the new user Registration UI functionality
    Given User is preparing to test "<keyword>"
    #When User closes the login popup
    #Then test step_two
    When User clicks on the "Register" link

    Examples: 
      | keyword |
      | test_1  |
      | test_2  |
