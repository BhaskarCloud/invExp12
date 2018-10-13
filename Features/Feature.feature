Feature: Chek functionality on Activity page of Application

  @First
  Scenario: Test login with credentials
    Given Open the Firefox and launch the application
    When Enter the Username and Password
    Then Home Page is loaded

  @Second
  Scenario: Activity page Test login with credentials
    Given Home Page is loaded and verified
    When I click on activty link
    Then Activity Page is displayed and Default date filter verified
