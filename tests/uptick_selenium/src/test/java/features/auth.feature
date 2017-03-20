@test


Feature: Check authorisation on Uptick

  Scenario: check authorisation with Личный кабинет
    Given I open create Page
    And I enter first name: "first name4"
    And I enter last name: "last name4"
    And I enter company: "company"
    And I enter email: "emaidlgggg@gmail.com"
    And I enter mobile phone: "89999999999"
    And I enter password: "q"
    And I enter confirm password: "q"
    When I click button with name Create Account
    And  I click button with name Load Demo data
    And  I click button on menu profile
    And I click button with name Sign Out
    Then I should be see button with name Sign In
