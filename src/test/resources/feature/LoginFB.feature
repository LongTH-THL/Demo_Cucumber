Feature: Login to Facebook
  As a user, I want to be able to log into the FB system
  So that I can manage customer information

  @tag1
  Scenario: Successful login
    Given Get login page "chrome" in "https://www.facebook.com/"
    When I enter my username and password
    And I click the Login button
    Then I should be taken to the Dashboard page
    And I should see the "Customers" menu

  @tag2
  Scenario Outline: Login failed
    Given I am on the login page "chrome" in "https://www.facebook.com/"
    When I enter username as "<nUser>"
    And I enter password as "<password>"
    And I click Login button
    Then Login should fail
    Then Close browser
    Examples: Page titles
      | nUser      | password |
      | 0366025807 |          |
      |            | 1234567  |
      |            |          |
      | 0366025807 | 1234567  |