Feature: Login functionality for VyTrack Application

  User Story:
  As a user, I should be able to login with valid credentials to different accounts. And dashboard should be displayed.
  Accounts are: driver, sales manager, store manager.

  Scenario: Test login as driver, sales manager, and store manager
    Given user is on the login page
    When user log in as the "Store Manager"
    Then user should see the title "Dashboard"

  Scenario Outline: Log in with valid credentials as a user
    Given User is on the VYTrack login page
    When User enters valid "<username>" username
    And User enters valid "<password>" password
    Then User should see the dashboard as a "<user>"

    Examples:
      | user          | username        | password    |
      | driver        | User1           | UserUser123 |
      | sales manager | salesmanager120 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |

