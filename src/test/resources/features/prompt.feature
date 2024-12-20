Feature: Manage prompt scenario

@SmokeTest
  Scenario: verify add prompt and save
    Given user is on Home page of application and login
    And navigate to settings page
    When fill details in add prompt popup and save
        | Action    |
        | AddPrompt |
    Then verify saved prompt 
    
@SmokeTest
  Scenario: verify edit prompt and save
    Given user is on Home page of application and login
    And navigate to settings page
    When fill details in add prompt popup and save
        | Action     |
        | EditPrompt |
    Then verify saved prompt
    
@SmokeTest
  Scenario: verify delete prompt
    Given user is on Home page of application and login
    And navigate to settings page
    When perform delete action
        | Action       |
        | DeletePrompt |
    Then verify deleted prompt