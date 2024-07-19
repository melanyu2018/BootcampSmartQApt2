Feature: Login on nopCommerce

  As a new user
  I want to login
  So that ...

  @scenario1
  Scenario: Successful login with valid credentials
    Given user is on Home Page
    When user navigate to login page
    And user enters valid credentials
    Then user can see a logout link


  @scenario2
  Scenario: Successful login with params
    Given user is on Home Page
    When user navigate on "https://demo.nopcommerce.com/login"
    And user enters username "Melany.meylin04@gmai.com" and password "Melany.meylin04@gmai.com"
    Then user can see a logout link

  @scenario3
  Scenario: Successful logout
    When user click on logout