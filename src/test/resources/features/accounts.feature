Feature: Accounts page verification

  User Story:
  As a store manager should be able to see customer's account on accounts page.
    AC1: Verify that the customers listed on accounts page.
    AC2: Verify View Per Page dropdown has 4 options: 10, 25, 50, 100


Scenario: Store manager can view customer accounts on accounts page

  Given User is on the VYTrack log-in page
  When User enters valid username and password
  And User clicks to the accounts page
  And User is on the Accounts page
  Then User should see a list of customers

Scenario: View Per Page dropdown option verification

  Given User is on the VYTrack log-in page
  When User enters valid username and password
  When User clicks to the accounts page
  And User is on the Accounts page
  Then User sees below options under View Per Page dropdown

    | 10  |
    | 25  |
    | 50  |
    | 100 |
