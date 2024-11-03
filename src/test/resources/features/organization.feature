Feature: Manage crud operations for organization and sub organization

@SmokeTest
  Scenario: verify add organization and save
    Given user is on Home page of application and login
    When click on organization button fill details and save
        | Action |
        | Add    |
    Then verify saved organization on grid 
    
@SmokeTest
  Scenario: search organization or sub organization and verify result on grid
    Given user is on Home page of application and login
    Then input org name in search input field and verify searched result
   
@SmokeTest
  Scenario: verify edit organization and save
    Given user is on Home page of application and login
    When click on three dot icon and update details
        | Action |
        | Edit   |
    Then update organization and verify
       
@SmokeTest
  Scenario: verify add sub organization and save
    Given user is on Home page of application and login
    When click on sub organization button and fill details and save
        | Action |
        | AddSub |
    Then verify sub organization
   
@SmokeTest
  Scenario: verify edit sub organization and save
    Given user is on Home page of application and login
    When click on three dot icon and change sub org details
        | Action  |
        | EditSub |
    Then verify updated sub organization

@SmokeTest1
  Scenario: verify add member and save
    Given user is on Home page of application and login
    When click on add member button fill details and save
        | Action |
        | Add    |
    Then verify added member in organization

@SmokeTest
  Scenario: verify edit member and save
    Given user is on Home page of application and login
    When click on three dot icon and change member details
        | Action |
        | Edit   |
    Then verify updated member in organization
     
@SmokeTest
  Scenario: delete member and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete member
        | Action |
        | Delete |
    Then verify deleted member
     
@SmokeTest
  Scenario: delete sub organization and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete sub org
        | Action    |
        | DeleteSub |
    Then verify deleted sub organization
    
@SmokeTest
  Scenario: delete organization and verify
    Given user is on Home page of application and login
    When click on three dot icon and delete org
        | Action |
        | Delete |
    Then verify deleted organization