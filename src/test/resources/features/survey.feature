Feature: Manage survey scenario

@SmokeTest
  Scenario: verify add survey and save
    Given user is on Home page of application and login
    And navigate to settings page
    When fill details in add survey popup and save
        | Action    |
        | AddSurvey |
    Then verify saved survey 
    
@SmokeTest
  Scenario: verify edit survey and save
    Given user is on Home page of application and login
    And navigate to settings page
    When fill details in edit survey popup and save
        | Action     |
        | EditSurvey |
    Then verify saved survey
    
@SmokeTest
  Scenario: verify delete survey
    Given user is on Home page of application and login
    And navigate to settings page
    When perform survey delete action
        | Action       |
        | DeleteSurvey |
    Then verify deleted survey