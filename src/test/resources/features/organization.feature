Feature: Manage crud operations for organization and sub organization

@SmokeTest1
  Scenario: verify add organization and save
    Given user is on Home page of application and login
    When click on organization button fill details and save
        | Action |
        | Add    |
    Then verify saved organization on grid 
   
@SmokeTest1
  Scenario: verify edit organization and save
    Given user is on Home page of application and login
    When click on three dot icon and update details
        | Action |
        | Edit   |
    Then update organization and verify
    
@SmokeTest1
  Scenario: delete organization and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete
        | Action |
        | Delete |
    Then verify deleted organization
    
@SmokeTest
  Scenario: verify add sub organization and save
    Given user is on Home page of application and login
    When click on sub organization button and fill details
    Then save sub organization and verify
   
@SmokeTest
  Scenario: verify edit sub organization and save
    Given user is on Home page of application and login
    When click on three dot icon and change details
    Then save sub organization and verify
    
@SmokeTest
  Scenario: delete sub organization and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete
    Then verify deleted sub organization
    
@SmokeTest
  Scenario: search organization or sub organization and verify result on grid
    Given user is on Home page of application and login
    When input organization name in search input field
    Then verify searched result